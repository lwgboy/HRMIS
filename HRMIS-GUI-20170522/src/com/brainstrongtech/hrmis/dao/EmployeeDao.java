/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.util.List;
import java.util.Set;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.domain.ManagerAccount;

/**
 * @author 田宇
 *
 */
public interface EmployeeDao {

	/**
	 * 加载员工信息
	 * @return 员工信息列表
	 */
	List<Employee> loadEmps();
	
	/**
	 * 按LastName排序的员工信息
	 * @return 员工信息列表
	 */
	Set<Employee> sortEmps();
	
	/**
	 * 增加员工信息
	 */
	void addEmp(Employee emp);
	
	/**
	 * 通过关键字查找员工信息
	 * @param keyWord 关键字
	 * @return 员工列表
	 */
	List<Employee> serchedEmpsByKeyWord(String keyWord);

	
	/**
	 * 保存员工信息
	 * @param empList 员工信息列表
	 */
	void saveEmps(List<Employee> empList);
	
	/**
	 * 清除所有信息
	 */
	void clear();

}
