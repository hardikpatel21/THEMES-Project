<%@page import="dppack.csp_pack.Login_verfication"%>
<%@page import="dppack.csp_pack.Verification_database"%>
<%@page import="dppack.csp_pack.Verification"%>
<%
try
{
	String  a;
	String name=request.getParameter("uname");
	System.out.println(name);
	boolean b=Login_verfication.login().verification(name," ", "exists");
	System.out.print(b);
	if(b)
	{
		a=" Not Available";
	}
	else
	{
		a="Available";
	}
	response.getWriter().print(a);	
}
catch(Exception e)
{
  System.out.println(e);
}


%>