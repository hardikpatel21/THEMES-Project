package user;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dppack.csp_pack.User_Registration;


public class Register extends HttpServlet 
{   
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		Map value_details=new TreeMap();
		Map e=request.getParameterMap();
		System.out.println(e);
		Iterator ii=e.entrySet().iterator();
		while(ii.hasNext())
		{
			Map.Entry o=(Map.Entry)ii.next();
			String name=o.getKey().toString();			
			String value=request.getParameter(name);			
			value_details.put(name, value);			
		}
		System.out.println("tHE VALUE IN sERVLET"+value_details);		
		int i=User_Registration.getObject().registration(value_details);
		System.out.println("The i value is the:"+i);
		RequestDispatcher rd=request.getRequestDispatcher("/Register.jsp");
		if(i==1)
		{
			HttpSession hs=request.getSession();
			hs.setAttribute("result", "success");			
			rd.forward(request, response);
		}
		else
		{
			HttpSession hs=request.getSession();
			hs.setAttribute("result", "fail");			
			rd.forward(request, response);
		}
		
	}
}
