package in.ineuron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Util
{
	public Connection conn=null;
	static
	{
		
	}

	private JDBC_Util() 
	{
		
	}
	
	public Connection getJDBCConnection()
	{
		String url="";
		String user="";
		String password="";
		
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
