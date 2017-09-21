/**
 * 
 */
package com.brainstrongtech.hrmis.service;

import java.util.List;
import java.util.Set;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.domain.ManagerAccount;

/**
 * @author ����
 *
 */
public interface EmployeeService {
	
	/**
	 * ��������Ա����Ϣ
	 * @return Ա����Ϣ�б�
	 */
	List<Employee> listEmps();
	
	/**
	 * Ա����Ϣ����
	 * @return ������Ա����Ϣ�б�
	 */
	Set<Employee> sortEmps();
	
	/**
	 * ����Ա����Ϣ
	 * @param emp
	 */
	void enrollEmployee(Employee emp);
	
	/**
	 * ͨ���ؼ��ֲ���Ա����Ϣ
	 * @param keyWord �ؼ���
	 * @return Ա����Ϣ�б�
	 */
	List<Employee> serchedEmpsByKeyWord(String keyWord);
	
	/**
	 * ͨ������ɾ��Ա����Ϣ
	 * @param payRoll ����
	 */
	void deletEmployeeByPayRoll(String payRoll);
	
	/**
	 * ͨ�����Ų���Ա����Ϣ
	 * @param payRoll Ա����Ϣ
	 * @return
	 */
	Employee serchedEmpsByPayRoll(String payRoll);
	
	/**
	 * �޸�Ա����Ϣ
	 * @param oldEmp Ҫ�޸ĵ�Ա����Ϣ
	 * @param NewEmp �޸ĺ��Ա����Ϣ
	 */
	void alterEmployee(Employee oldEmp,Employee NewEmp);

}
