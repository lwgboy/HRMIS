/**
 * 
 */
package com.brainstrongtech.hrmis.domain;

/**
 * @author ����
 *
 */
public class ManagerAccount {
	
	/**�û���*/
	private String name;
	
	/**�û�����*/
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return password;
	}
	public void setPassWord(String passWord) {
		this.password = passWord;
	}
	
	@Override
	public String toString() {
		return name+":"+password;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null) return false;
		if(obj==this) return true;
		if(!(obj instanceof ManagerAccount))
			return false;
		
		ManagerAccount managerAccount = (ManagerAccount)obj;
		
		return managerAccount.equals(name);
	}
	
	/**
	 * ���ַ�����װ�ɶ���
	 * @param strInfo �ַ���
	 * @return �����˻���
	 */
	public static ManagerAccount parseManagerInfoStr(String strInfo){
		ManagerAccount managerAccount = new ManagerAccount();
		
		String[] secs = strInfo.split("\\:");
		
		managerAccount.setName(secs[0]);
		managerAccount.setPassWord(secs[1]);
		
		return managerAccount;
	}

}
