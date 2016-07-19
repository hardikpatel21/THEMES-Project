package CNA;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.*;

/**
 * Servlet implementation class receiveSLA
 */
public class receiveSLA extends HttpServlet {
	String saveFile,uploadedfile;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public receiveSLA() {
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
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {
	    	        response.setContentType("text/html;charset=UTF-8");
	    	        PrintWriter out = response.getWriter();
	    	        ServletContext context=getServletContext();
	    	        String status=request.getParameter("name");
	    	        try
	    	        {
	    	            
	    	            
	    			String contentType = request.getContentType();
	    	        System.out.println("content type "+contentType);
	    	       if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
	    	           DataInputStream in = new DataInputStream(request.getInputStream());
	    	           //we are taking the length of Content type data
	    	           int formDataLength = request.getContentLength();
	    	           byte dataBytes[] = new byte[formDataLength];
	    	           int byteRead = 0;
	    	           int totalBytesRead = 0;
	    	           //this loop converting the uploaded file into byte code
	    	          while (totalBytesRead < formDataLength) 
	    			  {
	    	               byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
	    	               totalBytesRead += byteRead;
	    	           }
	    	          int fileSize=dataBytes.length;
	    	           String file = new String(dataBytes);
	    	           //for saving the file name
	    	        //   System.out.println("file is nnnnnnnnnnn="+file+"xxxxxxxxxxxxxxx");
	    	           
	    	           saveFile= file.substring(file.indexOf("filename=\"") + 10);
	    	          // System.out.println("save file is "+file);
	    	           saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
	    	           saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
	    	           int lastIndex = contentType.lastIndexOf("=");
	    	           String boundary = contentType.substring(lastIndex + 1, contentType.length());
	    	           int pos;
	    	           //extracting the index of file
	    	           pos = file.indexOf("filename=\"");
	    	           pos = file.indexOf("\n", pos) + 1;
	    	           pos = file.indexOf("\n", pos) + 1;
	    	           pos = file.indexOf("\n", pos) + 1;
	    	           int boundaryLocation = file.indexOf(boundary, pos) - 4;
	    	           int startPos = ((file.substring(0, pos)).getBytes()).length;
	    	           int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
	    	           // creating a new file with the same name and writing the content in new file
	    	           String path = request.getRealPath("");
	    	           System.out.println("path="+path);
	    	           System.out.println("saved name is"+saveFile);
	    	         //  FileOutputStream fileOut = new FileOutputStream("D:\\VIVEK\\ITJCC04\\ITJCC04\\PUBLIC CLOUD\\build\\web\\"+saveFile);
	    	           uploadedfile =context.getInitParameter("uploadedpath");
	    	           FileOutputStream fileOut = new FileOutputStream(uploadedfile+"//"+saveFile);
	    	           fileOut.write(dataBytes, startPos, (endPos - startPos));
	    	           fileOut.flush();
	    	           fileOut.close();
	    	           
	    	           HttpSession hs=request.getSession();
	    				hs.setAttribute("filename", saveFile);
	    				
	    				String[] s=saveFile.split("-");
	    				
	    				String name=s[0];
	    				System.out.println(s[1]+"hnhnhnhnh");
	    				
	    			
	    				
	    				String path1="D:/projectfinal/ITJCC05/CODING/Coding/ITJCC05-Themis/WebContent/Monitor"+"/"+saveFile;
	    				int p=s[1].indexOf(".");
	    				String sw=s[1].substring(0,p);
	    				
	    				
	    				System.out.println(s[1]+"gggggg"+name+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"+path1+"ioio"+sw);
	    	        
	    				try
	    				{
	    					DBClass1 db= new DBClass1();
	    					System.out.println("db con is "+db);
	    					java.sql.Connection cont=db.connect();
	    					System.out.println("hghghg"+cont);
	    				/*java.sql.Connection con=Dbcontion.getinstance().connect();
	    				System.out.println(con+":::::::::::::::::::::::::::::::::::::::");*/
	    				Statement st= cont.createStatement();
	    				int j=st.executeUpdate("insert into receivesla values('"+name+"','"+path1+"','"+0+"','"+sw+"','"+0+"')");
	    				System.out.println("insert into receivesla values('"+name+"','"+path1+"','"+0+"','"+sw+"')");
	    				}
	    				catch(Exception e)
	    				{
	    					e.printStackTrace();
	    				}
	    	        
	    	        
	    	       
	    				response.sendRedirect("http://localhost:8084/ITJCC05/Bill1.jsp");
	    				/*RequestDispatcher rdp=request.getRequestDikspatcher();
	    		        dp.forward(request, response);*/
	    			
	    				
	    		
	    			
	    			
	    		}
	    		
	    	       else
	    	       {
	    	    	   System.out.println("file not uploaded");
	    	       }
	    		
	    		String ContentType;
	    		byte[] b;
	    	            
	    	            
	    	            /* TODO output your page here
	    	            out.println("<html>");
	    	            out.println("<head>");
	    	            out.println("<title>Servlet UploadFile</title>");  
	    	            out.println("</head>");
	    	            out.println("<body>");
	    	            out.println("<h1>Servlet UploadFile at " + request.getContextPath () + "</h1>");
	    	            out.println("</body>");
	    	            out.println("</html>");
	    	            */
	    	        } finally { 
	    	            out.close();
	    	        }
	    	    } 
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
		
		 
	}

}
