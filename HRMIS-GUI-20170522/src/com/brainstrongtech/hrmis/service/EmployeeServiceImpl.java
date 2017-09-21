/**
 * 
 */
package com.brainstrongtech.hrmis.service;

import java.util.List;
import java.util.Set;

import com.brainstrongtech.hrmis.dao.EmployeeDao;
import com.brainstrongtech.hrmis.dao.EmployeeDaoTxtImpl;
import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.domain.ManagerAccount;
import com.brainstrongtech.hrmis.exception.NoFindedException;

/**
 * @author ÃÔ”Ó
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.service.EmployeeService#loadEmp()
	 */
	@Override
	public List<Employee> listEmps() {
		EmployeeDao employeeDao = new EmployeeDaoTxtImpl();
		return employeeDao.loadEmps();
	}

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.service.EmployeeService#sortEmp()
	 */
	@Override
	public Set<Employee> sortEmps() {
		EmployeeDao employeeDao = new EmployeeDaoTxtImpl();
		return employeeDao.sortEmps();
	}

	@Override
	public void enrollEmployee(Employee emp) {
		EmployeeDao employeeDao = new EmployeeDaoTxtImpl();
		employeeDao.addEmp(emp);
		
	}

	@Override
	public List<Employee> serchedEmpsByKeyWord(String keyWord) {
		EmployeeDao employeeDao = new EmployeeDaoTxtImpl();
		return employeeDao.serchedEmpsByKeyWord(keyWord);
	}

	@Override
	public void deletEmployeeByPayRoll(String payRoll) {
		EmployeeDao employeeDao = new EmployeeDaoTxtImpl();
		
        Employee emp = this.serchedEmpsByPayRoll(payRoll);
		List<Employee> empList = employeeDao.loadEmps();
		empList.remove(emp);
		employeeDao.clear();
		employeeDao.saveEmps(empList); 
		
	}

	@Override
	public Employee serchedEmpsByPayRoll(String payRoll) {
		
		EmployeeDao employeeDao = new EmployeeDaoTxtImpl();
		
		Employee emp = new Employee();
		List<Employee> emps = employeeDao.loadEmps();
		
		for(Employee ep:emps){
		    if(ep.getPayrollNo().equals(payRoll)){		
		        emp = ep;
		        return emp;
		    }
		}
	    throw new NoFindedException();	
	}

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.service.EmployeeService#alterEmpByPayRoll(java.lang.String)
	 */
	@Override
	public void alterEmployee(Employee oldEmp,Employee NewEmp) {
		EmployeeDao employeeDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = employeeDao.loadEmps();
		int index = 0;
		
		for(Employee ep:empList){
			if(ep.getPayrollNo().equals(oldEmp.getPayrollNo())){
				break;
			}
			index++;
		}
		
		empList.remove(oldEmp);
		empList.add(index,NewEmp);
		
		employeeDao.clear();
		employeeDao.saveEmps(empList);
		
	}

}
