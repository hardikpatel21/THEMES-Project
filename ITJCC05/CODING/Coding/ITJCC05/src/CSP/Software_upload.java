package CSP;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dppack.Dbcontion;
import dppack.fctory_design.DBClass1;

/**
 *
 * @author spiro7-PC
 */
public class Software_upload extends HttpServlet {
   
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
		HttpSession  hp=request.getSession();
		
		String imagename=(String) hp.getAttribute("filename");
		System.out.println(imagename+"image name is ");
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
           
           saveFile = file.substring(file.indexOf("filename=\"") + 10);
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
           uploadedfile=context.getInitParameter("uploadedpath");
           FileOutputStream fileOut = new FileOutputStream(uploadedfile+"\\"+saveFile);
           
           fileOut.write(dataBytes, startPos, (endPos - startPos));
           fileOut.flush();
           fileOut.close();
           System.out.println("path is "+uploadedfile+"\\"+saveFile);
           String s=unzip(uploadedfile+"\\"+saveFile,count);
           String r=unziplist();
           
           Db_csp dbc=Db_csp.db_cspobject();
           System.out.println(imagename+"image name is ");
           dbc.swdetail(imagename,saveFile.trim());
           
           String a[]=saveFile.split(".zip");
           String sfile=a[0]+".class";
           
           HttpSession hs=request.getSession();
           hs.setAttribute("imagename", imagename);
           hs.setAttribute("filename", sfile);
          
           
           RequestDispatcher rdp=request.getRequestDispatcher("Softwaredetails_upload.jsp");
           rdp.forward(request, response);
	}
	
       else
       {
    	   System.out.println("file not uploaded");
       }
	
	String ContentType;
	byte[] b;
            
           
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
	 List<String> fileList;
	 String uploadedfile,saveFile;
	 static int count=0;
	 
//	    private  final String INPUT_ZIP_FILE = uploadedfile+"\\"+saveFile;
	    private  final String OUTPUT_FOLDER = "D://projectfinal//ITJCC05//CODING//Coding//ITJCC05//WebContent//UPLOADED_FILE//outputzip";
	 
	    public String unzip(String input,int num)
	    {
	    	System.out.println("gggggggggg"+input+" "+OUTPUT_FOLDER);
	    	unZipIt(input,OUTPUT_FOLDER);
	    	return "gg";
	    }
	 
	    /**
	     * Unzip it
	     * @param zipFile input zip file
	     * @param output zip file output folder
	     */
	    public void unZipIt(String zipFile, String outputFolder){
	 
	     byte[] buffer = new byte[1024];
	 
	     try{
	 
	    	//create output directory is not exists
	    	File folder = new File(OUTPUT_FOLDER);
	    	if(!folder.exists()){
	    		folder.mkdir();
	    	}
	 
	    	//get the zip file content
	    	ZipInputStream zis = 
	    		new ZipInputStream(new FileInputStream(zipFile));
	    	//get the zipped file list entry
	    	ZipEntry ze = zis.getNextEntry();
	 
	    	while(ze!=null){
	 
	    	   String fileName = ze.getName();
	           File newFile = new File(outputFolder + File.separator + fileName);
	 
	           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
	 
	            //create all non exists folders
	            //else you will hit FileNotFoundException for compressed folder
	            new File(newFile.getParent()).mkdirs();
	 
	            FileOutputStream fos = new FileOutputStream(newFile);             
	 
	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	       		fos.write(buffer, 0, len);
	            }
	 
	            fos.close();   
	            ze = zis.getNextEntry();
	    	}
	 
	        zis.closeEntry();
	    	zis.close();
	 
	    	System.out.println("Done");
	 
	    }catch(IOException ex){
	       ex.printStackTrace(); 
	    }
	   }    
	    
	    public  String unziplist() 
	    {
	     
	      // Directory path here
	      String path = "D://projectfinal//ITJCC05//CODING//Coding//ITJCC05//WebContent//UPLOADED_FILE//outputzip"; 
	     
	      String files;
	      File folder = new File(path);
	      File[] listOfFiles = folder.listFiles(); 
	     try{

	      for (int i = 0; i < listOfFiles.length; i++) 
	      {
	     
	       if (listOfFiles[i].isFile()) 
	       {
	       files = listOfFiles[i].getName();
	       FileInputStream in = new FileInputStream( "D://projectfinal//ITJCC05//CODING//Coding//ITJCC05//WebContent//UPLOADED_FILE//outputzip//"+files);
	       byte[] b=new byte[in.available()];
	       in.read(b);
	       System.out.println(files);
	       System.out.println(b.toString());

	    FileOutputStream in1 = new FileOutputStream( "D://projectfinal//ITJCC05//CODING//Coding//ITJCC05//WebContent//UPLOADED_FILE//"+files);
	      
	       in1.write(b);
	       System.out.println(files);
	       System.out.println(b.toString());


	       }
	       
	      
	      }
	    }
	    catch(Exception e)
	    	{
	    	System.out.println(e);
	    	}
	     return "hh";
	    }
}