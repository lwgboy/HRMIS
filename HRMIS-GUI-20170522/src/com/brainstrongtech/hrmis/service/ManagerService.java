/**
 * 
 */
package com.brainstrongtech.hrmis.service;

import java.util.List;

import com.brainstrongtech.hrmis.domain.ManagerAccount;

/**
 * @author ����
 *
 */
public interface ManagerService {
	
	/**
	 * ͨ���˻�����ȡһ������Ա�˻�����
	 * @param name �˻���
	 * @return ����Ա�˻�
	 */
	ManagerAccount getManagerByName(String name);
	
	/**
	 * �������й���Ա�˻���Ϣ
	 * @return �����˻���Ϣ
	 */
	List<ManagerAccount> loadManagers();
	
	/**
	 * ��ӹ���Ա�˻���Ϣ
	 * @param managerAccount ����Ա�˻�
	 */
	void addManager(ManagerAccount managerAccount);

}
