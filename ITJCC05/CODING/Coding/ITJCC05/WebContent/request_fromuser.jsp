<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="dppack.fctory_design.DBClass1"%>
<%@page import="CSP.Retriving_database"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Cloud Service Provider</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/droid_sans_400-droid_sans_700.font.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
</head>
<body>
<script language="javascript">

</script>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="searchform">
         <div class="top_menu"> </div>
      </div>
      <div class="logo">
        <h1><a href="#">Cloud<span>Service Provider</span></a></h1>
      </div>
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li ><a href="CSP_Homepage.jsp"><span>Home Page</span></a></li>
          <li><a href="Image_upload.jsp"><span>UPLOAD</span></a></li>
          <li ><a href="user.jsp"><span>USER DETAILS</span></a></li>
          <li class="active"><a href="request_fromuser.jsp"><span>User Request </span></a></li>
          <li ><a href="response.jsp"><span>Response </span></a></li>
           <li><a href="Bill.jsp"><span>BILL</span></a></li>
         
        </ul>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> <a href="#"><img src="images/timthumb.php.jpg" width="960" height="360" alt="" /></a><span></span>
			<a href="#"><img src="images/slide3-960x360.jpg" width="960" height="360" alt="" />
				
			</a>
            <a href="#">
				
					<big>
			</big></a> 
		</div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  
  <div class="content">
  
    <div class="mainbar" style="width: 319px; ">
        <div class="article">
          <h2><span>LOGIN AS</span> <font color="blue"><%=session.getAttribute("username") %>
          </h2> 
         <a href="Home.jsp"> <h4><font color="red">logout</font></h4></a>         
         <div>
         <div align="left">
          <img src="images/replytomail.png" width="260" height="245" alt="" class="fl" />
          </div>
          
         
          </div>
        
      
    </div>
  </div>
  <%
   List l= new ArrayList();
  try
	{
	  	
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
		System.out.println("hghghg"+cont);
		Statement st= cont.createStatement();
		ResultSet rs=st.executeQuery("select * from request_from_user");
		while(rs.next())
		{
			l.add(rs.getString(1));
			l.add(rs.getString(2));
			l.add(rs.getString(3));
		}
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
  %>
  
   <form action="slagenerate" method=post>
    <div align="center">
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <table width="382" border="5">
  <tr>
    <th width="69" scope="col"><font color="#990066">SELECT</font></th>
    <th width="157" scope="col"><font color="#990066">Requested Software</font></th>
    <th width="142" scope="col"><font color="#990066">Request from User</font></th>
    <th width="142" scope="col"><font color="#990066">Requested Date</font></th>
  </tr>
  
  <%for(int i=0;i<l.size();i++){ %>
  <tr>
  <td>
  <%String sname=l.get(i).toString();
  i++;
  String uname=l.get(i).toString();
  String c=sname+"#"+uname;
  %>
  
  <input type="checkbox" name="select" id="select" value=<%=c %> /><%i--; %>
  </td>
  <td>
  <%=l.get(i) %>
  <%i++; %>
  </td>
  <td>
  <%=l.get(i) %>
  <%i++; %>
  </td>
   <td>
  <%=l.get(i) %>
  </td>
  
  </tr>
  
  <%} %>
  
</table>
<table align="center">
<tr>
  <td><input name="SLA" type="submit" value="SLA" /></td>

</tr>
</table>
    </div>
    </form>
    
    
      <p><br />
      <br />
      <p>      
      <p>      
      <p>      
  <p><br />
      <div class="clr"></div>
<!-- </div> --></div>
  <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2><span>Image</span> Gallery</h2>
        <a href="#"><img src="images/gal1.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal2.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal3.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal4.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#"><img src="images/gal5.jpg" width="75" height="75" alt="" class="gal" /></a> <a href="#">
		<img src="images/gal6.jpg" width="75" height="75" alt="" class="gal" /></a> </div>
      <div class="col c2">
        <h2><span>Services</span> Overview</h2>
        <p align="justify">In the enterprise, cloud backup services are primarily being used for archiving non-critical data only. Traditional backup is a better solution for critical data that requires a short recovery time objective (RTO) because there are physical limits for how much data can be moved in a given amount of time over a network. When a large amount of data needs to be recovered, it may need to be shipped on tape or some other portable storage media. </p>
        <ul class="fbg_ul">
          <li><a href="http://en.wikipedia.org/wiki/Cloud_computing">Cloud Computing</a></li>
          <li><a href="http://searchdatabackup.techtarget.com/definition/cloud-backup">cloud backup</a></li>
          <li><a href="http://searchcloudcomputing.techtarget.com/definition/cloud-computing">Hybrid cloud.</a></li>
        </ul>
      </div>
      <div class="col c3">
        <h2><span>Contact</span> Us</h2>
        <p></p>
        <p class="contact_info"> <span>Address:</span>1458 chennai, India<br />
          <span>Telephone:</span> +91-1234-5678  <img src="images/images (1).jpg" width="18" height="16" alt="" /><br />
          <span>FAX:</span> +458-4578<br />
          <span>Others:</span> +301 - 0125 - 01258<br />
          <span>E-mail:</span> <a href="#">abc@cloud.com</a> </p>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="footer">
    <div class="footer_resize">      
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
<div align=center></div></body>
</html>
