import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBInfo1 
{
	static Connection con;
	
	static
	{
		//Driver
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		//Connection
		
		public static Connection getConnection()
		{
			String url="jdbc:mysql://localhost:3306/onlineexam";
			String uname="root";
			String pass="rat";
			
			try {
				con=DriverManager.getConnection(url,uname,pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
			
		}
	
		public static void close()
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
