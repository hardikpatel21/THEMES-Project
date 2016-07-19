package dppack.csp_pack;

public class Login_verfication 
{
	public static final Login_verfication v=new Login_verfication();
	
	private Login_verfication()
	{
		
	}
	public static Login_verfication login()
	{
		return v;
	}
	
	public boolean verification(String name,String password,String type)
	{
		boolean b = false;
		String query;
		if(type.equalsIgnoreCase("login"))
		{
			query="select * from user where user_name='"+name+"'and password='"+password+"'";
			Verification_database v=new Verification();
			b=v.verify(query);
			System.out.println(b);
		}
		else if(type.equalsIgnoreCase("exists"))
		{
			query="select * from user where user_name='"+name+"'";
			System.out.println(query);
			Verification_database v=new Verification();
			b=v.verify(query);
		}		
		return b;
	}

}
