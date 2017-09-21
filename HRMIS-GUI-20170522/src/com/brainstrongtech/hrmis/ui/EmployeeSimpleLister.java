/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;

/**
 * 输出姓名和电话界面
 * @author 田宇
 *
 */
public class EmployeeSimpleLister implements BaseUI {

	@Override
	public void run() {
		
		EmployeeService employeeServive = new EmployeeServiceImpl();
		
		for(Employee emp:employeeServive.listEmps())
			emp.simplePrint();
		
	}

}
