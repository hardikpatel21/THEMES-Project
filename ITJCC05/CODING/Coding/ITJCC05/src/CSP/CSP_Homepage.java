package CSP;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CSP_Homepage
 */
public class CSP_Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSP_Homepage() {
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
			String admin_name=request.getParameter("username");
			String admin_pass=request.getParameter("password");
		 	HttpSession hs=request.getSession();
			hs.setAttribute("username", admin_name);
			
		
		if((admin_name.equalsIgnoreCase("admin"))&&(admin_pass.equalsIgnoreCase("admin")))
		{
			RequestDispatcher rd= request.getRequestDispatcher("/CSP_Homepage.jsp");
			rd.forward(request,response);
		}
		else
		{
			System.out.println("Servlet else case");
			RequestDispatcher rd= request.getRequestDispatcher("/User_homepage.jsp");//user_page_details
			rd.forward(request,response);
		}
	}

}
