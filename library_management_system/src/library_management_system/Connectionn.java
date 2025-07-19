package library_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Step 1: Use interfaces from java.sql package
public class Connectionn 
{
	private static Connectionn instance=new Connectionn();
	public final static String url="jdbc:mysql://localhost:3306/library_management_system";
	public final static String user="root";
	public final static String password="Minnu@123";
	public final String driver_class="com.mysql.cj.jdbc.Driver";
	
	private Connectionn()
	{
		//static reference to itself
		try
		{
			//Load mySQL java driver
			Class.forName(driver_class);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	private Connection createConnection()
	{
		Connection connection=null;
		try
        {
            //Step 3: Establish Java MySQL connection
            connection = DriverManager.getConnection(url,user,password);
        }
		catch (SQLException e)
        {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
		return connection;
	}
	
	public static Connection getConnection()
	{
        return instance.createConnection();
    }
			
	

}
