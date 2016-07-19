package CNA;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Monitor.Compare_monitor;

/**
 * Servlet implementation class billing
 */
public class billing extends HttpServlet {
	List status=null;
	private static final long serialVersionUID = 1L;
       
    /**u
     * @see HttpServlet#HttpServlet()
     */
    public billing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String abc=(String)request.getParameter("us");
		String cc=request.getParameter("sw");
		System.out.println("abc is "+abc+"             "+cc);
		status=Example1.compare(abc);
		System.out.println(status.size());
		ServletContext context=getServletContext();
		String Billpath=context.getInitParameter("Billpath");
		if(status.size()==8)
		{
			try{
			BillPDF bb= new BillPDF();
			String date=bb.bill(status,Billpath);
			HttpSession hs= request.getSession();
			hs.setAttribute("bill", date);
			
			RequestDispatcher rd= request.getRequestDispatcher("afterbilling.jsp");
			rd.forward(request, response);
			
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		if(status.size()==10)
		{
			try{
			Compare_monitor cm= new Compare_monitor();
			String cond=cm.compare_with_monitor(status, abc);
			status.add(cond);
			
			BillPDF bb= new BillPDF();
			String date=bb.bill(status,Billpath);
			HttpSession hs= request.getSession();
			hs.setAttribute("bill", date);
			RequestDispatcher rd= request.getRequestDispatcher("afterbilling.jsp");
			rd.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

}
