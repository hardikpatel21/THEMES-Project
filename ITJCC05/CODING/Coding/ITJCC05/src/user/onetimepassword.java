package user;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import dppack.fctory_design.DBClass1;

/**
 * Servlet implementation class onetimepassword
 */
public class onetimepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public onetimepassword() {
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
		String password=request.getParameter("pass");
		HttpSession hs= request.getSession();
		String uname=hs.getAttribute("username").toString();
		String sw=null;
		try
		{
			DBClass1 db= new DBClass1();
			System.out.println("db con is "+db);
			java.sql.Connection cont=db.connect();
			System.out.println("hghghg"+cont);
			Statement st= cont.createStatement();
			ResultSet rs=st.executeQuery("select software from response where user='"+uname+"' and id='"+password+"'");
			while(rs.next())
			{
				sw=rs.getString(1);
				System.out.println("name is nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"+sw);
			}
			hs.setAttribute("msg", sw);System.out.println("entering into one time"+sw);
			RequestDispatcher rd=request.getRequestDispatcher("app.jsp");
			System.out.println("entering into one time");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}

}
