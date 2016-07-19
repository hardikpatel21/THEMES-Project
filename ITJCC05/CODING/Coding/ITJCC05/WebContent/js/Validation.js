function validate()
{
	var xmlhttp;
	var a=document.getElementById("uname").value;
	var url="db_data_check.jsp?uname="+a;
	//alert(a.value);
	if(window.XMLHttpRequest)
	{
		//alert("HAI1");
		xmlhttp=new XMLHttpRequest();
	}
	else
	{		
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if(xmlhttp.readyState==4)
		{
			var d=xmlhttp.responseText;
			//alert(d);
			document.getElementById("check").innerHTML=d;
		}
	}
	//alert("HAI 2");
	xmlhttp.open("POST",url,false);
	//alert("HAI 3");
	xmlhttp.send();
}