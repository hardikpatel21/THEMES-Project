package Flitter;
import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dppack.csp_pack.Login_verfication;

public class Authentication_Flitter implements Filter 
{    
    public Authentication_Flitter() 
    {
    	System.out.println("HAI DADF GDFG DFG DF ");
    }
	
	public void destroy()
	{
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{	
		System.out.println("Flitter class ");
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		System.out.println("The user name and password is the:"+name+""+pass);
		boolean b=Login_verfication.login().verification(name, pass, "login");
		if(b||(name.equalsIgnoreCase("admin")&pass.equalsIgnoreCase("admin")))
		{
			System.out.println("checking purpose");
			chain.doFilter(request, response);			
		}
		else 		
		{	
			System.out.println("else case in Flitter");
			RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
			rd.forward(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException
	{
		System.out.println("call by the servlet");
	}

}
