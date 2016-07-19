package CSP;
import java.io.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.*;

import dppack.fctory_design.DBClass1;

import java.sql.Statement;
import java.util.*;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

  public class SlaPDF extends HttpServlet
   {
    public  void sla(List sla_list)throws Exception
      {
    	try
    	{
    	System.out.println("come inside");
    	String uname=(String) sla_list.get(0);
    	String mail=(String) sla_list.get(1);
    	String phone=(String) sla_list.get(2);
    	String address=(String) sla_list.get(3);
    	String sname=(String) sla_list.get(4);
    	String val=(String) sla_list.get(5);
    	String cost=(String) sla_list.get(6);
    	String image1=(String) sla_list.get(7);
    	int id= (Integer) sla_list.get(8);
    	String path=sla_list.get(9).toString();
//    	String pat=sla_list.get(10).toString();
    	System.out.println("path FF GG HH:"+path+"()()()()()  ");
    	
    	Document document=new Document(PageSize.A4);
	   PdfWriter.getInstance(document,new FileOutputStream(path+"\\"+uname+"-"+sname+".pdf"));
	   System.out.println("path FF GG HH:"+path);
//	   PdfWriter.getInstance(document,new FileOutputStream(pat+"\\"+uname+"-"+sname+".pdf"));
		document.open(); 
		

	   Image image = Image.getInstance ("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05\\WebContent\\UPLOADED_FILE\\serviceGuarantee.jpg");
		image. scaleAbsolute(75,75);
		image.setRotationDegrees(45f);
		Image image2 = Image.getInstance ("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05\\WebContent\\UPLOADED_FILE\\"+image1);
		image2. scaleAbsolute(75,75);
//		Image image3 = Image.getInstance ("E:\\ITJCC05\\WebContent\\UPLOADED_FILE\\passicon.jpg");
//		image3. scaleAbsolute(24,25);
		
			Chunk chunk = new Chunk("CLOUD SERVICE PROVIDER");
			Font font1 = new Font(Font.TIMES_ROMAN );
			font1.setStyle(Font.BOLD);
			chunk.setFont(font1);
			Paragraph p1 = new Paragraph(chunk);
			p1.setAlignment(Element.ALIGN_CENTER);
		

		 
	

			Chunk chunk1 = new Chunk("Service Level Agreement");
			Font font = new Font(Font.TIMES_ROMAN);
			font.setStyle(Font.UNDERLINE);
			font.setStyle(Font.BOLD);
			font.setColor(139,0,0);
			chunk1.setFont(font);
			Paragraph p = new Paragraph(chunk1);
			p.setAlignment(Element.ALIGN_CENTER);

			Chunk a = new Chunk(" NAME :");
			Chunk a1 = new Chunk(" Mail Id :");
			Chunk a2 = new Chunk(" Phone :");
			Chunk a3 = new Chunk(" Address :");
			Font font2 = new Font(Font.TIMES_ROMAN);
			//font2.setStyle(Font.BOLD);
			font2.setColor(139,69,19);
			a.setFont(font2);
			a1.setFont(font2);
			a2.setFont(font2);
			a3.setFont(font2);

			Paragraph p2 = new Paragraph();
			p2.add(a);
			p2.add(uname);
			p2.add( Chunk.NEWLINE );
			p2.add( Chunk.NEWLINE );
			p2.add(a1);
			p2.add(mail);
			p2.add( Chunk.NEWLINE );
			p2.add( Chunk.NEWLINE );
			p2.add(a2);
			p2.add(phone);
			p2.setAlignment(Element.ALIGN_LEFT);
	
			Paragraph p3 = new Paragraph();
			p3.add(a3);
			p3.add( Chunk.NEWLINE );
			p3.add(address);
			p3.setAlignment(Element.ALIGN_RIGHT);

			Chunk a4 = new Chunk(" Software Name :");
			Chunk a5 = new Chunk(" Period :");
			Chunk a6 = new Chunk(" Cost in INR :");
			Chunk a7= new Chunk(" "+id);
			Font font3 = new Font(Font.TIMES_ROMAN);
			font3.setColor(255,69,0);
			a4.setFont(font3);
			a5.setFont(font3);
			a6.setFont(font3);
			a7.setFont(font3);
			Paragraph p4 = new Paragraph();
			p4.add(a4);
			p4.add(sname);
			p4.add( Chunk.NEWLINE );
			p4.add(a5);
			p4.add(val);
			p4.add( Chunk.NEWLINE );
			p4.add(a6);
			p4.add(cost);
			p4.setAlignment(Element.ALIGN_CENTER);
			
			
			Paragraph p5 = new Paragraph();
			p5.add(new Paragraph("Your Account id for this software is "+id));
			
			Calendar c=new GregorianCalendar();
			String date=c.getTime().toString();

			Paragraph p6 = new Paragraph();
			p6.add(new Paragraph("SLA generated on "+  " "+ date));
	   	PdfPTable table=new PdfPTable(2);
		table.addCell(p2);
		table.addCell(p3);
		
		PdfPTable table1=new PdfPTable(2);
		table1.addCell(p4);
		table1.addCell(image2);
		
		
		
		document.add(p1);
		document.add( Chunk.NEWLINE );
		
		      
		document.add(p);
		document.add( Chunk.NEWLINE );
       
		document.add(table);
		document.add( Chunk.NEWLINE );
		document.add(image);
		document.add(table1);
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		document.add(p5);
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		document.add(p6);
		document.close();
		
		
		/*File f=new File("D:\\"+uname+"-"+sname+".pdf");
		FileInputStream fis=new FileInputStream(f);
		byte b[]=new byte[fis.available()];
		fis.read(b);
		String s=new String(b);
		System.out.println("the content of the file is :"+s);*/
    	
			DBClass1 db= new DBClass1();
			System.out.println("db con is "+db);
			java.sql.Connection cont=db.connect();
			System.out.println("hghghg"+cont);
			Statement st= cont.createStatement();
			System.out.println("insert into Response values('"+sname+"','"+uname+"','"+"D:/"+uname+"-"+sname+".pdf"+"','"+id+"','"+date+"') ");
			int j=st.executeUpdate("insert into Response values('"+sname+"','"+uname+"','"+"D:/"+uname+"-"+sname+".pdf"+"','"+id+"','"+date+"') ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		 
		 
      }
}