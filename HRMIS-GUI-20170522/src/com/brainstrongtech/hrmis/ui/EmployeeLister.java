/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;

/**
 * ȫ��Ա����Ϣ�������
 * @author ����
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
