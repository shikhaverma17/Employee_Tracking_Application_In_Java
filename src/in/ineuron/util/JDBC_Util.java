package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_Util
{

	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println(" JDBC_Util class is loading.....");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	private JDBC_Util() 
	{
		//System.out.println("Constructor is called.....");
	}

	public static Connection getJDBCConnection() throws IOException
	{
		Connection conn = null;
		String dbPath = "C:\\\\Users\\\\Sid\\\\Desktop\\\\Java_learning\\\\GitRepos\\\\IneuronAssignments\\\\Employee_Tracking_Application_In_Java\\\\src\\\\com\\\\properties\\\\application.properties";
		try
		{
			Properties properties=new Properties();

			FileInputStream fis=new FileInputStream(dbPath);
			properties.load(fis);


			String url = properties.getProperty("url") ;
			String userName = properties.getProperty("username");
			String passWord = properties.getProperty("password");

			System.out.println("***************************************************");

			// Step2. Establish the Connection
			conn = DriverManager.getConnection(url, userName, passWord);
			// System.out.println(" CONNECTION object created...connection established succesfully...");
			if(conn!=null)
			{
				return conn;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 

		return conn;
	}

	public static void closeConnection(ResultSet resultset,PreparedStatement pstmt,Statement stmt,Connection conn) 
	{
		System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
		// || stmt!=null || pstmt!=null || conn!=null 
		if(resultset!=null )
		{
			try {
				resultset.close();
//				stmt.close();
//				pstmt.close();
//				conn.close();
				//				System.out.println(" result set closed succesfully...");
//				System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}  
		}
								if(stmt!=null)
								{
									try {
										stmt.close();
//										System.out.println("Statement closed succesfully...");
									} catch (SQLException e) {	
										e.printStackTrace();
									}  
								}	
								if(pstmt!=null)
								{
									try {
										pstmt.close();
//										System.out.println("PreparedStatement closed succesfully...");
									} catch (SQLException e) {
						
										e.printStackTrace();
									}  
								}
								if(conn!=null)
								{
									try 
									{
										conn.close();
//										System.out.println("connection closed succesfully...");
									} 
									catch (SQLException e)
									{
										e.printStackTrace();
									}  
								}
		System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
	}
}
