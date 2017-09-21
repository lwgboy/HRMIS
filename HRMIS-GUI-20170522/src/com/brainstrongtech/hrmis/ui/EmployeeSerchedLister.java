/**
 * 
 */
package com.brainstrongtech.hrmis.ui;

import java.util.ArrayList;
import java.util.List;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.exception.BlankEntryException;
import com.brainstrongtech.hrmis.exception.NoFindedException;
import com.brainstrongtech.hrmis.service.EmployeeService;
import com.brainstrongtech.hrmis.service.EmployeeServiceImpl;
import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * Ա����Ϣ��ѯ����
 * @author ����
 *
 */
public class EmployeeSerchedLister implements BaseUI {

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.ui.BaseUI#run()
	 */
	@Override
	public void run() {
		
		List<Employee> empList = this.getEmps();
		
		if (!empList.isEmpty()){
			System.out.print("\n");
			for (Employee emp : empList)
				System.out.println(emp);
		}
	}
	
	/**
	 * ���ҵ���Ա����Ϣ
	 * @return Ա���б�
	 */
	private List<Employee> getEmps(){
		
		String keyWord = null;
		boolean isContinue = true;
		List<Employee> empList = new ArrayList<Employee>();
		EmployeeService employeeService = new EmployeeServiceImpl();
		
		while(isContinue){
			
			System.out.print("Enter keyword:");
			
			try{
			   keyWord = SysUtils.getEntry(false);
			   empList = employeeService.serchedEmpsByKeyWord(keyWord);  
			   isContinue = false;
			}catch(BlankEntryException e){
				System.out.println("\nNo keyword entered �C try again�� \n");
			}catch(NoFindedException e){
				System.out.println("Keyword �C "+keyWord+" - not found ");
				isContinue = false;
			}
		}
		
		return empList;
	}
	

}
