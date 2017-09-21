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
 * 系统启动类
 * @author 田宇
 *
 */
public class SysLoader {

	/**
	 * 系统启动入口
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
