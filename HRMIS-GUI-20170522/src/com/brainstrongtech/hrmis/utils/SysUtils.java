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
 * 系统通用工具类
 * @author 田宇
 *
 */
public class SysUtils {

	/**
	 * 
	 * 日期格式化输出
	 * @param date输入日期
	 * @return
	 */
	public static String formattedDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
	}

	/**
	 * 
	 * 控制台读取信息
	 * @param canBlank 是否支持空输入
	 * @return
	 */
	public static String getEntry(boolean canBlank) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;

		try {
			entry = buffer.readLine();
			if (!canBlank) {
				if (entry == null || entry.trim().length() == 0)
					throw new BlankEntryException("没有输入信息！");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new DataAccessException("控制台信息录入失败！");
		}

		return entry;
	}
	
	/**
	 * 
	 * 空输入提示并允许空输入
	 * @param message 提示消息
	 */
	public static void pause(String message){
		System.out.print(message);
		SysUtils.getEntry(true);
	}
	
	/**
	 * 允许空输入录入
	 */
	public static void pause(){
		System.out.println();
		SysUtils.getEntry(true);
	}
	
	/**
	 * 暂停选择
	 * @param message 提示消息
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
	 * 字符串转换成日期格式
	 * @param str 日期字符串
	 * @return 日期
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
	 * 存储文件检测
	 */
	public static void checkSource(){
		File file = new File("e:/records.txt");
		
		if(!file.exists())
			throw new HRMISException("ployee information data file not found! Now exit!");
	}
	
	/**
	 * 检查各式是否正确
	 * @param regex 格式模板
	 * @param str 字符串
	 * @return 适合 返回true，否则返回false
	 */
	public static boolean checkFormat(String regex,String str){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		return matcher.matches();
	}
	
}
