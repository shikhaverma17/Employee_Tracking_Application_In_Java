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
	public Connection conn=null;

	static
	{
		System.out.println("class is loading.....");
	}
	private JDBC_Util() 
	{
		System.out.println("Constructor is called.....");
	}
	
	public Connection getJDBCConnection() throws IOException
	{
		Connection conn=null;
    	ResultSet resultset=null;
    	PreparedStatement pstmt=null;
    	
    	   	
    	Properties props=new Properties();
    	FileInputStream fis=new FileInputStream("");
    	props.load(fis);
    	
    	
    	String url=props.getProperty("url");
    	String user=props.getProperty("user");
    	String passward=props.getProperty("passward");
    	
    	
    	try {
			conn=DriverManager.getConnection(url, user, passward);
			if(conn!=null)
			{
				return conn;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    	return conn;
	}
	
	 public static void closeConnection(ResultSet resultset,PreparedStatement pstmt,Statement stmt,Connection conn) 
     {
     	if(resultset!=null)
			{
     		try {
					resultset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
     	if(resultset!=null)
			{
     		try {
					resultset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}	
     	if(pstmt!=null)
			{
     		try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
     	if(conn!=null)
			{
              try 
     		   {
				     conn.close();
				} 
     		    catch (SQLException e)
     		    {
					e.printStackTrace();
				}  
			}	
     }


}
