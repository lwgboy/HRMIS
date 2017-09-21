/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.RollRepeatedException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * Ա����Ϣ¼�����
 * @author ����
 *
 */
public class EmployeeEnroller implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {

		System.out.println("\n\n�˰���Ѷ �C Employee Records: ");
		System.out.println("======================================\n");
		System.out.println("Employee Record Additions:\n");
		System.out.println("Enter the following details of the new employee:\n");
		System.out.println("Employee 3 digit payroll number ");
		System.out.println("Phone Number ");
		System.out.println("Last Name ");
		System.out.println("First Name ");
		System.out.println("Middle Init ");
		System.out.println("Dept # ");
		System.out.println("Job Title ");
		System.out.println("Date Hired \n");

		boolean isContinue = true;

		while (isContinue) {
			
			Employee emp = EmployeeEnroller.enrollEmployee(false);

			EmployeeService empService = new EmployeeServiceImpl();
			empService.enrollEmployee(emp);
			System.out.println("\nRecord Saved !");

			if (SysUtils.pauseChoose("Add another employee record? (y)es or (n)o, ")) {
				continue;
			} else {
				isContinue = false;
			}
		}
	}
	
	/**
	 * Ա����Ϣ�Ǽ�
	 * @return Ա����Ϣ
	 */
	public static Employee enrollEmployee(boolean isRepeat){
		
		Employee emp = new Employee();
		emp.setPayrollNo(EmployeeEnroller.checkEnrollCode(isRepeat));
		emp.setTelephoneNum(EmployeeEnroller.checkPhoneNum());
		emp.setLastName(EmployeeEnroller.checkLastName());
		emp.setFirstName(EmployeeEnroller.checkFirstName());
		emp.setInitial(EmployeeEnroller.checkInitialAlp());
		emp.setDeptNo(EmployeeEnroller.checkDeptNum());
		emp.setJobTitle(EmployeeEnroller.checkJobTitle());
		emp.setHiringDate(EmployeeEnroller.checkDate());
		
		return emp;
	}
	
	/**
	 * ���payrollNo����
	 * @return payrollNo
	 */
	private static String checkEnrollCode(boolean isRepeat) {
		String enRollCode = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Employee 3 digit payroll number:");

			try {
				enRollCode = SysUtils.getEntry(false);
				if(!isRepeat)
					isRepeatedRoll(enRollCode);                                          //����Ƿ��Ѵ���roll
				if(SysUtils.checkFormat(FormatValidator.REGEX_ROLL_NUM, enRollCode)){
				    isContinue = false;
				}else
					SysUtils.pause("Payroll number can contain only numerical characters !");
			} catch (BlankEntryException e) {
				SysUtils.pause("No payroll number entered �C try again !");
			}  catch(RollRepeatedException e){
				SysUtils.pause("Entered number already exists,please entry it again... ");
			}
		}

		return enRollCode;
	}
	
	
	/**
	 * ����绰���벢���
	 * @return �绰����
	 */
	public static String checkPhoneNum(){
		String phoneNum = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Enter Phone Number (02-12345678):");

			try {
				phoneNum = SysUtils.getEntry(false);
				if(SysUtils.checkFormat(FormatValidator.REGEX_PHONE_NUM, phoneNum)){
				    isContinue = false;
				}else{
					SysUtils.pause("Invalid phone number �C try again !");
				}
			} catch (BlankEntryException e) {
				SysUtils.pause("No payroll number entered �C try again !");
			} 
		}

		return phoneNum;
	}
	
	/**
	 * �������
	 * @return ����
	 */
	public static String checkLastName(){
		String lastName = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Enter Last Name:");

			try {
				lastName = SysUtils.getEntry(false);
				if(SysUtils.checkFormat(FormatValidator.REGEX_LAST_NAME, lastName)){
				    isContinue = false;
				}else{
					SysUtils.pause("Last name can contain only alphabetical characters and spaces");
				}
			} catch (BlankEntryException e) {
				SysUtils.pause("No last name entered �C try again !");
			} 
		}

		return lastName;
	}
	
	/**
	 * �������
	 * @return ����
	 */
	public static String checkFirstName(){
		String firstName = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Enter First Name:");

			try {
				firstName = SysUtils.getEntry(false);
				if(SysUtils.checkFormat(FormatValidator.REGEX_FIRST_NAME, firstName)){
				    isContinue = false;
				}else{
					SysUtils.pause("Last name can contain only alphabetical characters and spaces");
				}
			} catch (BlankEntryException e) {
				SysUtils.pause("No last name entered �C try again !");
			} 
		}

		return firstName;
	}
	
	/**
	 * ���INIT
	 * @return init
	 */
	public static String checkInitialAlp(){
		String initialAlp = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Enter Middle Init:");

			try {
				initialAlp = SysUtils.getEntry(false).trim();
				if(SysUtils.checkFormat(FormatValidator.REGEX_INIT, initialAlp)){
				    isContinue = false;
				}else{
					SysUtils.pause("Middle Init can contain only alphabetical characters and spaces");
				}
			} catch (BlankEntryException e) {
				SysUtils.pause("No Middle Init entered �C try again !");
			} 
		}

		return initialAlp;
	}
	
	/**
	 * ��ⲿ�ű��
	 * @return ���ű��
	 */
	public static Integer checkDeptNum() {
		String deptNum = null;
		Integer DeptNo = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Enter Dept #");

			try {
				deptNum = SysUtils.getEntry(false);
				if(SysUtils.checkFormat(FormatValidator.REGEX_DEPT_NUM, deptNum)){
				    isContinue = false;
				}else
					SysUtils.pause("Dept # can contain only digits with no spaces ");
			} catch (BlankEntryException e) {
				SysUtils.pause("No Dept# entered �C try again !");
			} 
		}

		return Integer.parseInt(deptNum);
	}
	
	/**
	 * ���ְλ����
	 * @return ְλ����
	 */
	public static String checkJobTitle(){
		String jobTitle = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Enter Job Title:");

			try {
				jobTitle = SysUtils.getEntry(false);
				if(SysUtils.checkFormat(FormatValidator.REGEX_JOB_TITLE, jobTitle)){
				    isContinue = false;
				}else{
					SysUtils.pause("Job title can contain only alphabetical characters and spaces");
				}
			} catch (BlankEntryException e) {
				SysUtils.pause("No Job title entered �C try again !");
			} 
		}

		return jobTitle;
	}
	
	/**
	 * �������
	 * @return ����
	 */
	public static Date checkDate(){
		String entryDate = null;
		Date date = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Enter Date Hired:");

			try {
				entryDate = SysUtils.getEntry(false);
                date = SysUtils.parseDate(entryDate);
                isContinue = false;
			} catch (BlankEntryException e) {
				SysUtils.pause("No Job title entered �C try again !");
			} catch(ParseException e){
				System.out.println("Invalid Date Hired!");
			}
		}

		return date;
	}
	
	/**
	 * ��⹤���Ƿ��ظ�
	 * @param enRoll ����
	 * @return 
	 */
	private static boolean isRepeatedRoll(String enRoll){
		Employee emp = new Employee();
		EmployeeService empService = new EmployeeServiceImpl();
		Set<Employee> empSet = new HashSet<Employee>(empService.sortEmps());
		
		emp.setPayrollNo(enRoll);
		
		if(!empSet.add(emp)){
			throw new RollRepeatedException();
		}else
			return true;
	}
	


}
