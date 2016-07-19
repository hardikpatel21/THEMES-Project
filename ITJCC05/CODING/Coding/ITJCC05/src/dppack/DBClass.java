
package dppack;

import dppack.fctory_design.DBClass1;
import dppack.fctory_design.DBClass2;
import dppack.fctory_design.Interface_DBClass;
import java.sql.Connection;

public class DBClass
{
        static Connection con=null;
        static Interface_DBClass dbobj=null;

    public static Connection getconnection(String option)
    {
        try
        {
              if(option.equals("CSP"))
              {
                dbobj=new DBClass1();
                con=dbobj.connect();
              }
              else if(option.equals("DB2"))
              {
                dbobj=new DBClass2();
                con=dbobj.connect();
              }             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }

}
