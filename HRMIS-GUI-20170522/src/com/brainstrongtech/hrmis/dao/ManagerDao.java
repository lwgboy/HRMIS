/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.util.List;

import com.brainstrongtech.hrmis.domain.ManagerAccount;

/**
 * @author 田宇
 *
 */
public interface ManagerDao {
	
	/**
	 * 加载所有管理员账户信息
	 * @return 管理员账户信息列表
	 */
	List<ManagerAccount> loadManagers();
	
	/**
	 * 添加管理员账户
	 * @param managerAccount 
	 */
	void addManager(ManagerAccount managerAccount);

}
