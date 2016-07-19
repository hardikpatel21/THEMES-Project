package CSP;

import java.io.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.*;
  class HelloWordPDF
   {
    public static void main(String arg[])throws Exception
      {
       Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("hello1.pdf"));
      document.open();  
      document.add(new Paragraph("Hello Pdf"));
      document.close(); 
      }
}
