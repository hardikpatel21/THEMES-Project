package dppack.csp_pack;

import dppack.DBClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

public class  User_Registration
{
	private static final User_Registration u=new User_Registration();
	private User_Registration()
	{
		
	}
	public static User_Registration getObject()
	{
		return u;
	}
    Connection con=DBClass.getconnection("CSP");
    public int registration(Map m)
    {
    	
        int i=0;
        try
        {
        	System.out.println("The value in DB"+m);
            PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
            System.out.println("1");
            ps.setString(1, m.get("name").toString());
            System.out.println("2");
            ps.setString(2, m.get("username").toString());
            System.out.println("3");
            ps.setString(3, m.get("password").toString());
            ps.setString(4, m.get("phone").toString());
            ps.setString(5, m.get("email").toString());
            ps.setString(6, m.get("addr").toString());
            ps.setInt(7, Integer.parseInt(m.get("acc").toString()));
            System.out.println("5");
            i=ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return i;
    }
}
