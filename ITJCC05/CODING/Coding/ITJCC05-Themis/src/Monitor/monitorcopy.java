package Monitor;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Monitor.SlaPDF;

import db.DBClass2;


/**
 * Servlet implementation class monitorcopy
 */
public class monitorcopy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public monitorcopy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("monitor hit");
		String val=null,cost=null,image=null,phone=null,mail=null,address=null,id=null,date=null;
		HttpSession hs= request.getSession();
		String file=hs.getAttribute("file").toString();
		response.setContentType("text/html; charset=utf-8" );
		String pat=getServletContext().getInitParameter("Monitorpath");
		System.out.println("file name is"+file+"  "+pat);
		String[] s= file.split("-");
		String name=s[0];
		System.out.println(name+"   "+s[1]);
		
		int p=s[1].indexOf(".");
		String sw=s[1].substring(0,p);
		System.out.println(sw);
		
		DBClass2 db= new DBClass2();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
		System.out.println("hghghg"+cont);
		List l= new ArrayList();
		
		try
		{
			Statement st= cont.createStatement();
			System.out.println("Select validity,cost,image from upload where name='"+sw+"'");
			ResultSet rs=st.executeQuery("Select validity,cost,image from upload where name='"+sw+"'");
			
			while(rs.next())
			{
				val=rs.getString(1);
				cost=rs.getString(2);
				image=rs.getString(3);
				System.out.println(val+"   "+cost+"  "+image);
			}
			Statement st1= cont.createStatement();
			ResultSet rs1=st1.executeQuery("Select phone_no,email_id,address from user where user_name='"+name+"'");
			while(rs1.next())
			{
				phone=rs1.getString(1);
				mail=rs1.getString(2);
				address=rs1.getString(3);
				System.out.println(phone+"   "+mail+"  "+address);
			}
			System.out.println(phone+" gggbbbb  "+mail+"  "+address);
			Statement st2= cont.createStatement();
			ResultSet rs2=st2.executeQuery("Select id,date from response where user='"+name+"' and software='"+sw+"'");
			while(rs2.next())
			{
				id=rs2.getString(1);
				date=rs2.getString(2);
				
				System.out.println(id+"   "+"  "+date);
			}
			System.out.println(id+" nnn  "+"  "+date);
			
			
			l.add(name);
			l.add(mail);
			l.add(phone);
			l.add(address);
			l.add(sw);
			l.add(val);
			l.add(cost);
			l.add(image);
			l.add(id);
			l.add(date);
			l.add(pat);
			/*String pat=getServletContext().getInitParameter("Monitorpath");
			sla.add(pat);*/
			SlaPDF sl= new SlaPDF();
			sl.sla(l);
			
			
			request.setAttribute("sname", sw);
			request.setAttribute("uname",name);
			RequestDispatcher rd=request.getRequestDispatcher("Monitor/"+file);
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
