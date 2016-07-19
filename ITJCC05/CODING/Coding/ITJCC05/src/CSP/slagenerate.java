package CSP;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dppack.fctory_design.DBClass1;

/**
 * Servlet implementation class slagenerate
 */
public class slagenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public slagenerate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ServletContext context=getServletContext();
		String path=context.getInitParameter("slapath");
		String val=null,cost=null,image=null,phone=null,mail=null,address=null;
		List sla=new ArrayList();
		response.setContentType("text/html; charset=utf-8" );
		String c=request.getParameter("select");
		String[] s=c.split("#");
		String sname=s[0];
		String uname=s[1];
		System.out.println(sname+"   gggg   "+uname);
		DBClass1 db= new DBClass1();
		System.out.println("db con is "+db);
		java.sql.Connection cont=db.connect();
		System.out.println("hghghg"+cont);
		
		try
		{
			Statement st= cont.createStatement();
			System.out.println("Select validity,cost,image from upload where name='"+sname+"'");
			ResultSet rs=st.executeQuery("Select validity,cost,image from upload where name='"+sname+"'");
			
			while(rs.next())
			{
				val=rs.getString(1);
				cost=rs.getString(2);
				image=rs.getString(3);
				System.out.println(val+"   "+cost+"  "+image);
			}
			Statement st1= cont.createStatement();
			ResultSet rs1=st1.executeQuery("Select phone_no,email_id,address from user where user_name='"+uname+"'");
			while(rs1.next())
			{
				phone=rs1.getString(1);
				mail=rs1.getString(2);
				address=rs1.getString(3);
				System.out.println(phone+"   "+mail+"  "+address);
			}
			
			Random rand = new Random();
			int num = rand.nextInt(10000);
			System.out.println("Generated Random Number between 0 to 10000 is : " + num);
			sla.add(uname);
			sla.add(mail);
			sla.add(phone);
			sla.add(address);
			sla.add(sname);
			sla.add(val);
			sla.add(cost);
			sla.add(image);
			sla.add(num);
			sla.add(path);
			/*String pat=getServletContext().getInitParameter("Monitorpath");
			sla.add(pat);*/
			SlaPDF p= new SlaPDF();
			p.sla(sla);
			
			request.setAttribute("sname", sname);
			request.setAttribute("uname",uname);
			RequestDispatcher rd=request.getRequestDispatcher("response.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
