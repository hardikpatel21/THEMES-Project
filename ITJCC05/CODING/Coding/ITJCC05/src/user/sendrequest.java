package user;

import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import dppack.fctory_design.DBClass1;

/**
 * Servlet implementation class User_homepage
 */
public class sendrequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendrequest() {
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
		response.setContentType("text/html; charset=utf-8" );
		String swname=request.getParameter("select");
		HttpSession hp=request.getSession();
		String uname=hp.getAttribute("username").toString();
		System.out.println("    "+swname+"   bbb   "+uname);
		Calendar c=new GregorianCalendar();
		String date=c.getTime().toString();
		System.out.println(date);
		try
		{
			DBClass1 db= new DBClass1();
			System.out.println("db con is "+db);
			java.sql.Connection cont=db.connect();
			System.out.println("hghghg"+cont);
			Statement st= cont.createStatement();
			int j=st.executeUpdate("insert into request_from_user values('"+swname+"','"+uname+"','"+date+"')");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		String msg="success";
		hp.setAttribute("message", msg);
		RequestDispatcher rd=request.getRequestDispatcher("User_homepage.jsp");
		rd.forward(request, response);
	}

}
