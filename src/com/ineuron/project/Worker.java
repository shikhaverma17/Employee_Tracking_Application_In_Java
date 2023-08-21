package com.ineuron.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

import in.ineuron.util.JDBC_Util;

// select ename,logindate,shifttime,shiftstatus from employee WHERE (eid = '6' );

public class Worker extends Employee
{
	String shift_time;
	String loginDate;
	String status;

	public void insertWorkerDetails(Integer eid, Worker worker)
	{
		//System.out.println("insert worker method loading..worker ");

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
// UPDATE `employeetrackingporject`.`employee` SET `logindate` = '2023-03-15', `shifttime` = '09:30:00', `shiftstatus` = 'accepted' WHERE (`eid` = '1');
		try
		{
			connection = JDBC_Util.getJDBCConnection();	
			java.sql.Time sqlShiftTime = java.sql.Time.valueOf(worker.getShift_time());
			// Conversion of String to sqlDate
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date uDate = sdf.parse(worker.getLoginDate());

			long value = uDate.getTime();
			java.sql.Date sqlloginDate = new java.sql.Date(value);
			
			if(connection != null)
			{
				String sqlInsertempInfoQuery
				="UPDATE employee SET `logindate` = ?, `shifttime` = ? WHERE (`eid` = ?)";
				
				//System.out.println("sql query initiated to update shift ");
				
				pst = connection.prepareStatement(sqlInsertempInfoQuery);
				
				pst.setDate(1, sqlloginDate);
				pst.setTime(2, sqlShiftTime);
				pst.setInt(3, eid);
				
				int rowsAffected1 = pst.executeUpdate();
				//System.out.println("Number of rows affected is : - " +rowsAffected1);
				
				//System.out.println("=====================================");
				Display d23765 = new  Display();
				d23765.workerScreen();

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
	public void showWokerShiftStatus(Integer workerId)
	{
		//System.out.println("Show shift time sheet method loading...");

		Connection connection = null;
		Statement statement = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		try {

			connection = JDBC_Util.getJDBCConnection();

			if(connection != null)
			{
				//Step3. Create statement Object and send the query
				String sqlWorkShowtimeSheetQuery
				= "select ename,logindate,shifttime,shiftstatus from employee WHERE (eid = '"+workerId+"' )";
				pst = connection.prepareStatement(sqlWorkShowtimeSheetQuery);

				resultSet = pst.executeQuery();

				System.out.println("==========================================================");
				System.out.println( "NAME" + "\t\t" + "LOGIN DATE"
						+ "\t" + "SHIFT-TIME" + "\t" + "STATUS" );
				//Step4. Process the resultSet
				while (resultSet.next()) {
					
					String ename = resultSet.getString(1);
					java.sql.Date logindate = resultSet.getDate(2);
					java.sql.Time shifttime = resultSet.getTime(3) ;
					String shiftstatus = resultSet.getString(4) ;
					

					if( logindate != null)
					{
						SimpleDateFormat sdfWorker = new SimpleDateFormat("dd-MM-yyyy");
						String strworkerloginDate = sdfWorker.format(logindate);

						System.out.println("---------------------------------------------------------------------------------------");
						System.out.println( ename + "\t\t" + strworkerloginDate
								+ "\t" + shifttime + "\t" + shiftstatus );	
					}
					else
					{
						String strLoginDateWorker = "00-00-0000" ;
						System.out.println("---------------------------------------------------------------------------------------");
						System.out.println( ename + "\t\t" + strLoginDateWorker
								+ "\t" + shifttime + "\t" + shiftstatus );	
					}
				
				}
				
				System.out.println("==========================================================");
				Display d23 = new  Display();
				d23.workerScreen();
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

	public String getShift_time() {
		return shift_time;
	}
	public void setShift_time(String shift_time) {
		this.shift_time = shift_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	@Override
	public String toString() {
		return "Worker [shift_time=" + shift_time + ", loginDate=" + loginDate + ", status=" + status + "]";
	}

}
