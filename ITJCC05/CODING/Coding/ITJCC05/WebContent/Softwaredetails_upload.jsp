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
<%String swname = (String)session.getAttribute("filename");
String imagename=(String)session.getAttribute("imagename"); %>
<table width="365" border="0">
  <tr>
    <td width="83">Your Image</td>
    <td width="272"><%=imagename %> is sucessfully uploaded</td>
  </tr>
  <tr>
    <td>Your Software</td>
    <td><%=swname %>is sucessfully uploaded</td>
  </tr>
</table>


<form action=Softwaredetails_upload method="post">
  <table align="center"  bgcolor="#3366CC" width="451" >
  <tr >
    <td colspan="2"  height="50"><h2><font color="#FFFFFF" style="font-family:'Comic Sans MS', cursive">Upload Details</font></h2></td>
    
  </tr>
  <tr>
    <td width="217">&nbsp;</td>
    <td width="222">&nbsp;</td>
  </tr>
  <tr>
    <td align="right"><font color="#FFFFFF"> Software name</font></td>
    <td><label for="file"></label>
      <label for="softwarename"></label>
      <input type="text" name="softwarename" id="softwarename" /></td>
  </tr>
  <tr height="4">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    
  </tr>
  <tr height="4">
    <td align="right"><font color="#FFFFFF">Service Period</font></td>
    <td><label for="file"></label>
      <label for="validity"></label><input type="text" name="validity" id="validity" /><font color="#FFFFFF">days</font></td>
    
  </tr>
  <tr height="4">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    
  </tr>
  <tr height="4">
    <td align="right"><font color="#FFFFFF">Service Cost</font></td>
  <td ><input type="image" src="images/Indian_Rupee_symbol.png" height="15"/><label for="file"></label>
      <label for="cost"></label>
      <input type="text" name="cost" id="cost" /><font color="#FFFFFF"></font></td>
    
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
