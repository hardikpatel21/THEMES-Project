package CSP;

import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import dppack.Dbcontion;
import dppack.fctory_design.DBClass1;

public class Db_csp 
{

	public static Db_csp dbc=null;
	public static Db_csp db_cspobject()
	{
		if(dbc==null)
		{
			dbc= new Db_csp();
		}
		return dbc;
	}
	private Db_csp()
	{
		
	}
	public void imagedetail(String image_name)
	{
		try
		{
			DBClass1 db= new DBClass1();
			System.out.println("db con is "+db);
			java.sql.Connection cont=db.connect();
			System.out.println("hghghg"+cont);
		/*java.sql.Connection con=Dbcontion.getinstance().connect();
		System.out.println(con+":::::::::::::::::::::::::::::::::::::::");*/
		Statement st= cont.createStatement();
		int j=st.executeUpdate("insert into upload values('"+image_name+"','"+0+"','"+0+"','"+0+"','"+0+"')");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String arg[])
	{
		Db_csp dbc= new Db_csp();
		dbc.imagedetail("hai");
	}
	public void swdetail(String imagename,String sname) 
	{
		
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
		System.out.println("hghghg"+cont);
		System.out.println("sname is "+sname);
		String a[]=sname.split(".zip");
		System.out.println("array is "+a[0]);
		String sw_name=a[0]+".class";

		try
		{
			Statement st= cont.createStatement();
			System.out.println("Update upload SET software='"+sw_name+"'where image='"+imagename+"'");
			int j=st.executeUpdate("Update upload SET software='"+sw_name+"'where image='"+imagename+"'");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void softwaredetails(String imagename, String swfile, String swname, String validity, String cost) 
	{
		
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
		System.out.println("hghghg"+cont);
		
		try
		{
			Statement st= cont.createStatement();
			System.out.println("Update upload SET name='"+swname+"',validity='"+validity+"',cost='"+cost+"'where image='"+imagename+"'and software='"+swfile+"'");
			int j=st.executeUpdate("Update upload SET name='"+swname+"',validity='"+validity+"',cost='"+cost+"'where image='"+imagename+"'and software='"+swfile+"'");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
