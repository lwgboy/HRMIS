/**
 * 
 */
package com.brainstrongtech.hrmis;

import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.ui.Login;
import com.brainstrongtech.hrmis.ui.UIType;
import com.brainstrongtech.hrmis.ui.UIloader;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * 
 * ϵͳ������
 * @author ����
 *
 */
public class SysLoader {

	/**
	 * ϵͳ�������
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Login();
		
		try{
		   SysUtils.checkSource();
		}catch(HRMISException e){
			System.out.println(e.getMessage());
		}
//		UIloader.runUI(UIType.MAINMENU);
	}

}
