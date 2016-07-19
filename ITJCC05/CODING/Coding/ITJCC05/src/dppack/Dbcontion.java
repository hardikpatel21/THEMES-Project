package dppack;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

              String url = "jdbc:mysql://192.168.0.9:3306/";
              String dbName = "itjcc05";
              String driver = "com.mysql.jdbc.Driver";
              String userName = "root";
              String password = "root";
        try {
                 Class.forName(driver).newInstance();
                cont =DriverManager.getConnection(url+dbName,userName,password);
				System.out.println("~~~~~~` "+cont);

        }
        catch (Exception e)
            {
                 e.printStackTrace();
             }
              return cont;
      }
	  
   
   public void imagedetail(String image_name)
	{
		try
		{
			
		java.sql.Connection con=Dbcontion.getinstance().connect();
		System.out.println(con+":::::::::::::::::::::::::::::::::::::::");
		Statement st= con.createStatement();
		int j=st.executeUpdate("insert into upload values('"+"hai"+"','"+0+"','"+0+"','"+0+"','"+0+"')");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
   public static void main(String arg[])
   {
	   Dbcontion.getinstance().imagedetail("hai");
   }
       
}
