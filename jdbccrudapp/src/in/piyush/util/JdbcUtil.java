package in.piyush.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	
	private  JdbcUtil() {
		
	}
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection  getJDBCConnection() throws SQLException, IOException
	
	{
		HikariConfig config = new HikariConfig("src\\in\\piyush\\properties\\db2.properties  ");
		HikariDataSource hikariDataSource = new HikariDataSource(config) ;
			Connection con = hikariDataSource.getConnection();
			
			//Connection con = getphysicalJDBCConnection();
			return con;
		
	} 
	
	@SuppressWarnings("unused")
	private static Connection  getphysicalJDBCConnection() throws SQLException, IOException
	
	{
		FileInputStream fis = new FileInputStream("src\\in\\piyush\\properties\\db2.properties  ");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	} 

}
