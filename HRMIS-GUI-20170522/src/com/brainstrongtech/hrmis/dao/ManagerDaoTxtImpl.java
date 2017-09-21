/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.brainstrongtech.hrmis.domain.ManagerAccount;
import com.brainstrongtech.hrmis.utils.SecretKeyUtils;

import sun.misc.BASE64Decoder; 
import sun.misc.BASE64Encoder; 
/**
 * @author ÃÔ”Ó
 *
 */
public class ManagerDaoTxtImpl implements ManagerDao {

	private static final File MANAGER_INFO_FILE = new File("e:/user.txt");
	
	@Override
	public List<ManagerAccount> loadManagers() {
		BASE64Decoder base64decoder = new BASE64Decoder();
		List<ManagerAccount> managerList = new ArrayList<ManagerAccount>();
		BufferedReader buffer = null;
		
		try {
			buffer = new BufferedReader(new InputStreamReader(new FileInputStream(MANAGER_INFO_FILE)));
			String managerInfo = null;
			while((managerInfo = buffer.readLine())!=null){
				byte[] encodeByte = base64decoder.decodeBuffer(managerInfo);
				String temp = new String(SecretKeyUtils.decryptMode(encodeByte));
				managerList.add(ManagerAccount.parseManagerInfoStr(temp));}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return managerList;
	}


	@Override
	public void addManager(ManagerAccount managerAccount) {
		PrintWriter writer=null;
		BASE64Encoder base64encoder = new BASE64Encoder();
		try {
			writer = new PrintWriter(new FileOutputStream(MANAGER_INFO_FILE,true));
			String str =  base64encoder.encode(SecretKeyUtils.encryptMode(managerAccount.toString().getBytes()));
			writer.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.flush();
			writer.close();
		}
		
	}	

}
