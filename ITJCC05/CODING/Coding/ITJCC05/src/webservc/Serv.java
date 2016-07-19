package webservc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

/**
 * Servlet implementation class Serv
 */
public class Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 payment.PayServiceLocator service = new payment.PayServiceLocator();
			payment.Pay port;
			java.lang.String result=null;
			try {
				port = service.getPayPort();
				java.lang.String acno = request.getParameter("account");
			java.lang.String name = request.getParameter("pass");
			java.lang.String amount = request.getParameter("amount");
			result = port.paybill(acno, name, amount);
		            System.out.println("result is "+result);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result.equals("succss"))
			{
				System.out.println("yes");
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			if(result.equals("fail"))
			{
				System.out.println("yes sss");
				RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");
				rd.forward(request, response);
			}
		
	}

}
