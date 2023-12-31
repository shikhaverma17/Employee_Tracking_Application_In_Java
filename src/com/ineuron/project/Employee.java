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

	public Integer CheckEmpId(Integer eid)
	{
		String sqlEmpSelectQuery
		= "select eid,ename from employee WHERE (`eid` = '"+eid +"')";
		
		Integer employeeIdValidation = null;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;	
		
		try
		{
			connection = JDBC_Util.getJDBCConnection();	
			if(connection != null)
			{
				pst = connection.prepareStatement(sqlEmpSelectQuery);
				//System.out.println("sql query initiated to to check if emp id is valid! ");
				if(pst != null)
				{
					resultSet= pst.executeQuery();
					//System.out.println("object value in result set "+resultSet);
					if(resultSet.next())
					{
						System.out.println("----------------------------------------------");
						System.out.println("Employee Id is : " +resultSet.getInt(1));
						System.out.println("Employee name is : " +resultSet.getString(2));
						System.out.println("----------------------------------------------");
						

						return	employeeIdValidation = +resultSet.getInt(1);
					}
					else
					{
						System.out.println("No Employee is registered with the given id::" +eid);
						System.out.println("-----------------------------------");
						System.out.println("Sending back to manager screen! ");	
						System.out.println("-----------------------------------");
						Display d101266 = new Display();
						d101266.choiceOfEmp();				
					}

				}
				else
				{
					System.out.println(" pst object null!!!");
				}

			}
		}
		catch(Exception e19909)
		{
			e19909.printStackTrace();
		}
		finally
		{
			//closing the resources
			try
			{
				System.out.println("-----------------------------------");
				JDBC_Util.closeConnection(resultSet, pst, pst, connection);
				System.out.println("***************************************");
					
			}
			catch (Exception se)
			{
				se.printStackTrace();
			}
		}
		return employeeIdValidation;


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
				//System.out.println("sql query initiated ");
				pst = connection.prepareStatement(sqlEmpInsertQuery);
				s1 = new Scanner(System.in);

				System.out.println("Enter the username :: ");
				username1 = s1.nextLine();

				System.out.println("Enter the state :: ");
				state1 = s1.nextLine();

				System.out.println("Enter the city :: ");
				city1 = s1.nextLine();

				System.out.println("Enter the street :: ");
				street1 = s1.nextLine();

				System.out.println("Enter the zipcode :: ");
				zipcode = s1.nextLine();

				System.out.println("Enter the emp type :: ");
				emptype = s1.nextLine();

				Address a1 = new Address(street1,city1, state1, zipcode);
				Employee emp2 = new Employee(username1, a1, emptype);
				
				if(pst != null)
				{
					pst.setString(1, emp2.getEmp_name());
					pst.setString(2, a1.getState());
					pst.setString(3, a1.getStreet() );
					pst.setString(4, a1.getCity());
					pst.setString(5, a1.getZipCode());
					pst.setString(6, emp2.getEmp_type());

					int rowsAffected = pst.executeUpdate();
					
					System.out.println("------------------------------------");
					System.out.println("Registered Successfully....." + rowsAffected );
					System.out.println("------------------------------------");
					System.out.println("Reverting back to home screen.....");
					System.out.println("------------------------------------");
					
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
				JDBC_Util.closeConnection(resultSet, pst, pst, connection);
				System.out.println("***************************************");
				Display d0123 = new Display();
				d0123.choiceOfEmp();
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
