<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
          <li><a href="CSP_Homepage.jsp"><span>Home Page</span></a></li>
          <li class="active"><a href="Image_upload.jsp"><span>Upload</span></a></li>
          <li><a href="user.jsp"><span>User Details</span></a></li>
          <li ><a href="request_fromuser.jsp"><span>User Request </span></a></li>
          <li ><a href="response.jsp"><span>Response </span></a></li>
          <li><a href="Bill.jsp"><span>BILL</span></a></li>         
        </ul>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> 
			<a href="#"><img src="images/slide1.jpg" width="960" height="360" alt="" />
				
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
 
        
<h2><span>LOGIN AS</span> <font color="blue"><%=session.getAttribute("username") %></h2>
<p>&nbsp;</p>
<%String swname = (String)session.getAttribute("name"); %>



<form action=Softwaredetails_upload method="post">
  <table width="983" border="0">
    <tr>
      <td width="179">Your Details about the software</td>
      <td width="794"><%= swname %>is sucessfully registered............</td>
    </tr>
  </table>
  
</form>
<p>&nbsp;</p>
<p>&nbsp;</p>
</div>
      </div>
  <div class="fbg">
    <div class="fbg_resize"></div>
</div>
  <div class="footer">
    <div class="footer_resize">      
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
<div align=center></div></body>
</html>
