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
	private String emp_type;
	
	Employee()
	{
		
	}
	
	Employee(String ename, Address add, String etype)
	{
		this.emp_name = ename;
		this.address = add;
		this.emp_type = etype;
	}

	public void registerEmployee()
	{
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		Scanner s1 = null;
		
		String username1 = null;
		String street1 = null;
		String city1 = null;
		String state1 = null;
		String zipcode = null;
		String emptype = null;
		
		try 
		{
			connection = JDBC_Util.getJDBCConnection();			
			if(connection != null)
			{
				//Step3. Create Preparedstatement Object and send the query
				String sqlEmpInsertQuery
				= "insert into employee (`ename`,`state`,`street`,`city`,`zipcode`,`etype`) values(?,?,?,?,?,?) ";
				System.out.println("sql query iniciated ");
				pst = connection.prepareStatement(sqlEmpInsertQuery);
				s1 = new Scanner(System.in);
				
				System.out.println("Enter the username :: ");
				username1 = s1.nextLine();
				
				System.out.println("Enter the state :: ");
				state1 = s1.nextLine();
				
				System.out.println("Enter the street :: ");
				street1 = s1.nextLine();
				
				System.out.println("Enter the city :: ");
				city1 = s1.nextLine();
				
				System.out.println("Enter the zipcode :: ");
				zipcode = s1.nextLine();
				
				System.out.println("Enter the emp type :: ");
				emptype = s1.nextLine();
				
				Address a1 = new Address(street1,city1, state1, zipcode);
				Employee emp2 = new Employee(username1, a1, emptype);
				System.out.println(a1);
				System.out.println(emp2);
				System.out.println("***********************************");
			
				if(pst != null)
					{
					pst.setString(1, emp2.getEmp_name());
					pst.setString(2, a1.getState());
					pst.setString(3, a1.getStreet() );
					pst.setString(4, a1.getCity());
					pst.setString(5, a1.getZipCode());
					pst.setString(6, emp2.getEmp_type());
					
					int rowsAffected = pst.executeUpdate();
					
					System.out.println("Number of rows affected is : - " +rowsAffected);
					System.out.println("Sending back to display screen - ");
					Display d0123 = new Display();
					d0123.choiceOfEmp();
				}
				else
				{
					System.out.println("pst object is null!!!");
				}		
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			//closing the resources
			try
			{
				JDBC_Util.closeConnection(resultSet, pst, pst, connection);;
					}
			catch (Exception se)
			{
				se.printStackTrace();
					}
			}
		
		
	}
	
	public void showData()
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			connection = JDBC_Util.getJDBCConnection();
			
			if(connection != null)
			{
			//Step3. Create statement Object and send the query
			String sqlSelectQuery = "select * from employee";
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(sqlSelectQuery);
			
			System.out.println();
			System.out.println("=====================================");
			
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
			else
			{
				System.out.println("connection object is null");
			}
			
		}
		
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
				try
				{
					JDBC_Util.closeConnection(resultSet, null, statement, connection);
						}
				catch (Exception se)
				{
					se.printStackTrace();
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
	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", project_name=" + project_name + ", address="
				+ address + ", emp_type=" + emp_type + "]";
	}
	
}
