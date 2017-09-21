/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;

/**
 * ����������
 * ���Ա�������͵绰����
 * @author ����
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
