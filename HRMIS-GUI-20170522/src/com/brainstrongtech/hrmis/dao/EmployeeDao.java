/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.util.List;
import java.util.Set;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.domain.ManagerAccount;

/**
 * @author ����
 *
 */
public interface EmployeeDao {

	/**
	 * ����Ա����Ϣ
	 * @return Ա����Ϣ�б�
	 */
	List<Employee> loadEmps();
	
	/**
	 * ��LastName�����Ա����Ϣ
	 * @return Ա����Ϣ�б�
	 */
	Set<Employee> sortEmps();
	
	/**
	 * ����Ա����Ϣ
	 */
	void addEmp(Employee emp);
	
	/**
	 * ͨ���ؼ��ֲ���Ա����Ϣ
	 * @param keyWord �ؼ���
	 * @return Ա���б�
	 */
	List<Employee> serchedEmpsByKeyWord(String keyWord);

	
	/**
	 * ����Ա����Ϣ
	 * @param empList Ա����Ϣ�б�
	 */
	void saveEmps(List<Employee> empList);
	
	/**
	 * ���������Ϣ
	 */
	void clear();

}
