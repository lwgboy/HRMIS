/**
 * 
 */
package com.brainstrongtech.hrmis.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.DataAccessException;
import com.brainstrongtech.hrmis.exception.HRMISException;
import com.brainstrongtech.hrmis.ui.FormatValidator;

/**
 * 
 * ϵͳͨ�ù�����
 * @author ����
 *
 */
public class SysUtils {

	/**
	 * 
	 * ���ڸ�ʽ�����
	 * @param date��������
	 * @return
	 */
	public static String formattedDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
	}

	/**
	 * 
	 * ����̨��ȡ��Ϣ
	 * @param canBlank �Ƿ�֧�ֿ�����
	 * @return
	 */
	public static String getEntry(boolean canBlank) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;

		try {
			entry = buffer.readLine();
			if (!canBlank) {
				if (entry == null || entry.trim().length() == 0)
					throw new BlankEntryException("û��������Ϣ��");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new DataAccessException("����̨��Ϣ¼��ʧ�ܣ�");
		}

		return entry;
	}
	
	/**
	 * 
	 * ��������ʾ�����������
	 * @param message ��ʾ��Ϣ
	 */
	public static void pause(String message){
		System.out.print(message);
		SysUtils.getEntry(true);
	}
	
	/**
	 * ���������¼��
	 */
	public static void pause(){
		System.out.println();
		SysUtils.getEntry(true);
	}
	
	/**
	 * ��ͣѡ��
	 * @param message ��ʾ��Ϣ
	 * @return Y/N
	 */
	public static Boolean pauseChoose(String message){
		System.out.print(message);
		if(SysUtils.getEntry(false).toUpperCase().equals("Y")){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * �ַ���ת�������ڸ�ʽ
	 * @param str �����ַ���
	 * @return ����
	 * @throws ParseException 
	 */
	public static Date parseDate(String str) throws ParseException{
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			sdf.setLenient(false);
			date = sdf.parse(str);
		
		    return date;
	}

	/**
	 * �洢�ļ����
	 */
	public static void checkSource(){
		File file = new File("e:/records.txt");
		
		if(!file.exists())
			throw new HRMISException("ployee information data file not found! Now exit!");
	}
	
	/**
	 * ����ʽ�Ƿ���ȷ
	 * @param regex ��ʽģ��
	 * @param str �ַ���
	 * @return �ʺ� ����true�����򷵻�false
	 */
	public static boolean checkFormat(String regex,String str){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
	
}
