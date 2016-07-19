/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package itjnw08;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Spiro9
 */
public class DBClass {

    Connection con;
    Connection call()
            {

        try{
              String url = "jdbc:mysql://localhost:3306/";
  String dbName = "itjnw08";
  String driver = "com.mysql.jdbc.Driver";
  String userName = "root";
  String password = "root";


            
         Class.forName(driver).newInstance();
  con =    (Connection) DriverManager.getConnection(url+dbName,userName,password);
System.out.println("Database connection is established");

            
                }catch(Exception e)
        {
                    e.printStackTrace();
                }
        return con;
        }

}
