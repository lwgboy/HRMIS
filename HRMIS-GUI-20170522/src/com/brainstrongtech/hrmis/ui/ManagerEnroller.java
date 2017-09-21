/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.util.HashSet;
import java.util.Set;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.domain.ManagerAccount;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.RollRepeatedException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.service.ManagerService;
import com.brainstrongtech.hrmis.service.ManagerServiceImpl;
import com.brainstrongtech.hrmis.utils.SecretKeyUtils;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * ����Ա�˻���Ϣ¼��
 * @author ����
 *
 */
public class ManagerEnroller implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {
		boolean isContinue = true;

		while (isContinue) {
			
			ManagerAccount managerAccount = ManagerEnroller.enrollManager();

			ManagerService managerService = new ManagerServiceImpl();
			managerService.addManager(managerAccount);
			System.out.println("\nRecord Saved !");

			if (SysUtils.pauseChoose("Add another manager record? (y)es or (n)o, ")) {
				continue;
			} else {
				isContinue = false;
			}
		}

	}

	/**
	 * �����������Ϣ��
	 * ¼��һ������Ա�˻� 
	 * @return ����Ա�˻�
	 */
	public static ManagerAccount enrollManager(){
		ManagerAccount managerAccount = new ManagerAccount();
		
		managerAccount.setName(ManagerEnroller.checkEnrollName());
		managerAccount.setPassWord(ManagerEnroller.checkPassword());
		
		return managerAccount;
		
	}
	
	/**
	 * ¼�����Ա�˻���
	 * @return ����Ա�˻���
	 */
	private static String checkEnrollName() {
		String enRollName = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Enter name:");

			try {
				enRollName = SysUtils.getEntry(false);
				isRepeatedRoll(enRollName);                                          //����Ƿ��Ѵ���roll
				if(SysUtils.checkFormat(FormatValidator.REGEX_MANAGER_NAME, enRollName)){
				    isContinue = false;
				}else
					SysUtils.pause("User name can contain characters or alphabet or underline!");
			} catch (BlankEntryException e) {
				SysUtils.pause("No  entered �C try again !");
			}  catch(RollRepeatedException e){
				SysUtils.pause("Entered name already exists,please entry it again... ");
			}
		}

		return enRollName;
	}
	
	/**
	 * ¼�����Ա�˻�����
	 * @return ����Ա�˻�����
	 */
	private static String checkPassword() {
		String password = null;
		boolean isContinue = true;

		while (isContinue) {

			System.out.print("Enter password:");

			try {
				password = SysUtils.getEntry(false);
				if(SysUtils.checkFormat(FormatValidator.REGEX_MANAGER_NAME, password)){
				    isContinue = false;
				}else
					SysUtils.pause("Password can contain characters or alphabet or underline!");
			} catch (BlankEntryException e) {
				SysUtils.pause("No  entered �C try again !");
			}  
		}

		return password;
	}
	
	/**
	 * ͨ���˻����ж�һ������Ա�˻���Ϣ�Ƿ����
	 * @param enRollName ����Ա�˻���
	 * @return �����׳�һ��¼���ظ��쳣�����򷵻���
	 */
	private static boolean isRepeatedRoll(String enRollName){
		ManagerAccount managerAccount = new ManagerAccount();
		ManagerService managerService = new ManagerServiceImpl();
		Set<ManagerAccount> managerSet = new HashSet<ManagerAccount>(managerService.loadManagers());
		
		managerAccount.setName(enRollName);
		
		if(!managerSet.add(managerAccount)){
			throw new RollRepeatedException();
		}else
			return true;
	}
}
