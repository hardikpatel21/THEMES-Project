package db;


	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBClass2 implements Interface_DBClass
	{
	    Connection con=null;
	    String url = "jdbc:mysql://localhost:3306/";
	    String dbName = "itjcc05";
	    String driver = "com.mysql.jdbc.Driver";
	    String userName = "root";
	    String password = "root";
	    public Connection connect()
	    {
	        try
	        {
	        	System.out.println("hi");
	            Class.forName(driver);
	            con=DriverManager.getConnection(url+dbName,userName,password);
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	        }
	        return con;
	    }

	}


