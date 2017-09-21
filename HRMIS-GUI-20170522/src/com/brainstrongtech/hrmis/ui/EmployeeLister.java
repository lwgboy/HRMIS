/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;

/**
 * 全部员工信息输出界面
 * @author 田宇
 *
 */
public class EmployeeLister implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {

		EmployeeService employeeServive = new EmployeeServiceImpl();
		
		if(!employeeServive.listEmps().isEmpty()){
		for(Employee emp:employeeServive.listEmps())
			emp.normalPrint();
		}else{
			System.out.println("No data!");
		}

	}

}
