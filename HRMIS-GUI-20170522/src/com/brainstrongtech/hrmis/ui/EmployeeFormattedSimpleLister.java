/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;

/**
 * 按姓名排序
 * 输出员工姓名和电话界面
 * @author 田宇
 *
 */
public class EmployeeFormattedSimpleLister implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {
		
		EmployeeService employeeServive = new EmployeeServiceImpl();
		
		for(Employee emp:employeeServive.sortEmps())
			emp.simpleFormattedPrint();

	}

}
