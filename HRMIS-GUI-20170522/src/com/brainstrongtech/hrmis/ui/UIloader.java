/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import com.brainstrongtech.hrmis.exception.HRMISException;

/**
 * 
 * UIģ�����
 * @author ����
 *
 */
public class UIloader {
	
	/**
	 * UIģ�����
	 * @param type UI����
	 * @return
	 */
	public static BaseUI load(UIType type){
		
		if(type.equals(UIType.MAINMENU)){
			return new MainMenu();
		}else if(type.equals(UIType.EMP_LISTER)){
			return new EmployeeLister();
		}else if(type.equals(UIType.EMP_FORMATTEDLISTER)){
			return new EmployeeSorttedLister();
		}else if(type.equals(UIType.EMP_ENROLL)){
			return new EmployeeEnroller();
		}else if(type.equals(UIType.EXIT)){
			return new EmployeeExiter();
		}else if(type.equals(UIType.EMP_SIMPLE_LISTER)){
			return new EmployeeSimpleLister();
		}else if(type.equals(UIType.EMP_FORMATTED_SIMPLE_LISTER)){
			return new EmployeeFormattedSimpleLister();
		}else if(type.equals(UIType.EMP_SERCHED_LISTER)){
			return new EmployeeSerchedLister();
		}else if(type.equals(UIType.EMP_DELETION)){
			return new EmployeeDeletion();
		}else if(type.equals(UIType.EMP_MODIFICATION)){
			return new EmployeeModification();
		}else if(type.equals(UIType.MANAGER_ENROLL)){
			return new ManagerEnroller();
		}
		
		throw new HRMISException("UI���Ͳ�ƥ�䣬�޷���ȷ����UIģ�飡");
	}
	
	/**
	 * UIģ������
	 * @param type UI����
	 */
	public static void runUI(UIType type){
		UIloader.load(type).run();;
	}

}
