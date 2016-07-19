<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="db.DBClass2"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CloudTop</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
<link href="style.css" rel="stylesheet" type="text/css" />
<%@page import="java.util.*, java.sql.*"  %>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="index.html">THEMIS <small>A Forgery Resistive Billing System</small></a></h1>
      </div>
      <div class="menu_nav">
        <ul>
          <li ><a href="Home.jsp">Home</a></li>
          <li ><a href="SLA.jsp">SLA </a></li>
          <li ><a href="afterbilling.jsp">Bill </a></li>
           <li class="active"><a href="Monitor.jsp">Monitor </a></li>
          
        </ul>
      </div>
      <div class="clr"></div>
      <div class="clr"></div>
    </div>
  </div>
  
  <div class="content">
  
    <div class="mainbar" style="width: 270px; ">
        <div class="article">
          <h2><span>LOGIN AS</span> <font color="blue">admin</h2> 
         <a href="Home.jsp"> <h4><font color="red">logout</font></h4></a>         
         <div>
         <div align="left">
          <img src="images/white.jpg" width="150" height="150
          " alt="" class="fl" />
          </div>
          
         
          </div>
        
      
    </div>
  </div>
  <%
  
  String name=null,sw=null;
   List l= new ArrayList();
  try
	{
	  	
		DBClass2 db= new DBClass2();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
		System.out.println("hghghg"+cont);
		Statement st= cont.createStatement();
		ResultSet rs=st.executeQuery("select request_from_user.software,request_from_user.user,request_from_user.date,response.sla,response.id,response.date from request_from_user inner join response on request_from_user.software=response.software and request_from_user.user=response.user ");
		while(rs.next())
		{
			sw=rs.getString(1);
			name=rs.getString(2);
			l.add(rs.getString(1));
			l.add(rs.getString(2));
			l.add(rs.getString(3));
			l.add(rs.getString(4));
			l.add(rs.getString(5));
			l.add(rs.getString(6));
		}
		 System.out.println("listttttttttt value is :"+l+" "+sw+" "+name);
		 
		/* Statement st1= cont.createStatement();
		ResultSet rs1=st1.executeQuery("select sla,id,date from response where software='"+sw+"'AND user='"+name+"'");
		while(rs1.next())
		{
			
			l.add(rs1.getString(1));
			l.add(rs1.getString(2));
			l.add(rs1.getString(3));
		} */
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
  System.out.println("list value is :"+l);
	String file=name+"-"+sw+".pdf";
  %>
  <input type="hidden" id="filename" value=<%=file %>>
  <%-- <%session.setAttribute("filename", file);%> --%>
   
    <div align="center">
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <table width="516" border="5">
  <tr>
    
    <th width="85" scope="col"><font color="#990066">Requested Software</font></th>
    <th width="67" scope="col"><font color="#990066">Request from User</font></th>
    <th width="95" scope="col"><font color="#990066">Requested Date</font></th>
    <th width="45" scope="col"><font color="#990066">SLA</font></th>
    <th width="48" scope="col"><font color="#990066">id</font></th>
    <th width="73" scope="col"><font color="#990066">Response Date</font></th>
  </tr>
  <%Iterator ii=l.iterator();
while(ii.hasNext()){
String rs=ii.next().toString();
String ru=ii.next().toString();
String rd=ii.next().toString();
String sla=ii.next().toString();
String id=ii.next().toString();
String ud=ii.next().toString();


%>
<tr>
	<td>
	<%=rs %>
	</td>
	<td>
	<%=ru %>
	</td>
	<td>
	<%=rd %>
	</td>
	<td>
	<%session.setAttribute("file", ru+"-"+rs+".pdf");%>
	<a href=monitorcopy><%=sla %></a>
	</td>
	<td>
	<%=id %>
	</td>
	<td>
	<%=ud %>
	</td>
</tr>
<%} %>
  </table>
  
<table align="center">


</table>
    </div>
    
    
    
      <p><br />
      <br />
      <p>      
      <p>      
      <p>      
  <p><br />
      <div class="clr"></div>
<!-- </div> --></div>
  </div>
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">&copy; Copyright DM.com.</p>
      <div class="clr"></div>
    </div>
  </div>
</div>
<div align=center></div></body>
</html>
