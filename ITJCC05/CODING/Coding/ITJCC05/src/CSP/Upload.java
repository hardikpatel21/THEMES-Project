package CSP;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author spiro7-PC
 */
public class Upload extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext context=getServletContext();
        
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
           fileSize=dataBytes.length;
           String file = new String(dataBytes);
           //for saving the file name
        //   System.out.println("file is nnnnnnnnnnn="+file+"xxxxxxxxxxxxxxx");
           
           String saveFile = file.substring(file.indexOf("filename=\"") + 10);
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
           String uploadedfile=context.getInitParameter("uploadedpath");
           FileOutputStream fileOut = new FileOutputStream(uploadedfile+"\\"+saveFile);
           fileOut.write(dataBytes, startPos, (endPos - startPos));
           fileOut.flush();
           fileOut.close();
           
           HttpSession hs=request.getSession();
			hs.setAttribute("filename", saveFile);
         
         /*Calendar cal=Calendar.getInstance();
         cal.getTime();
         SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");*/
         
         
        
        
       // al=(ArrayList)PublicDBClass.singleton().getFileNames(UserName);
        
          // hs.setAttribute("filenames",al);
        RequestDispatcher rdp=request.getRequestDispatcher("AfterUpload.jsp");
        rdp.forward(request, response);
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
Connection con;
	Statement st;
	int fileSize;
	String UserName;
	ArrayList al;
}