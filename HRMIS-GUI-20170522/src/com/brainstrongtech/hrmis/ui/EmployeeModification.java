/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.NoFindedException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * 员工信息修改
 * @author 田宇
 *
 */
public class EmployeeModification implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {
		
		boolean isContinue = true;

		while (isContinue) {

			if (this.AlterEmp()) {

				System.out.println("\nAlter successfully!");

				if (SysUtils.pauseChoose("Alter another one? (y)es or (n)o,  ")) {
					continue;
				} else {
					isContinue = false;
				}
			} else {
				isContinue = false;
				 SysUtils.pause("\nPress Enter to continue...");
			}
		}
	}
	
	/**
	 * 修改员工
	 * @return 修改成功返回真，否则抛出异常
	 */
	private boolean AlterEmp() {
		EmployeeService employeeService = new EmployeeServiceImpl();
		boolean isContinue = true;
		String enRollCode = null;

		while (isContinue) {
			System.out.print("Enter employee’s 3 digit payroll number to enable record modification:");

			try {
				enRollCode = SysUtils.getEntry(false);
				if (SysUtils.checkFormat(FormatValidator.REGEX_ROLL_NUM, enRollCode)) {
					Employee oldEmp = employeeService.serchedEmpsByPayRoll(enRollCode);
					System.out.println("\n" + oldEmp+"\n");

					Employee newEmp = ModificationMenu.selectAlterOption(oldEmp);
					employeeService.alterEmployee(oldEmp, newEmp);
					return true;
				} else {
					SysUtils.pause("Payroll number can contain only numerical characters !");
				}
			} catch (BlankEntryException e) {
				System.out.println("No payroll number entered – try again ");
				continue;
			}catch(NoFindedException e){
				System.out.println("\nEmployee record for "+ enRollCode +" not found!");
				return false;
			}
		}
		return false;
	}

}
