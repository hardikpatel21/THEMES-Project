/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 *
 * @author spiro9
 */
public class Acreate {
    static int i=0;
    int ran()
    {
        Random ran=new Random();
        int value=ran.nextInt(1000);
        int Acno=value+1000;
        return  Acno;
    }
    boolean ckeck()
    {
         boolean b=false;
        try
        {

           int Acno=ran();
           i=Acno;
        Dbcontion db=Dbcontion.getinstance();
       Connection con=db.connect();
            Statement st=con.createStatement();
            ResultSet val=st.executeQuery("select Acno FROM useraccount where Acno='"+Acno+"'");
            if(val.next())
            {
                b=true;

            }
 else
          {
                b=false;
          }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return  b;

    }

    public int register(String name, String design, String email, String phno, String adrs, String pin)
    {
        try
       {

        int total=0;
        while(true)
        {
        boolean ck=ckeck();
           System.out.println("ck is "+ck);


        if(ck==false)
        {
          Dbcontion db=Dbcontion.getinstance();
          Connection con=db.connect();

          
       
              PreparedStatement ps=con.prepareStatement("insert into useraccount values(?,?,?,?,?,?,?,?)");
              ps.setString(1, name);
              ps.setString(2, design);
              ps.setString(3, email);
              ps.setString(4, phno);
              ps.setString(5, adrs);
              ps.setString(6, pin);
              ps.setInt(7, i);
              ps.setInt(8, total);
               ps.executeUpdate();
              System.out.println("i is "+i);
              break;
           }

           }

       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       

return  i;
    }

    public void deposit(String amount, String Acno)
    {
        try
        {
         Dbcontion db=Dbcontion.getinstance();
          Connection con=db.connect();
          Statement st=con.createStatement();
          ResultSet rst=st.executeQuery("select total from useraccount where Acno='"+Acno+"'");
          if(rst.next())
          {
              String tota=rst.getString(1).toString().trim();
              int add=Integer.parseInt(tota)+Integer.parseInt(amount);
              System.out.println("value added "+add);
              st.execute("UPDATE useraccount SET total='"+add+"'WHERE Acno='"+Acno+"'");

          }
          con.close();
          st.close();
          st.close();
          rst.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void withdrw( String withdr, String Acno) {
       
    try
        {
         Dbcontion db=Dbcontion.getinstance();
          Connection con=db.connect();
          Statement st=con.createStatement();
          ResultSet rst=st.executeQuery("select total from useraccount where Acno='"+Acno+"'");
          if(rst.next())
          {
              String tota=rst.getString(1).toString().trim();
              int wit=Integer.parseInt(tota)-Integer.parseInt(withdr);
              System.out.println("value added "+wit);
              st.execute("UPDATE useraccount SET total='"+wit+"'WHERE Acno='"+Acno+"'");

          }
          con.close();
          st.close();
          st.close();
          rst.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        

    }

    public String payment(String name, String amount, String Acno) {
        String result="fail";
         try
        {
         Dbcontion db=Dbcontion.getinstance();
          Connection con=db.connect();
          Statement st=con.createStatement();
          ResultSet rst=st.executeQuery("select total from useraccount where Acno='"+Acno+"' and name='"+name+"'");
          if(rst.next())
          {
              String tota=rst.getString(1).toString().trim();
              int balnace=Integer.parseInt(tota);
              int payamount=Integer.parseInt(amount);
              if(balnace>=payamount)
              {
              int wit=balnace-payamount;
              System.out.println("value added "+wit);
              st.execute("UPDATE useraccount SET total='"+wit+"'WHERE Acno='"+Acno+"'");
              result="succss";
              }

          }
          con.close();
          st.close();
          st.close();
          rst.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }


}
