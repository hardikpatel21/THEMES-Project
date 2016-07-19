package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dbconnection
{
    public  static Dbconnection connctRef;
    Connection con;
    private Dbconnection()
    {

    }
     public static Dbconnection getconnect()
     {
         if(connctRef==null)
         {
             connctRef=new Dbconnection();
         }
            return connctRef;
     }

    public Connection validation()
    {
          try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("Jdbc:Odbc:MW");


        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();


    }
      return con;
}
}
