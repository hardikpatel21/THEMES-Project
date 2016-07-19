<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="db.DBClass1"%>
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
          <li class="active"><a href="SLA.jsp">SLA </a></li>
           <li ><a href="afterbilling.jsp">Bill </a></li>
           <li ><a href="Monitor.jsp">Monitor </a></li>
          
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
	  	DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
		System.out.println("hghghg"+cont);
		Statement st= cont.createStatement();
		ResultSet rs=st.executeQuery("select * from receivesla ");
		while(rs.next())
		{
			sw=rs.getString(4);
			name=rs.getString(1);
			l.add(rs.getString(1));
			l.add(rs.getString(2));
			l.add(rs.getString(3));
			l.add(rs.getString(4));
			l.add(rs.getString(5));
			
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
    
    <th width="85" scope="col"><font color="#990066">Software</font></th>
    <th width="67" scope="col"><font color="#990066"> User</font></th>
    
    <th width="45" scope="col"><font color="#990066">CSP SLA copy </font></th>
    <th width="48" scope="col"><font color="#990066">USER SLA copy</font></th>
    <th width="48" scope="col"><font color="#990066">BILL REQ DATE</font></th>
    <th width="73" scope="col"><font color="#990066">BILL</font></th>
  </tr>
  <%Iterator ii=l.iterator();
  
while(ii.hasNext()){
String us=ii.next().toString();
 String cna=ii.next().toString();
 String use=ii.next().toString();
 String so=ii.next().toString();
 String da=ii.next().toString();



%>

<tr>
	<td>
	<%=so %>
	</td>
	<td>
	<%=us %>
	<input type="hidden" id="swer" value="<%=us%>"/>
	</td>
	<td>
	<a href=http://localhost:8084/ITJCC05-Themis/SLA/<%=us+"-"+so+".pdf" %>><%=cna%></a>
	</td>
	<td>
	<a href=http://localhost:8084/ITJCC05-Themis/USLA/<%=us+"-"+so+".pdf" %>><%=use %></a>
	</td>
	<td>
	<%=da %>
	</td>
	<td>
	<a href="billing?us=<%=us+"-"+so+".pdf" %>">click</a>
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
