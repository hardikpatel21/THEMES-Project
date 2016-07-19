package user;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dppack.fctory_design.DBClass1;


public class user_profile
{
	public static user_profile udb;
	public static user_profile from_database()
	{
		if(udb==null)
		{
			udb= new user_profile();
		}
			return udb;
	}
	private user_profile()
	{
		
	}
	public List retrieve()
	{
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
	//	System.out.println("hghghg"+cont);
		List details=new ArrayList();
		try
		{
			Statement st= cont.createStatement();
			
			
			ResultSet rs=st.executeQuery("Select image,name from upload  ");
			//System.out.println("~~~~~~~~~~ "+rs.next());
			while(rs.next())
			{
				
				
				details.add(rs.getString(1).toString().trim());
				details.add(rs.getString(2).toString().trim());
				
				
				
				//System.out.println("!!!!!!!!! "+s);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return details;
	}
	public List userdetail_retrieve(String name)
	{
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
	//	System.out.println("hghghg"+cont);
		List user_details=new ArrayList();
		try
		{
			Statement st= cont.createStatement();
			
			
			ResultSet rs=st.executeQuery("Select phone_no,email_id,account_no,address from user where user_name='"+name+"' ");
			//System.out.println("~~~~~~~~~~ "+rs.next());
			while(rs.next())
			{
				
				
				user_details.add(rs.getString(1).toString().trim());
				user_details.add(rs.getString(2).toString().trim());
				user_details.add(rs.getString(3).toString().trim());
				user_details.add(rs.getString(4).toString().trim());
				
				
				//System.out.println("!!!!!!!!! "+s);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user_details;
	}

}
