package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



/**
 * Servlet Filter implementation class Authentication
 */
public class Authentication implements Filter {

    /**
     * Default constructor. 
     */
    public Authentication() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Flitter class ");
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		System.out.println("The user name and password is the:"+name+""+pass);
		
		if((name.equalsIgnoreCase("admin")&pass.equalsIgnoreCase("admin")))
		{
			System.out.println("checking purpose");
			chain.doFilter(request, response);			
		}
		else 		
		{	
			System.out.println("else case in Flitter");
			RequestDispatcher rd=request.getRequestDispatcher("/Home.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
