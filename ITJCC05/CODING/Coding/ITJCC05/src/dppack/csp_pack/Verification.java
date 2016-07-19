package dppack.csp_pack;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dppack.DBClass;

public class Verification implements Verification_database
{
	Statement st;
	ResultSet rs;
	boolean b;
	@Override
	public boolean verify(String query) 
	{
		List li=new ArrayList();
		try
		{
			st=DBClass.getconnection("CSP").createStatement();
		    rs=st.executeQuery(query);
		    while(rs.next())
		    {
		    	li.add(rs.getString(1).trim());
		    }
		    System.out.println(b);
		    if(li.size()==0)
		    {
		    	b=false;
		    }
		    else
		    {
		    	b=true;
		    }
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		
		return b;
	}

}
