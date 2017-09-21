/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.util.Date;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.DataAccessException;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * @author 泬迻
 *
 */
public class ModificationMenu  {


	public static Employee selectAlterOption(Employee emp) {
		
		String telePhoneNum = emp.getTelephoneNum();
		String lastName = emp.getLastName();
		String firstName = emp.getFirstName();
		String init = emp.getInitial();
		String jobTitle = emp.getJobTitle();
		Integer deptNum = emp.getDeptNo();
		Date    date = emp.getHiringDate();
		
		Employee newEmp = new Employee();
		boolean isContinue = true;

		while (isContinue) {

			System.out.println(" What do you want to alter by following?");
			System.out.println("1 - TelePhone Number");
			System.out.println("2 每 Last Name");
			System.out.println("3 每 First Name");
			System.out.println("4 每 Initial");
			System.out.println("5 - Department Number");
			System.out.println("6 - Job Title");
			System.out.println("7 每 Hire Date\n");
			System.out.print("Your Selection:");

			try {
				String entry = SysUtils.getEntry(false);
				switch (entry.toUpperCase().charAt(0)) {
				case '1':telePhoneNum = EmployeeEnroller.checkPhoneNum();
					break;
				case '2':lastName = EmployeeEnroller.checkLastName();
					break;
				case '3':firstName = EmployeeEnroller.checkFirstName();
					break;
				case '4':init = EmployeeEnroller.checkInitialAlp();
					break;
				case '5':deptNum = EmployeeEnroller.checkDeptNum();
					break;
				case '6':jobTitle = EmployeeEnroller.checkJobTitle();
					break;
				case '7':date = EmployeeEnroller.checkDate();
					break;
				default:
					SysUtils.pause("Invalid code! Press Enter to continue＃");
				}
				if (SysUtils.pauseChoose("Alter another? (y)es or (n)o,  ")) {
					continue;
				} else {
					newEmp.setPayrollNo(emp.getPayrollNo());
					newEmp.setTelephoneNum(telePhoneNum);
					newEmp.setLastName(lastName);
					newEmp.setFirstName(firstName);
					newEmp.setInitial(init);
					newEmp.setDeptNo(deptNum);
					newEmp.setJobTitle(jobTitle);
					newEmp.setHiringDate(date);
					
					isContinue = false;
					
					return newEmp;
				}
			} catch (BlankEntryException e) {
				SysUtils.pause("No selection entered. Press Enter to continue＃");
				continue;
			} catch (DataAccessException e) {
				System.out.println(e.getMessage());
			}
		}
		return emp;
	}
}
