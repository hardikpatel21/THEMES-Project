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
<script type="text/javascript" src="js/Validation.js"></script>
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
</head>
<body>
</script>
<script language="javascript">
function validate_register()
{
	var a=document.getElementById("name");
	var b=document.getElementById("password");
	var c=document.getElementById("uname");
	var d=document.getElementById("rpass");
	var e=document.getElementById("phone");
	var f=document.getElementById("email");
	var g=document.getElementById("addr");	
	var h=document.getElementById("acc");
	var n=e.value.length;
	var ac=h.value.length;
	var em=f.value;
	var a1=em.indexOf("@");
	var b1=em.indexOf("."); 
	var numbers = /^[0-9]+$/;  
	if(a.value=="")
	{
		alert("Enter the Name");
		a.focus();
		return false;		
	}
	else if(c.value=="")
	{
		alert("Enter the Username");
		c.focus();
		return false;		
	}
	else if(b.value=="")
	{
		alert("Enter the Password");
		b.focus();
		return false;		
	}	
	else if(d.value=="")
	{
		alert("Enter the Confirm Password");
		d.focus();
		return false;		
	}
	else if(d.value!=b.value)
	{			
		alert("MisMatch Password");
		d.focus();
		return false;		
	}	
	else if(d.value.length<6||b.value.length<6)
	{
		alert("Password must contains 6 character");
		d.focus();
		return false;	
	}
	else if(e.value=="")
	{
		alert("Enter the Phone Number");
		e.focus();
		return false;		
	}
	else if(n!=10)
	{
		alert("Enter the 10 Character Phone Number");
		e.focus();
		return false;
	}	
	else if(!e.value.match(numbers))
	{
		alert(numbers);
		alert("Phone Number must be Number");
		e.focus();
		return false;
	}
	else if(f.value=="")
	{
		alert("Enter the Email");
		f.focus();
		return false;		
	}
	else if(a1>b||a1==-1||b1==-1)
	{
		alert("Enter the Proper MailID");
		f.focus();
		return false;
	}	
	else if(g.value=="")
	{
		alert("Enter the Address");
		g.focus();
		return false;		
	}
	else if(h.value=="")
	{
		alert("Enter the Account Number");
		h.focus();
		return false;		
	}
	else if(!h.value.match(numbers))
	{
		alert(numbers);
		alert("Phone Number must be Number");
		e.focus();
		return false;
	}
	else if(ac<4)
	{
		alert("Account Number must be contains Above 4 Characters");
		h.focus();
		return false;
	}		
	
}
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
          <li class="active"><a href="Home.jsp"><span>Home Page</span></a></li>
          <li><a href="support.jsp"><span>Support</span></a></li>
          <li><a href="about.jsp"><span>About Us</span></a></li>          
          <li><a href="contact.jsp"><span>Contact Us</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> 
			<a href="#"><img src="images/slide1.jpg" width="960" height="360" alt="" />
				<span>
					<big>
							Billing System
					</big>
					<br />
							Cloud computing is the use of computing resources (hardware and software) that are delivered as a service over a network (typically the Internet). The name comes from the use of a cloud-shaped symbol as an abstraction for the complex infrastructure it contains in system diagrams. Cloud computing entrusts remote services with a user's data, software and computation.
				  </span>
			</a> 
			<a href="#"><img src="images/slide2.jpg" width="960" height="360" alt="" />
				<span>
					<big>
						sharing of resources
					</big>
					<br />
							Cloud computing relies on sharing of resources to achieve coherence and economies of scale similar to a utility (like the electricity grid) over a network. At the foundation of cloud computing is the broader concept of converged infrastructure and shared services.
				</span>
			</a> 
			<a href="#"><img src="images/header_bg.jpg" width="960" height="360" alt="" />
					<span>
							<big>
										Private cloud
							</big>
							<br />
								Private cloud is cloud infrastructure operated solely for a single organization, whether managed internally or by a third-party and hosted internally or externally. Undertaking a private cloud project requires a significant level and degree of engagement to virtualize the business environment, and it will require the organization to reevaluate decisions about existing resources.
					</span>
			</a> 
		</div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>Excellent Solution</span> For Your Billing System</h2>          
          <div class="clr"></div>
          <div class="img"><img src="images/img1.jpg" width="236" height="245" alt="" class="fl" /></div>
          <div class="post_content">
            <p><br/>
					We built a billing management system that allows you to worry about building your business, not your billing system. Chargify can help you: <br/><br/>
					<img src="images/checked.gif">Charge your customers’ credit cards securely<br/>
					<img src="images/checked.gif">Get real-time insight into orders & revenue<br/>
					<img src="images/checked.gif">Manage the dunning process when cards fail<br/>
					<img src="images/checked.gif">Handle free trials, promotions, refunds & more<br/>
					<img src="images/checked.gif">Charge customers on a per-usage basis<br/>
			</p>            
          </div>      
        </div>      
      </div>
      <form action="Register" method="post">
      <div class="sidebar">
        <div class="gadget">
          <h2 class="star"><span></span>Registration</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
			<table>
				<tr>
				<br/>
				</tr>
				<tr>
					<td>
							Name
					</td>
					<td>
						  <input type="text" id="name" name="name"/>
					</td>
				</tr>
				<tr>
					<td>
							 Username
					</td>
					<td>
							<input type="text" id="uname" name="username" onchange="return validate()"/>
					</td>
					<td>
							<p id="check">Status</p>
					</td>
				</tr>
				<tr>
					<td>
							 Password
					</td>
					<td>
							<input type="password" id="password" name="password"/>
					</td>
				</tr>
				<tr>
					<td>
							 Confirm Password
					</td>
					<td>
							<input type="password" id="rpass" name="rpassword"/>
					</td>
				</tr>
				<tr>
					<td>
							 Phone Number
					</td>
					<td>
							<input type="text" id="phone" name="phone"/>
					</td>
				</tr>
				<tr>
					<td>
							 Email
					</td>
					<td>
							<input type="text" id="email" name="email"/>
					</td>
				</tr>
				<tr>
					<td>
							 Address
					</td>
					<td>
							<textarea name="addr" id="addr"></textarea>
							
					</td>
				</tr>
				<tr>
					<td>
							 Account Number
					</td>
					<td>
							<input type="password" id="acc" name="acc"/>
							
					</td>
				</tr>					
				<tr>					
					<td>						
							<input type="submit" value="Register" onclick="return validate_register()" /> 
					</td>					
				</tr>
				<tr>
					<%String result=(String)session.getAttribute("result"); 
					if(result==null)
					{
						
					}
					else if(result.equalsIgnoreCase("success"))
					{
					%>
					<img src="images/comment_success.png" /> 
					<%
					}
					else if(result.equalsIgnoreCase("fail"))
					{%>
					<img src="images/400-04919179w.jpg" width="30" height="40"/> Failed
					<%}%>
										
				</tr>
			</table>
          </ul>
        </div>        
      </div>
      </form>
      <div class="clr"></div>
    </div>
  </div>
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
