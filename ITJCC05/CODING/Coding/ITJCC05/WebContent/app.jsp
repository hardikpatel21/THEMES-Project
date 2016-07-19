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
          <li ><a href="User_homepage.jsp"><span>Home</span></a></li>
          <li><a href="request.jsp"><span>Requests</span></a></li>
          <li class="active"><a href="service.jsp"><span>Service</span></a></li>
          <li ><a href="user_profile.jsp"><span>Profile</span></a></li>
         
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
          <h2><span>LOGIN AS</span> <font color="blue">
          <%String name=session.getAttribute("username").toString(); %><%=session.getAttribute("username") %>
          </h2> 
         <a href="Home.jsp"> <h4><font color="red">logout</font></h4></a>         
         <div>
         <div align="left">
          <img src="images/software1.gif" width="260" height="245" alt="" class="fl" />
          </div>
          
         
          </div>
        
      
    </div>
  </div>
  <%
  System.out.println("entering into one");
  HttpSession hp= request.getSession();
  String sw=hp.getAttribute("msg").toString();
  System.out.println("received bbbbbbbbbbbbbbb"+sw);
  String soft=null;
  try
	{
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
		System.out.println("hghghg"+cont);
		Statement st= cont.createStatement();
		ResultSet rs=st.executeQuery("select software from upload where name='"+sw+"'");
		while(rs.next())
		{
			soft=rs.getString(1);
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
  String uploadedfile=application.getInitParameter("uploadedpath");
  String path=soft;
  System.out.println(path);
  
  %>
  
    <div align="center">
      
    HERE
 <applet code="<%=path %>" width="500 " height="400"></applet> 
  </div>
   
    
    
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
          <span>E-mail:</span> <a href="#">abc@cloud.com</a></p>
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
