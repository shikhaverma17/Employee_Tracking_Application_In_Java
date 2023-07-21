package com.ineuron.project;

import java.util.Scanner;

public class Employee
{
	
	private Integer emp_id;
	private String emp_name;
	private String project_name;
	private Address address;
	
	
	public Employee(Integer emp_id, String emp_name, String project_name, Address address) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.project_name = project_name;
		this.address = address;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	void register()
	{
		Scanner scan= new Scanner(System.in);
		System.out.println("Please, enter your details:");
		System.out.println("Enter your Name::");
		emp_name=scan.next();
		System.out.println("Enter your Project Name::");
		project_name=scan.next();
		System.out.println("Enter your State::" +address.getState());
		System.out.println("Enter your City::" +address.getCity());
		System.out.println("Enter your Street::" +address.getStreet());
		System.out.println("Enter your ZipCode::" +address.getZipCode());
	}
	
}
