

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
String send="";
System.out.println("hellooooo~~~~~~~~~");
String sn=request.getParameter("ok");
int i=Integer.parseInt(sn);
  String url = "jdbc:mysql://localhost:3306/";
              String dbName = "Bank";
              String driver = "com.mysql.jdbc.Driver";
              String userName = "root";
              String password = "root";
        try {
                 Class.forName(driver).newInstance();
               Connection cont =DriverManager.getConnection(url+dbName,userName,password);
               Statement st=cont.createStatement();
ResultSet rs = st.executeQuery("select * from useraccount where Acno="+i);
if(rs.next())
{
   
send="$"+rs.getString(1)+
      "$"+rs.getString(2)+
      "$"+rs.getString(3)+
      "$"+rs.getString(4)+
      "$"+rs.getString(5)+
      "$"+rs.getString(6)+
      "$"+rs.getString(8);
}
out.println(send);
rs.close();
st.close();
cont.close();


        }
        catch (Exception e)
            {
                 e.printStackTrace();
             }

%>