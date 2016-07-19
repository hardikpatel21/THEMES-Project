
package dppack;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTable
{
    static DBClass obj=new DBClass();
    static Connection con=null;
    public static void main(String[] args)
    {
        try
        {
            con=obj.getconnection("CSP");
            System.out.println("CONNECTED");
            Statement st=con.createStatement();
            st.executeUpdate("create table use(name varchar(25),user_name varchar(25),password varchar(15),phone_no int,email_id varchar(35),address varchar(200),account_no int)");
        }
        catch(Exception e)

        {
            System.out.println(e);
        }

    }

}
