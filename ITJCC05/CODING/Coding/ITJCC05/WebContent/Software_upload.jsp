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
          <li class="active"><a href="Software_upload.jsp"><span>Upload</span></a></li>
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
<% String imagename = (String)session.getAttribute("filename");%>


<input type="hidden" name="image" value="<%= imagename%>"/>
<table width="1042" border="0">
  <tr>
    <td width="71" height="38">Your Image </td>
    <td width="961"><%=imagename %>is successfully uploaded....</td>
    
  </tr>
</table>
<p>&nbsp;</p>
<form action="Software_upload" enctype="multipart/form-data" method="post" >
<table align="center"  bgcolor="#3366CC" width="451" >
  <tr >
    <td colspan="2"  height="50"><h2><font color="#FFFFFF" style="font-family:'Comic Sans MS', cursive">Upload Software</font></h2></td>
    
  </tr>
  <tr>
    <td width="178">&nbsp;</td>
    <td width="158">&nbsp;</td>
  </tr>
  <tr>
    <td><font color="#FFFFFF">Upload Your Software </font></td>
    <td><label for="file"></label>
      <input type="file" name="file" id="file" /></td>
  </tr>
  <tr height="4">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input align="middle" name="upload" type="submit" value="upload" /></td>
   
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
