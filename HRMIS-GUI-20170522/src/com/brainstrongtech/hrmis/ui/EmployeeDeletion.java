/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.util.List;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.NoFindedException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * 员工信息删除界面
 * @author 田宇
 *
 */
public class EmployeeDeletion implements BaseUI {

	@Override
	public void run() {
		
		System.out.println("\n兴邦资讯 – Employee Records:");
		System.out.println("======================================");
		System.out.println("Employee Record Deletion:");

		boolean isContinue = true;
		while (isContinue) {

			if (this.delete()) {

				System.out.println("Record deleted.");

				if (SysUtils.pauseChoose("Delete another? (y)es or (n)o,  ")) {
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
	 * 根据输入的工号
	 * 删除员工记录
	 */
	private boolean delete() {

		String enRollCode = null;
		EmployeeService employeeService = new EmployeeServiceImpl();
		Employee emp = null;
		boolean isContinue = true;

		do {
			System.out.print("\nEnter employee’s 3 digit payroll number to enable record deletion: ");

			try {
				enRollCode = SysUtils.getEntry(false);
				if (SysUtils.checkFormat(FormatValidator.REGEX_ROLL_NUM, enRollCode)) {
					emp = employeeService.serchedEmpsByPayRoll(enRollCode);

					System.out.println("\n" + emp + "\n");

					if (SysUtils.pauseChoose("Confirm record deletion, (y)es or (n)o, ")) {
						isContinue = false;
						employeeService.deletEmployeeByPayRoll(enRollCode);
						return true;
					} else {
						isContinue = true;
					}
				} else {
					SysUtils.pause("Payroll number can contain only numerical characters !");
				}
			} catch (NoFindedException e) {
				System.out.println("\nEmployee record for " + enRollCode + " not found! ");
				return false;
			} catch (BlankEntryException e) {
				System.out.println("No payroll number entered – try again ");
				isContinue = true;
			}
		} while (isContinue);
		
		return false;
	}
}
