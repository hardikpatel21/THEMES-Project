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
k<script type="text/javascript" src="js/cufon-yui.js"></script>
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
          <img src="images/dropbox-cloud.jpg" width="260" height="245" alt="" class="fl" />
          </div>
          
         
          </div>
        
      
    </div>
  </div>
  <%
  	String software,s,id,date,sla;
   	List l= new ArrayList();
  try
	{
	  	
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
		System.out.println("hghghg"+cont);
		Statement st= cont.createStatement();
		ResultSet rs=st.executeQuery("select software,sla,date from Response where user='"+name+"'");
		while(rs.next())
		{
			
			
			software=(rs.getString(1));
			s=(rs.getString(2));
			date=(rs.getString(3));
			String[] a=s.split("/");
			sla=a[1];
			l.add(software);
			l.add(sla);
			l.add(date);
		}
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
  %>

  
  
    <div align="center">
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <table width="435" border="5">
  <tr>
    
    <th width="92" scope="col"><font color="#990066">Software</font></th>
    <th width="94" scope="col"><font color="#990066">SLA</font></th>
    <th width="84" scope="col"><font color="#990066">Date</font></th>
    <th width="84" scope="col"><font color="#990066">View Bill</font></th>
  </tr>
  
  <%for(int i=0;i<l.size();i++){ %>
  <tr>
   <td>
 <a href="onetimepassword.jsp"><%=l.get(i) %></a>
  <%i++; %>
  </td>
  <td>
  <%String sw=l.get(i).toString(); %>
  <img src="images/320_pdf_icon_16.gif" width="18" height="18" alt="" class="fl" /><br />
  <% System.out.println("UPLOADED_FILE\\10.1.1.157.1332.pdf");%>
  
   
 k<a href="SLA\\<%=l.get(i) %>"><%=l.get(i) %></a> 
  <%i++; %>
  </td>
   <td>
   
  <%=l.get(i) %>

  </td>
  <td>
  <%String[] sname=sw.split("\\."); 
  	
  	System.out.println("HAI HAI HAI"+sname[0]);%>
   <a href="http://localhost:8084/ITJCC05-Themis/BILL/<%=sname[0]%> bill.pdf">view bill</a>
 
  </td>
  
  <%} %>
  
</table>
</div>
</div>
<div>
 
<table align="left">
<tr>
<script src="jquery.js"></script>
<script>
$(document).ready(function() {
	  $('.nav-toggle').click(function(){
		//get collapse content selector
		var collapse_content_selector = $(this).attr('href');					

		//make the collapse content to be shown or hide
		var toggle_switch = $(this);
		$(collapse_content_selector).toggle(function(){
		  if($(this).css('display')=='none'){
                          //change the button label to be 'Show'
			toggle_switch.html('Bill Request and Payment');
		  }else{
                          //change the button label to be 'Hide'
			toggle_switch.html('Hide');
		  }
		});
	  });

	});	
	</script>
	<style>	
	.round-border {
		border: 1px solid #eee;
		border: 1px solid rgba(0, 0, 0, 0.05);
		-webkit-border-radius: 4px;
		-moz-border-radius: 4px;
		border-radius: 4px;
		padding: 10px;
		margin-bottom: 5px;
	}
	</style>
</head>
<body>
	<section class="round-border">
		
		<div>
			<button href="#collapse1" class="nav-toggle">BILL and PAYMENT</button>
		</div>
		<div id="collapse1" style="display:none">
		<form action="http://localhost:8084/ITJCC05-Themis/usersla" enctype="multipart/form-data" method="post">
			<p><h3><b>SELECT THE SLA TO SEND FOR BILLING</b></h3></p>
   
    <p><label for="file"></label>
      <input type="file" name="file" id="file" /></p>
      
    <p><input align="middle" name="upload" type="submit" value="Send to CNA" /></p>
    <p><a href="ready_for_ payment.jsp">PAYMENT</a></p>
		</div>
		
	</section>
</body>


</tr>
</table>
    </div>
   
    
    
      <!-- <p><br />
      <br />
      <p>      
      <p>      
      <p>      
  <p><br /> -->
      <div class="clr"></div>

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
