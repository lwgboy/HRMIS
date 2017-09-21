/**
 * 
 */
package com.brainstrongtech.hrmis.service;

import java.util.List;

import com.brainstrongtech.hrmis.domain.ManagerAccount;

/**
 * @author 田宇
 *
 */
public interface ManagerService {
	
	/**
	 * 通过账户名获取一个管理员账户对象
	 * @param name 账户名
	 * @return 管理员账户
	 */
	ManagerAccount getManagerByName(String name);
	
	/**
	 * 加载所有管理员账户信息
	 * @return 所有账户信息
	 */
	List<ManagerAccount> loadManagers();
	
	/**
	 * 添加管理员账户信息
	 * @param managerAccount 管理员账户
	 */
	void addManager(ManagerAccount managerAccount);

}
