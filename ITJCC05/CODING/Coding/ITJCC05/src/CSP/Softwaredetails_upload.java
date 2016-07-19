package CSP;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Softwaredetails_upload	
 */
public class Softwaredetails_upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Softwaredetails_upload() {
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
		String swname=request.getParameter("softwarename");
		String validity=request.getParameter("validity");
		String cost=request.getParameter("cost");
		HttpSession  hp=request.getSession();
		String swfile=(String) hp.getAttribute("filename");
		String imagename=(String) hp.getAttribute("imagename");
		
		 Db_csp dbc=Db_csp.db_cspobject();
         System.out.println(imagename+"image name is ");
         dbc.softwaredetails(imagename,swfile,swname,validity,cost);
         
         HttpSession hs=request.getSession();
         hs.setAttribute("name",swname);
         RequestDispatcher rdp=request.getRequestDispatcher("AfterUpload.jsp");
         rdp.forward(request, response);
		
		
	}

}
