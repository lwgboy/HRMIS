/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.util.List;

import com.brainstrongtech.hrmis.domain.ManagerAccount;

/**
 * @author ����
 *
 */
public interface ManagerDao {
	
	/**
	 * �������й���Ա�˻���Ϣ
	 * @return ����Ա�˻���Ϣ�б�
	 */
	List<ManagerAccount> loadManagers();
	
	/**
	 * ��ӹ���Ա�˻�
	 * @param managerAccount 
	 */
	void addManager(ManagerAccount managerAccount);

}
