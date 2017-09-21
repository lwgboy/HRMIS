/**
 * 
 */
package com.brainstrongtech.hrmis.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import com.brainstrongtech.hrmis.utils.SysUtils;

/**
 * 员工类
 * @author 田宇
 *
 */
/**
 * @author 田宇
 *
 */
public class Employee extends ValueObject implements Comparable<Employee>,Serializable {
	
	/**雇员编号*/
	private String  payrollNo;
	
	/**电话号码*/
	private String  telephoneNum;
	
	/**姓氏*/
	private String  lastName;
	
	/**名字*/
	private String  firstName;
	
	/**职位*/
	private String  initial;
	
	/**部门编号*/
	private Integer deptNo;
	
	/**职位名*/
	private String  jobTitle;
	
	/**入职时间*/
	private Date    hiringDate;
	
	public String getPayrollNo() {
		return payrollNo;
	}
	public void setPayrollNo(String payrollNo) {
		this.payrollNo = payrollNo;
	}
	public String getTelephoneNum() {
		return telephoneNum;
	}
	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Date getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	
	@Override
	public String toString() {
		return this.payrollNo+":"+this.telephoneNum+":"+this.lastName+":"+this.firstName+":"+
	           this.initial+":"+this.deptNo+":"+this.jobTitle+":"+SysUtils.formattedDate(this.hiringDate);
	}
	
	/**
	 * 员工对象正常打印输出
	 * */
	public void normalPrint(){
		System.out.println(this);
	}
	
	/**
	 * 员工对象格式化打印输出
	 * */
	public void formattedPrint(){
		String out = String.format("%-10s%-10s%-4s%-5s%-15s%-4d%-20s%-20s",this.lastName,this.firstName
				     ,this.initial,this.payrollNo,this.telephoneNum,this.deptNo,this.jobTitle
				     ,SysUtils.formattedDate(this.hiringDate));
		System.out.println(out);
	}
	
	/**
	 * 员工对象简易打印输出
	 * */
	public void simplePrint(){
		System.out.println(this.lastName+","+this.firstName+","+this.telephoneNum);
	}
	
	/**
	 * 员工对象格式化简易打印输出
	 * */
	public void simpleFormattedPrint(){
		String out = String.format("%-10s%-10s%-10s", this.lastName,this.firstName,this.telephoneNum);
		System.out.println(out);
	}
	
	/**
	 * 字符串封装成对象
	 * @param empInfo 有着对象信息的字符串
	 * @return 员工对象
	 */
	public static Employee parseEmpInfoStr(String empInfo){
		Employee emp = new Employee();
		
		String[] secs = empInfo.split("\\:");
		emp.setPayrollNo(secs[0]);
		emp.setTelephoneNum(secs[1]);
		emp.setLastName(secs[2]);
		emp.setFirstName(secs[3]);
		emp.setInitial(secs[4]);
		emp.setDeptNo(Integer.valueOf(secs[5]));
		emp.setJobTitle(secs[6]);
		try{
			emp.setHiringDate(SysUtils.parseDate(secs[7]));
		}catch(ParseException e){
			e.getStackTrace();
			System.out.println("Invalid Date Hired!");
		}
		
		return emp;
	}
	
	/* 
	 * 按姓氏升序排序
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee otherEmployee) {
		return this.lastName.compareTo(otherEmployee.lastName);
	}
	
    @Override
    public boolean equals(Object obj) {
    	
		if(obj==null) return false;
		if(obj==this) return true;
		if(!(obj instanceof Employee))
			return false;
		Employee emp = (Employee)obj;
		
    	return this.payrollNo.equals(emp.payrollNo);
    }
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.payrollNo.hashCode();
	}
}
