package dppack.csp_pack;

import dppack.DBClass;
import java.sql.Connection;
import java.sql.PreparedStatement;

class  User
{
    Connection con=DBClass.getconnection("");
    public int registration(String name,String user_name,String password,int phone_no,String emil_id,String address,int account)
    {
        int i=0;
        try
        {
            PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, user_name);
            ps.setString(3, password);
            ps.setInt(4, phone_no);
            ps.setString(5, emil_id);
            ps.setString(6, address);
            ps.setInt(7, account);
            i=ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return i;
    }
}
