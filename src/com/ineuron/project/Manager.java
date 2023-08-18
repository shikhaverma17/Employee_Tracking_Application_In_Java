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
	private String project_name;
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
				while (resultSet.next()) 
				{
					Integer eid = resultSet.getInt(1);
					String ename = resultSet.getString(2);
					String etype = resultSet.getString(3);
					java.sql.Date loginDate = resultSet.getDate(4) ;
					java.sql.Time shifttime = resultSet.getTime(5);
					
					if( loginDate != null)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						String strLoginDate = sdf.format(loginDate);
						
						 System.out.println(eid + "\t" + ename + "\t \t " + "\t" + etype
									+ "\t" + strLoginDate+ "\t \t" + shifttime );	
					}
					else
					{
						String strLoginDate = "00-00-0000" ;
						
					    System.out.println(eid + "\t" + ename + "\t \t " + "\t" + etype
									+ "\t" + strLoginDate+ "\t \t" + shifttime );	
					}				 
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

	public void updateEmpStatus(Integer eid , Integer choiceOfManager)
	{
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		// 	UPDATE `employeetrackingporject`.`employee` SET `shiftstatus` = 's' WHERE (`eid` = '7');
		try
		{
			connection = JDBC_Util.getJDBCConnection();	
			if(connection != null)
			{

				if(choiceOfManager == 1)
				{
					System.out.println("accepted " +eid +" " +choiceOfManager);

					String sqlEmpInsertAcceptQuery
					= "UPDATE employee SET `shiftstatus` = 'accepted' WHERE (`eid` = '"+eid +"')";
					System.out.println("sql query iniciated to accept ");
					pst = connection.prepareStatement(sqlEmpInsertAcceptQuery);

					int rowsAffected1 = pst.executeUpdate();
					System.out.println("Number of rows affected is : - " +rowsAffected1);

				}
				else if(choiceOfManager == 2)
				{
					System.out.println("rejected "  +eid +" " +choiceOfManager);

					String sqlEmpInsertRejectedQuery
					= "UPDATE employee SET `shiftstatus` = 'rejected' WHERE (`eid` = '"+eid +"')";
					System.out.println("sql query iniciated to reject shift ");
					pst = connection.prepareStatement(sqlEmpInsertRejectedQuery);

					int rowsAffected2 = pst.executeUpdate();
					System.out.println("Number of rows affected is : - " +rowsAffected2);

				}

				else
				{
					System.out.println(" please enter a valid number to input!");
					Display d1122 = new Display();
					d1122.mangerScreen();
				}

			}
		}

		catch (Exception e123)
		{
			e123.printStackTrace();
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

	public void updateInfoFromManager(Integer eid, Manager manger)
	{
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		// UPDATE employee SET `deptname` = 'admin', `projectname` = 'iot', `reportingempcount` = '4' WHERE (`eid` = '7');

		try
		{
			connection = JDBC_Util.getJDBCConnection();	
			System.out.println(eid);
			
			System.out.println(manger);
			if(connection != null)
			{
				String sqlInsertempInfoQuery
				= "UPDATE employee SET `deptname` = '"+manger.getDept_name()+"', `projectname` = '"+manger.getProject_name()+"', `reportingempcount` = '"+manger.getNo_of_individual_repo()+"' WHERE (`eid` = '"+eid+"');";

				System.out.println("sql query iniciated to reject shift ");

				pst = connection.prepareStatement(sqlInsertempInfoQuery);
				
				
				
				int rowsAffected1 = pst.executeUpdate();
				System.out.println("Number of rows affected is : - " +rowsAffected1);

			}
		}
		catch (Exception e1234)
		{
			e1234.printStackTrace();
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

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	@Override
	public String toString() {
		return "Manager [dept_name=" + dept_name + ", project_name=" + project_name + ", no_of_individual_repo="
				+ no_of_individual_repo + ", timesheet_assign_for_approval=" + timesheet_assign_for_approval + "]";
	}

}
