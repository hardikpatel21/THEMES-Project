package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dppack.fctory_design.DBClass1;

/**
 * Servlet implementation class ready
 */
public class ready extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ready() {
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
		int amount=0;
		try
		{
		String username=request.getParameter("username");
		String software=request.getParameter("software");
		
		DBClass1 db= new DBClass1();
		Connection con= db.connect();
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery("select amount from forbank where name='"+username+"'and software='"+software+"'");
		while(rs.next())
		{
			amount=rs.getInt(1);
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		request.setAttribute("amount",amount);
		RequestDispatcher rd=request.getRequestDispatcher("Payment.jsp");
		rd.forward(request, response);
	}

}
