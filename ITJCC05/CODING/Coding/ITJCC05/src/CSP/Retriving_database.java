package CSP;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dppack.fctory_design.DBClass1;

public class Retriving_database 
{
	public static Retriving_database rdb;
	public static Retriving_database from_database()
	{
		if(rdb==null)
		{
			rdb= new Retriving_database();
		}
			return rdb;
	}
	private Retriving_database()
	{
		
	}
	public static List retrieve()
	{
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
	//	System.out.println("hghghg"+cont);
		List details=new ArrayList();
		
		
		try
		{
			Statement st= cont.createStatement();
			
			
			ResultSet rs=st.executeQuery("Select * from upload");
			//System.out.println("~~~~~~~~~~ "+rs.next());
			while(rs.next())
			{
				
				
				details.add(rs.getString(1).toString().trim());
				details.add(rs.getString(2).toString().trim());
				details.add(rs.getString(3).toString().trim());
				details.add(rs.getString(4).toString().trim());
				details.add(rs.getString(5).toString().trim());
				
				//System.out.println("!!!!!!!!! "+s);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return details;
	}
	public List userdetail_retrieve()
	{
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
	//	System.out.println("hghghg"+cont);
		List user_details=new ArrayList();
		try
		{
			Statement st= cont.createStatement();
			
			
			ResultSet rs=st.executeQuery("Select name,user_name,phone_no,email_id,account_no from user");
			//System.out.println("~~~~~~~~~~ "+rs.next());
			while(rs.next())
			{
				
				
				user_details.add(rs.getString(1).toString().trim());
				user_details.add(rs.getString(2).toString().trim());
				user_details.add(rs.getString(3).toString().trim());
				user_details.add(rs.getString(4).toString().trim());
				user_details.add(rs.getString(5).toString().trim());
				
				//System.out.println("!!!!!!!!! "+s);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user_details;
	}
	public static void main(String args[])
	{
		List l= retrieve();
		System.out.println("list...."+l);
		
	}

}
