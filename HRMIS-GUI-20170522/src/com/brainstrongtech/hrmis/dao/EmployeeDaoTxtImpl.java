/**
 * 
 */
package com.brainstrongtech.hrmis.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.brainstrongtech.hrmis.domain.Employee;
import com.brainstrongtech.hrmis.domain.ManagerAccount;
import com.brainstrongtech.hrmis.exception.NoFindedException;

/**
 * @author 田宇
 *
 */
public class EmployeeDaoTxtImpl implements EmployeeDao {

	private static final File EMP_INFO_FILE = new File("e:/records.txt");
	
	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.dao.EmployeeDao#loadEmp()
	 */
	@Override
	public List<Employee> loadEmps() {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		BufferedReader buffer = null;
		
		try {
			buffer = new BufferedReader(new InputStreamReader(new FileInputStream(EMP_INFO_FILE)));
			String empInfo = null;
			while((empInfo = buffer.readLine())!=null){
			employeeList.add(Employee.parseEmpInfoStr(empInfo));}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return employeeList;
		
	}

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.dao.EmployeeDao#sortEmps()
	 */
	@Override
	public Set<Employee> sortEmps() {
		
		Set<Employee> empSet = new TreeSet<Employee>(this.loadEmps());
		return empSet;
	}

	@Override
	public void addEmp(Employee emp) {
		PrintWriter writer=null;
		try {
			writer = new PrintWriter(new FileOutputStream(EMP_INFO_FILE,true));
			String str = emp.toString();
			writer.println(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			writer.flush();
			writer.close();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.brainstrongtech.hrmis.dao.EmployeeDao#serchedEmpsByKeyWord(java.lang.String)
	 */
	@Override
	public List<Employee> serchedEmpsByKeyWord(String keyWord) {
		
		String UpperKeyWord = keyWord.toUpperCase();
		LineNumberReader lnr = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		
		try {
			lnr = new LineNumberReader(new FileReader(EMP_INFO_FILE));
			String readLine = null;
            try {
				while((readLine =lnr.readLine()) != null){  
				    int index = 0;  
				    int next = 0;  
				    int times = 0;//出现的次数  
				    
				    while((index = readLine.toUpperCase().indexOf(UpperKeyWord,next)) != -1) {  //判断次数  
				        next = index + UpperKeyWord.length();  
				        times++;  
				    }  
				    if(times > 0) {  
				    	employeeList.add(Employee.parseEmpInfoStr(readLine)); 
				    }  
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				lnr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(!employeeList.isEmpty()){
			return employeeList;
		}else{
			throw new NoFindedException();
		}
	}

	@Override
	public void saveEmps(List<Employee> empList) {
		
		for(Employee emp:empList){
			this.addEmp(emp);
		}

	}

	@Override
	public void clear() {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(EMP_INFO_FILE));
			bw.write("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
