package CSP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.sendrequest;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PRIndirectReference;
import com.lowagie.text.pdf.PRStream;
import com.lowagie.text.pdf.PRTokeniser;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfReader;

/**
 * Servlet implementation class Formonitor
 */
public class Formonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Formonitor() {
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
		// TODO Auto-generated method stub
		String fname=request.getParameter("ok");
		System.out.println("~~~~~~~~~~"+fname);
		String path="D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05\\WebContent\\UPLOADED_FILE\\"+fname;
		/*File f= new File(path);
		FileInputStream fis= new FileInputStream(f);
		try 
		{
			byte[] b=new byte[fis.available()];
			
			fis.read(b);
			String ss= new String(b);
			
			
			System.out.println(fis.read(b)+"                       "+ss+"    nmnbbnnmnmmnjyyftyyudsgfl h");
			
			
			
		} 
		catch (Exception e1)
		{
	
			e1.printStackTrace();
		}*/
		String test=null;
		try {
            Document document = new Document();
            document.open();
            PdfReader reader = new PdfReader(path);
            PdfDictionary dictionary = reader.getPageN(1);
            PRIndirectReference reference = (PRIndirectReference) dictionary
                            .get(PdfName.CONTENTS);
            PRStream stream = (PRStream) PdfReader.getPdfObject(reference);
            byte[] bytes = PdfReader.getStreamBytes(stream);
            PRTokeniser tokenizer = new PRTokeniser(bytes);
            StringBuffer buffer = new StringBuffer();
            while (tokenizer.nextToken()) {
                    if (tokenizer.getTokenType() == PRTokeniser.TK_STRING) {
                            buffer.append(tokenizer.getStringValue());
                    }
            }
            test = buffer.toString();
            System.out.println(test);
    } catch (Exception e)
    {
    	e.printStackTrace();
    }
	response.sendRedirect("http://localhost:8084/ITJCC05-Themis/Fromapp?ok="+test);
		
	}
	
}
