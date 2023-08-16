package com.ineuron.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import in.ineuron.util.JDBC_Util;

public class Manager extends Employee
{


	private String dept_name;
	private Integer no_of_individual_repo;
	private String timesheet_assign_for_approval;


	public void showAllEmp()
	{
		System.out.println("showing all employees from data base below: - ");

		Connection connection = null;
		Statement statement = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		try {

			connection = JDBC_Util.getJDBCConnection();

			if(connection != null)
			{
				//Step3. Create statement Object and send the query
				String sqlSelectQuery = "select eid,ename,etype,logindate,shifttime from employee";
				pst = connection.prepareStatement(sqlSelectQuery);

				resultSet = pst.executeQuery();

				System.out.println();
				System.out.println("=====================================");

				//Step4. Process the resultSet
				while (resultSet.next()) {
					Integer eid = resultSet.getInt(1);
					String ename = resultSet.getString(2);
					String etype = resultSet.getString(3);
					java.sql.Date loginDate = resultSet.getDate(4);
					java.sql.Time shifttime = resultSet.getTime(5);
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String strLoginDate = sdf.format(loginDate);
					

					System.out.println(eid + "\t" + ename + "\t" + etype
							+ "\t" + strLoginDate + "\t" + shifttime );				
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

	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Integer getNo_of_individual_repo() {
		return no_of_individual_repo;
	}
	public void setNo_of_individual_repo(Integer no_of_individual_repo) {
		this.no_of_individual_repo = no_of_individual_repo;
	}
	public String getTimesheet_assign_for_approval() {
		return timesheet_assign_for_approval;
	}
	public void setTimesheet_assign_for_approval(String timesheet_assign_for_approval) {
		this.timesheet_assign_for_approval = timesheet_assign_for_approval;
	}



	@Override
	public String toString() {
		return "Manager [dept_name=" + dept_name + ", no_of_individual_repo=" + no_of_individual_repo
				+ ", timesheet_assign_for_approval=" + timesheet_assign_for_approval + "]";
	} 

}
