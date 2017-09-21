/**
 * 
 */
package com.brainstrongtech.hrmis.service;

import java.util.List;

import com.brainstrongtech.hrmis.dao.ManagerDao;
import com.brainstrongtech.hrmis.dao.ManagerDaoTxtImpl;
import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.domain.ManagerAccount;
import com.brainstrongtech.hrmis.exception.NoFindedException;

/**
 * @author ÃÔ”Ó
 *
 */
public class ManagerServiceImpl implements ManagerService {

	@Override
	public ManagerAccount getManagerByName(String name) {
		
			ManagerDao managerDao = new ManagerDaoTxtImpl();
			
			ManagerAccount managerAccount = new ManagerAccount();
			List<ManagerAccount> managerList = managerDao.loadManagers();
			
			for(ManagerAccount management:managerList){
			    if(management.getName().equals(name)){		
			        managerAccount = management;
			        return managerAccount;
			    }
			}
			throw new NoFindedException();		
	}

	@Override
	public List<ManagerAccount> loadManagers() {
		ManagerDao managerDao = new ManagerDaoTxtImpl();
		return managerDao.loadManagers();
	}

	@Override
	public void addManager(ManagerAccount managerAccount) {
		ManagerDao managerDao = new ManagerDaoTxtImpl();
		managerDao.addManager(managerAccount);
	}

}
