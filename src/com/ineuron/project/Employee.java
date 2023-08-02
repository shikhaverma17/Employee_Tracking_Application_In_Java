package com.ineuron.project;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import in.ineuron.util.JDBC_Util;

public class Employee
{
	
	private Integer emp_id;
	private String emp_name;
	private String project_name;
	private Address address;
	
	
	public void showData()
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Driver loaded succesfully....");
			
			// load username and password properties from file
			Properties properties = new Properties();
	    	FileInputStream fis=new FileInputStream("C:\\Users\\Sid\\Desktop\\Java_learning\\GitRepos\\IneuronAssignments\\Employee_Tracking_Application_In_Java\\application.properties");
	    	properties.load(fis);
				//Step1. Load and register the Driver

			//Step2. Establish the Connection with database
			/*
			 * String url = "jdbc:mysql://localhost:3306/aliens"; //username and password
			 * would vary from user to user String userName = "root"; String passWord =
			 * "root";
			 */
			String url = properties.getProperty("url") ;
			String userName = properties.getProperty("username");
			String passWord = properties.getProperty("password");
			
			connection = DriverManager.getConnection(url, userName, passWord);
			System.out.println("connection established succesfully...");
			System.out.println("The implement class name is " + connection.getClass().getName());
			
			//Step3. Create statement Object and send the query
			String sqlSelectQuery = "select * from employee";
			statement = connection.createStatement();
			System.out.println("The implementation class name is ::" + statement.getClass().getName());
			resultSet = statement.executeQuery(sqlSelectQuery);
			System.out.println("The implementation class name is ::" + resultSet.getClass().getName());
			System.out.println();
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			
			//Step4. Process the resultSet
			while (resultSet.next()) {
				Integer eid = resultSet.getInt(1);
				String ename = resultSet.getString(2);
				String state = resultSet.getString(3);
				String street = resultSet.getString(4);
				String city = resultSet.getString(5);
				String zipcode = resultSet.getString(6);
				String etype = resultSet.getString(7);
				Integer depttype = resultSet.getInt(8);
				
				System.out.println(eid + "\t" + ename + "\t" + state
						+ "\t" + street + "\t" + city + "\t" + zipcode 
						+ "\t" + etype + "\t" + depttype );
			}
		}
			
			//catch (ClassNotFoundException ce){
			//ce.printStackTrace();
			//}
					catch(SQLException se)
					{
						se.printStackTrace();
						}
					catch(Exception e)
					{
						e.printStackTrace();
						}
					
					finally
					{
						//closing the resources
								if (connection!=null)
									{
										try
											{
											connection.close();
											System.out.println("Connection closed...");
											}
										catch (SQLException se)
											{
												se.printStackTrace();
											}
										} 
								}
			
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
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", project_name=" + project_name + ", address="
				+ address + "]";
	}
	
	
}
