/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

/**
 * @author ����
 *
 */
public class FormatValidator {
	
	/**
	 * ���Ÿ�ʽ
	 */
	public static final String REGEX_ROLL_NUM = "\\d{3}";
	
	/**
	 * �绰��ʽ
	 */
	public static final String REGEX_PHONE_NUM = "^0[2-8]{1}-[1-9]{1}\\d{7}$";
	
	/**
	 * ���ϸ�ʽ
	 */
	public static final String REGEX_LAST_NAME = "^[a-zA-Z,\\s]+$";
	
	/**
	 * ���ָ�ʽ
	 */
	public static final String REGEX_FIRST_NAME ="^[a-zA-Z,\\s]+$";
	
	/**
	 * INIT��ʽ
	 */
	public static final String REGEX_INIT = "^[A-Za-z](\\s)?+$";
	
	/**
	 * ���źŸ�ʽ
	 */
	public static final String REGEX_DEPT_NUM = "^[1-9]{1,3}$";
	
	/**
	 * ������λ��ʽ
	 */
	public static final String REGEX_JOB_TITLE = "^[a-zA-Z,\\s]+$";
	
	/**
	 * �û�����ʽ
	 */
	public static final String REGEX_MANAGER_NAME = "^[\\w]{1,12}+$";

}
