/**
 * 
 */
package com.brainstrongtech.hrmis.test;

import com.brainstrongtech.hrmis.service.ManagerService;
import com.brainstrongtech.hrmis.service.ManagerServiceImpl;

/**
 * @author ÃÔ”Ó
 *
 */
public class Tester2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ManagerService managerService = new ManagerServiceImpl();
		System.out.println(managerService.getManagerByName("123"));

	}

}
