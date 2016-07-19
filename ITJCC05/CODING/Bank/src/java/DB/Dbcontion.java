/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;


import java.sql.*;

/**
 *
 * @author spiro16
 */
public class Dbcontion
{
    static Dbcontion dbc=null;
    static Connection cont=null;

   private Dbcontion()
   {
    }
   public static  Dbcontion getinstance()
   {
       if(dbc==null)
       {
           dbc=new Dbcontion();
       }

    return dbc;
   }
   public Connection connect()
    {
         System.out.println("MySQL Connect Example.");

              String url = "jdbc:mysql://localhost:3306/";
              String dbName = "Bank";
              String driver = "com.mysql.jdbc.Driver";
              String userName = "root";
              String password = "root";
        try {
                 Class.forName(driver).newInstance();
                cont =DriverManager.getConnection(url+dbName,userName,password);
                System.out.println("connect is "+cont);
        }
        catch (Exception e)
            {
                 e.printStackTrace();
             }
              return cont;
      }
       
}
