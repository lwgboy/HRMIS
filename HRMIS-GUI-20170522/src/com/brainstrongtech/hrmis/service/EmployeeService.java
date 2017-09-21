/**
 * 
 */
package com.brainstrongtech.hrmis.service;

import java.util.List;
import java.util.Set;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.domain.ManagerAccount;

/**
 * @author 田宇
 *
 */
public interface EmployeeService {
	
	/**
	 * 加载所有员工信息
	 * @return 员工信息列表
	 */
	List<Employee> listEmps();
	
	/**
	 * 员工信息排序
	 * @return 排序后的员工信息列表
	 */
	Set<Employee> sortEmps();
	
	/**
	 * 增加员工信息
	 * @param emp
	 */
	void enrollEmployee(Employee emp);
	
	/**
	 * 通过关键字查找员工信息
	 * @param keyWord 关键字
	 * @return 员工信息列表
	 */
	List<Employee> serchedEmpsByKeyWord(String keyWord);
	
	/**
	 * 通过工号删除员工信息
	 * @param payRoll 工号
	 */
	void deletEmployeeByPayRoll(String payRoll);
	
	/**
	 * 通过工号查找员工信息
	 * @param payRoll 员工信息
	 * @return
	 */
	Employee serchedEmpsByPayRoll(String payRoll);
	
	/**
	 * 修改员工信息
	 * @param oldEmp 要修改的员工信息
	 * @param NewEmp 修改后的员工信息
	 */
	void alterEmployee(Employee oldEmp,Employee NewEmp);

}
