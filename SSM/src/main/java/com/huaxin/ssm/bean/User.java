package com.huaxin.ssm.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class User {
	private String userid;		
	private String name;
	private String pwd;
	private String sex;
	private Date birthday;
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	private String birthdays;
	private Integer age;
	private BigDecimal salary;
	private int intid;
	
	
	public String getBirthdays() {
		return birthdays;
	}
	public void setBirthdays(String birthdays) {
		this.birthdays = birthdays;
	}
	public int getIntid() {
		return intid;
	}
	public void setIntid(int intid) {
		this.intid = intid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", pwd=" + pwd + ", sex=" + sex + ", birthday=" + birthday
				+ ", age=" + age + ", salary=" + salary + "]";
	}

	
}
