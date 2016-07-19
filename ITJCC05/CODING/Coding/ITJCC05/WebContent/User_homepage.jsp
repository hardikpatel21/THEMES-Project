<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="user.user_profile"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Cloud Service </title>
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
        <h1><a href="#">Cloud<span>Service </span></a></h1>
      </div>
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="User_Homepage.jsp"><span>Home</span></a></li>
          <li><a href="request.jsp"><span>Requests</span></a></li>
          <li><a href="service.jsp"><span>Service</span></a></li>
          <li><a href="user_profile.jsp"><span>Profile</span></a></li>
         
        </ul>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"><span>
        <a href="#"><img src="images/Man-and-Cloud1-960x360.jpg" width="960" height="360" alt="" /></a>
          <a href="#"><img src="images/240_LAB41.co-Online-Agency-Hosting.jpg" width="960" height="360" alt="" />
          </a>
          </span>
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
          <h2><span>LOGIN AS</span> <font color="blue"><% String name=session.getAttribute("username").toString(); %><%=session.getAttribute("username") %></h2> 
         <a href="Home.jsp"> <h4><font color="red">logout</font></h4></a>         
          <div class="clr"></div>
          <div class="img"><img src="images/Cloud Computing Users.jpg" width="236" height="245" alt="" class="fl" /></div>
        </div>
      
      </div>
      </div>
      
      <p><br />
      <br />
      <p>      
      <p>      
      <p>      
      <p><br />
      
      <%
     
      user_profile udb=user_profile.from_database();
      List l=udb.retrieve();
      System.out.println("list is :"+l+"SIZE IS "+l.size());
   
       %>
       
       <form action="sendrequest" method=post>
      <div><table width="473" border="10" cellpadding="5">
  <tr>
  
    
    <th width="113" bgcolor="#FFFFCC"  scope="col"><font color="#0000FF"><b>Select</b></font></th>
    <th width="149" bgcolor="#FFFFCC"  scope="col"><font color="#0000FF"><b>Software Image</b></font></th>
    
    <th width="147" bgcolor="#FFFFCC" scope="col"><font color="#0000FF"><b>Software Name</b></font></th>  </tr>
 <%for(int i=0;i<l.size();i++){ %>
  <tr>
    <td align="center" bgcolor="#999999">
    <%i++; %>
      <input type="checkbox" name="select" id="select" value=<%=l.get(i) %><%i--; %> />

     <%session.setAttribute("select", l.get(i)) ;%>
   </td>
  
  <td align="center" bgcolor="#999999">
  		<img src="UPLOADED_FILE\\<%=l.get(i).toString()%>" width="100" height="30"/>
  		<%System.out.println("UPLOADED_FILE\\"+l.get(i).toString()); %>
  		<%i++; %>
  
  </td>
  <td align="center" bgcolor="#999999">
  		<%=l.get(i).toString() %>
  		<%String swname= l.get(i).toString();  %>
  		
  
  </td>
  
  
  
 
  </tr>
 <%} %>
 
</table>


</div>
      </p>
      <table width="200" border="0">
        <tr>
          <th scope="col">
            <input type="submit" name="OPEN" id="OPEN" value="SEND REQUEST" />
         </th>
        </tr>
      </table>
      </form>
      <% 
      
      	HttpSession rs=request.getSession();
   		if(rs.getAttribute("message")!=null)
   		{%>
   		<h1>Your Request Send Sucessfully</h1>
   		
   			
   		<%}
   		
      %>
     
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
