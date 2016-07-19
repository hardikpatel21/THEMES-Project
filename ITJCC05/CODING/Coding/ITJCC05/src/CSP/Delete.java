package CSP;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dppack.fctory_design.DBClass1;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		HttpSession hp=request.getSession();
		String[] name_to_delete=request.getParameterValues("select");
		for(int i=0;i<name_to_delete.length;i++)
		{
			System.out.println(name_to_delete[i]+"   string array");
		}
		
		try
		{
			DBClass1 db= new DBClass1();
			System.out.println("db con is "+db);
			java.sql.Connection cont=db.connect();
			System.out.println("hghghg"+cont);
		/*java.sql.Connection con=Dbcontion.getinstance().connect();
		System.out.println(con+":::::::::::::::::::::::::::::::::::::::");*/
		
			for(int i=0;i<name_to_delete.length;i++)
			{	
				String file=null;
				/*Statement st= cont.createStatement();
				ResultSet rs=st.executeQuery("Select software from upload where image='"+name_to_delete[i]+"'");
				while(rs.next())
				{
					file=rs.getString(1);
				}
				System.out.println(file+"HNK:MFJ");*/
				Statement st1= cont.createStatement();
				st1.execute("Delete from upload where  image='"+name_to_delete[i]+"' ");
				System.out.println("Delete from upload where  image='"+name_to_delete[i]+"' ");
			
				
				
				RequestDispatcher rdp=request.getRequestDispatcher("CSP_Homepage.jsp");
		        rdp.forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
