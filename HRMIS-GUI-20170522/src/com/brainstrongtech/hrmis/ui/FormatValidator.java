/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

/**
 * @author 田宇
 *
 */
public class FormatValidator {
	
	/**
	 * 工号格式
	 */
	public static final String REGEX_ROLL_NUM = "\\d{3}";
	
	/**
	 * 电话格式
	 */
	public static final String REGEX_PHONE_NUM = "^0[2-8]{1}-[1-9]{1}\\d{7}$";
	
	/**
	 * 姓氏格式
	 */
	public static final String REGEX_LAST_NAME = "^[a-zA-Z,\\s]+$";
	
	/**
	 * 名字格式
	 */
	public static final String REGEX_FIRST_NAME ="^[a-zA-Z,\\s]+$";
	
	/**
	 * INIT格式
	 */
	public static final String REGEX_INIT = "^[A-Za-z](\\s)?+$";
	
	/**
	 * 部门号格式
	 */
	public static final String REGEX_DEPT_NUM = "^[1-9]{1,3}$";
	
	/**
	 * 工作岗位格式
	 */
	public static final String REGEX_JOB_TITLE = "^[a-zA-Z,\\s]+$";
	
	/**
	 * 用户名格式
	 */
	public static final String REGEX_MANAGER_NAME = "^[\\w]{1,12}+$";

}
