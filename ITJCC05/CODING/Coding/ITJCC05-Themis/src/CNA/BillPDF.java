package CNA;

import java.io.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.*;
import com.mysql.jdbc.Connection;

import db.DBClass2;



import java.sql.Statement;
import java.util.*;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

  public class BillPDF extends HttpServlet
   {
    public String bill(List bill,String path)throws Exception
      {
    	
    	System.out.println("come inside"+bill.size());
    	String date=null;
    	if(bill.size()==8)
    	{
    	String uname=(String) bill.get(0);
    	String mail=(String) bill.get(1);
    	String phone=(String) bill.get(2);
    	String address=(String) bill.get(3);
    	String sname=(String) bill.get(4);
    	String val=(String) bill.get(5);
    	String cost=(String) bill.get(6);
    	String sla_date=(String) bill.get(7);
    	
    	
    	System.out.println("path FF GG HH:"+path);
    	
    	Document document=new Document(PageSize.A4);
	   PdfWriter.getInstance(document,new FileOutputStream(path+"\\"+uname.substring(1)+"-"+sname.substring(1)+" bill.pdf"));
	   System.out.println("path FF GG HH:"+path);
		
		document.open(); 
		

	   Image image = Image.getInstance ("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05-Themis\\WebContent\\images\\New rupee symbol.png");
		image. scaleAbsolute(75,75);
		image.setRotationDegrees(45f);
		Image image1 = Image.getInstance ("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05-Themis\\WebContent\\images\\4.jpg");
		image1. scaleAbsolute(48,48);
		/*Image image2 = Image.getInstance ("E:\\ITJCC05\\WebContent\\UPLOADED_FILE\\"+image1);
		image2. scaleAbsolute(75,75)*/;
//		Image image3 = Image.getInstance ("E:\\ITJCC05\\WebContent\\UPLOADED_FILE\\passicon.jpg");
//		image3. scaleAbsolute(24,25);
		
			Chunk chunk = new Chunk("THEMIS AUTHORITY");
			Font font1 = new Font(Font.TIMES_ROMAN );
			font1.setStyle(Font.BOLD);
			chunk.setFont(font1);
			Paragraph p1 = new Paragraph(chunk);
			p1.setAlignment(Element.ALIGN_CENTER);
		

		 
			Calendar c=new GregorianCalendar();
			 date=c.getTime().toString();

			Chunk chunk1 = new Chunk("BILL FOR YOUR CLOUD SERVICE");
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
			Chunk da=new Chunk("BILL DATE :" );
			Font font2 = new Font(Font.TIMES_ROMAN);
			//font2.setStyle(Font.BOLD);
			font2.setColor(139,69,19);
			a.setFont(font2);
			a1.setFont(font2);
			a2.setFont(font2);
			a3.setFont(font2);
			da.setFont(font2);

			Paragraph p2 = new Paragraph();
			p2.add(a);
			p2.add(uname.substring(1));
			p2.add( Chunk.NEWLINE );
			p2.add( Chunk.NEWLINE );
			p2.add(a1);
			p2.add(mail.substring(1));
			p2.add( Chunk.NEWLINE );
			p2.add( Chunk.NEWLINE );
			p2.add(a2);
			p2.add(phone.substring(1));
			p2.setAlignment(Element.ALIGN_LEFT);
			
			
			
			Paragraph p3 = new Paragraph();
			p3.add(da);
			p3.add( Chunk.NEWLINE );
			p3.add(date);
			p3.add( Chunk.NEWLINE );
			p3.add(a3);
			p3.add( Chunk.NEWLINE );
			p3.add(address.substring(1));
			p3.setAlignment(Element.ALIGN_RIGHT);

			
					
			Chunk chunkup = new Chunk("AGREEMENT");
			Chunk a4 = new Chunk(" Software Name :");
			Chunk a5 = new Chunk(" Period :");
			Chunk a6 = new Chunk(" Cost in INR :");
			Chunk a7 = new Chunk(" Agreement Date :");
			
			Font font3 = new Font(Font.TIMES_ROMAN);
			font3.setColor(255,69,0);
			chunkup.setFont(font);
			a4.setFont(font3);
			a5.setFont(font3);
			a6.setFont(font3);
			a7.setFont(font3);
			
			Paragraph p4 = new Paragraph();
			p4.add(chunkup);
			p4.add( Chunk.NEWLINE );
			p4.add( Chunk.NEWLINE );
			p4.add(a4);
			p4.add(sname.substring(1));
			p4.add( Chunk.NEWLINE );
			p4.add(a5);
			p4.add(val);
			p4.add( Chunk.NEWLINE );
			p4.add(a6);
			p4.add(cost);
			p4.add( Chunk.NEWLINE );
			p4.add(a7);
			p4.add(sla_date);
			p4.setAlignment(Element.ALIGN_CENTER);
			
			
			String[] sld=sla_date.split(" ");
			String[] bld=date.split(" ");
			System.out.println("day:"+sld[1]+"month:"+sld[0]+"year:"+sld[4]);
			System.out.println(date+"`````````"+"day:"+bld[2]+"month:"+bld[1]+"year:"+bld[5]);
			List l= new ArrayList();
			l.add(sld[4]);//statrt year
			l.add(bld[5]);//end year
			l.add(sld[0]);//start month
			l.add(bld[1]);//end month
			l.add(sld[1]);//start date
			l.add(bld[2]);//end date
			int period= Integer.parseInt(val);
			int amt= Integer.parseInt(cost);
			Findingdate ff= new Findingdate();
			List de=ff.call(l, period, amt);
			
			Chunk chunkup1 = new Chunk("BILL");
			Chunk a4a = new Chunk(" Software Name :");
			Chunk a5a = new Chunk(" Used Period :");
			Chunk a6a = new Chunk(" Usage Cost in INR :");
			Chunk a7a = new Chunk(" Bill Generated by THEMIS AYTHORITY ");
			chunkup1.setFont(font);
			a4a.setFont(font3);
			a5a.setFont(font3);
			a6a.setFont(font3);
			a7a.setFont(font3);
		
			Paragraph p5 = new Paragraph();
			p5.add(chunkup1);
			p5.add( Chunk.NEWLINE );
			p5.add( Chunk.NEWLINE );
			p5.add(a4a);
			p5.add(sname.substring(1));
			p5.add( Chunk.NEWLINE );
			p5.add(a5a);
			p5.add(de.get(0).toString());
			p5.add( Chunk.NEWLINE );
			p5.add(a6a);
			p5.add(de.get(1).toString());
			p5.setAlignment(Element.ALIGN_CENTER);
			
			Paragraph p6 = new Paragraph();
			p6.add(image1);
			p6.add(a7a);
			
			p6.setAlignment(Element.ALIGN_LEFT);
			
	   	PdfPTable table=new PdfPTable(2);
		table.addCell(p2);
		table.addCell(p3);
		/*
		PdfPTable table1=new PdfPTable(1);
		table1.addCell(p4);*/
		
		
		
		
		document.add(p1);
		document.add( Chunk.NEWLINE );
		
		      
		document.add(p);
		document.add( Chunk.NEWLINE );
       
		document.add(table);
		document.add( Chunk.NEWLINE );
		document.add(image);
		document.add( Chunk.NEWLINE );
		document.add(p4);
		document.add( Chunk.NEWLINE );
		document.add( Chunk.NEWLINE );
		document.add(p5);
		document.add( Chunk.NEWLINE );
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
		
		DBClass2 db= new DBClass2();
		java.sql.Connection con=db.connect();
		Statement st= con.createStatement();
		int i=st.executeUpdate("insert into forbank (name,software,amount) values('"+uname.substring(1)+"','"+sname.substring(1)+"','"+Integer.parseInt(de.get(1).toString())+"')");
    	 }
		if(bill.size()==11)
		{
			
			System.out.println("bill"+bill.size());
			String uname=(String) bill.get(0);
	    	String mail=(String) bill.get(1);
	    	String phone=(String) bill.get(2);
	    	String address=(String) bill.get(3);
	    	String sname=(String) bill.get(4);
	    	String val=(String) bill.get(5);
	    	String cost=(String) bill.get(6);
	    	String sla_date=(String) bill.get(7);
	    	String cond=bill.get(10).toString();
	    	
	    	
	    	System.out.println("path FF GG HH:"+path+"..........."+cond);
	    	
	    	Document document=new Document(PageSize.A4);
		   PdfWriter.getInstance(document,new FileOutputStream(path+"\\"+uname.substring(1)+"-"+sname.substring(1)+" bill.pdf"));
		   System.out.println("path FF GG HH:"+path);
			
			document.open(); 
			

		   Image image = Image.getInstance ("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05-Themis\\WebContent\\images\\New rupee symbol.png");
			image. scaleAbsolute(75,75);
			image.setRotationDegrees(45f);
			Image image1 = Image.getInstance ("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05-Themis\\WebContent\\images\\4.jpg");
			image1. scaleAbsolute(48,48);
			/*Image image2 = Image.getInstance ("E:\\ITJCC05\\WebContent\\UPLOADED_FILE\\"+image1);
			image2. scaleAbsolute(75,75);*/
//			Image image3 = Image.getInstance ("E:\\ITJCC05\\WebContent\\UPLOADED_FILE\\passicon.jpg");
//			image3. scaleAbsolute(24,25);
			
				Chunk chunk = new Chunk("THEMIS AUTHORITY");
				Font font1 = new Font(Font.TIMES_ROMAN );
				font1.setStyle(Font.BOLD);
				chunk.setFont(font1);
				Paragraph p1 = new Paragraph(chunk);
				p1.setAlignment(Element.ALIGN_CENTER);
			

			 
				Calendar c=new GregorianCalendar();
				 date=c.getTime().toString();

				Chunk chunk1 = new Chunk("BILL FOR YOUR CLOUD SERVICE");
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
				Chunk da=new Chunk("BILL DATE :" );
				Font font2 = new Font(Font.TIMES_ROMAN);
				//font2.setStyle(Font.BOLD);
				font2.setColor(139,69,19);
				a.setFont(font2);
				a1.setFont(font2);
				a2.setFont(font2);
				a3.setFont(font2);
				da.setFont(font2);

				Paragraph p2 = new Paragraph();
				p2.add(a);
				p2.add(uname.substring(1));
				p2.add( Chunk.NEWLINE );
				p2.add( Chunk.NEWLINE );
				p2.add(a1);
				p2.add(mail.substring(1));
				p2.add( Chunk.NEWLINE );
				p2.add( Chunk.NEWLINE );
				p2.add(a2);
				p2.add(phone.substring(1));
				p2.setAlignment(Element.ALIGN_LEFT);
				
				
				
				Paragraph p3 = new Paragraph();
				p3.add(da);
				p3.add( Chunk.NEWLINE );
				p3.add(date);
				p3.add( Chunk.NEWLINE );
				p3.add(a3);
				p3.add( Chunk.NEWLINE );
				p3.add(address.substring(1));
				p3.setAlignment(Element.ALIGN_RIGHT);

				
						
				Chunk chunkup = new Chunk("AGREEMENT");
				Chunk a4 = new Chunk(" Software Name :");
				Chunk a5 = new Chunk(" Period :");
				Chunk a6 = new Chunk(" Cost in INR :");
				Chunk a7 = new Chunk(" Agreement Date :");
				
				Font font3 = new Font(Font.TIMES_ROMAN);
				font3.setColor(255,69,0);
				chunkup.setFont(font);
				a4.setFont(font3);
				a5.setFont(font3);
				a6.setFont(font3);
				a7.setFont(font3);
				
				Paragraph p4 = new Paragraph();
				p4.add(chunkup);
				p4.add( Chunk.NEWLINE );
				p4.add( Chunk.NEWLINE );
				p4.add(a4);
				p4.add(sname.substring(1));
				p4.add( Chunk.NEWLINE );
				p4.add(a5);
				p4.add(val);
				p4.add( Chunk.NEWLINE );
				p4.add(a6);
				p4.add(cost);
				p4.add( Chunk.NEWLINE );
				p4.add(a7);
				p4.add(sla_date);
				p4.setAlignment(Element.ALIGN_CENTER);
				
				
				String[] sld=sla_date.split(" ");
				String[] bld=date.split(" ");
				System.out.println("day:"+sld[1]+"month:"+sld[0]+"year:"+sld[4]);
				System.out.println(date+"`````````"+"day:"+bld[2]+"month:"+bld[1]+"year:"+bld[5]);
				List l= new ArrayList();
				l.add(sld[4]);//statrt year
				l.add(bld[5]);//end year
				l.add(sld[0]);//start month
				l.add(bld[1]);//end month
				l.add(sld[1]);//start date
				l.add(bld[2]);//end date
				int period= Integer.parseInt(val);
				int amt= Integer.parseInt(cost);
				Findingdate ff= new Findingdate();
				List de=ff.call(l, period, amt);
				
				if(cond.equals("user"))
				{
					System.out.println("csp hit");
				Chunk chunkup1 = new Chunk("BILL");
				Chunk a4a = new Chunk(" Software Name :");
				Chunk a5a = new Chunk(" Used Period :");
				Chunk a6a = new Chunk(" Usage Cost in INR :");
				Chunk addi= new Chunk("PAYMENT CANCELLED DUE TO SLA FORGERY FOUND AT CSP");
				Chunk a7a = new Chunk(" Bill Generated by THEMIS AYTHORITY ");
				chunkup1.setFont(font);
				a4a.setFont(font3);
				a5a.setFont(font3);
				a6a.setFont(font3);
				a7a.setFont(font3);
				Font fonts = new Font(Font.TIMES_ROMAN);
				fonts.setStyle(Font.BOLD);
				fonts.setColor(139,0,0);
				addi.setFont(fonts);
			
				Paragraph p5 = new Paragraph();
				p5.add(chunkup1);
				p5.add( Chunk.NEWLINE );
				p5.add( Chunk.NEWLINE );
				p5.add(a4a);
				p5.add(sname.substring(1));
				p5.add( Chunk.NEWLINE );
				p5.add(a5a);
				p5.add(de.get(0).toString());
				p5.add( Chunk.NEWLINE );
				p5.add(a6a);
				p5.add(de.get(1).toString());
				p5.add( Chunk.NEWLINE );
				p5.add( Chunk.NEWLINE );
				p5.add( addi );
				p5.setAlignment(Element.ALIGN_CENTER);
				
				Paragraph p6 = new Paragraph();
				p6.add(image1);
				p6.add(a7a);
				
				p6.setAlignment(Element.ALIGN_LEFT);
				
		   	PdfPTable table=new PdfPTable(2);
			table.addCell(p2);
			table.addCell(p3);
			
			PdfPTable table1=new PdfPTable(1);
			table1.addCell(p4);
			
			
			
			
			document.add(p1);
			document.add( Chunk.NEWLINE );
			
			      
			document.add(p);
			document.add( Chunk.NEWLINE );
	       
			document.add(table);
			document.add( Chunk.NEWLINE );
			document.add(image);
			document.add( Chunk.NEWLINE );
			document.add(p4);
			document.add( Chunk.NEWLINE );
			document.add( Chunk.NEWLINE );
			document.add(p5);
			document.add( Chunk.NEWLINE );
			document.add( Chunk.NEWLINE );
			document.add( Chunk.NEWLINE );
			
			document.add( Chunk.NEWLINE );
			document.add(p6);
			
			document.close();
			
			DBClass2 db= new DBClass2();
			java.sql.Connection con=db.connect();
			Statement st= con.createStatement();
			int i=st.executeUpdate("insert into forbank (name,software,amount) values('"+uname.substring(1)+"','"+sname.substring(1)+"','"+0+"')");
				}
//			if(cond.equals("user"))
//				{
//				System.out.println("user hit");
//				int totalamt= Integer.parseInt(de.get(1).toString())+1000;
//				Chunk chunkup1 = new Chunk("BILL");
//				Chunk a4a = new Chunk(" Software Name :");
//				Chunk a5a = new Chunk(" Used Period :");
//				Chunk a6a = new Chunk(" Usage Cost in INR :");
//				Chunk addi= new Chunk("Penalty : 1000 INR");
//				Chunk tot=new Chunk(" Total Amount in INR :");
//				Chunk a7a = new Chunk(" Bill Generated by THEMIS AYTHORITY ");
//				chunkup1.setFont(font);
//				a4a.setFont(font3);
//				a5a.setFont(font3);
//				a6a.setFont(font3);
//				a7a.setFont(font3);
//				Font fonts = new Font(Font.TIMES_ROMAN);
//				fonts.setStyle(Font.BOLD);
//				fonts.setColor(139,0,0);
//				addi.setFont(font);
//				tot.setFont(font3);
//			
//				Paragraph p5 = new Paragraph();
//				p5.add(chunkup1);
//				p5.add( Chunk.NEWLINE );
//				p5.add( Chunk.NEWLINE );
//				p5.add(a4a);
//				p5.add(sname.substring(1));
//				p5.add( Chunk.NEWLINE );
//				p5.add(a5a);
//				p5.add(de.get(0).toString());
//				p5.add( Chunk.NEWLINE );
//				p5.add(a6a);
//				p5.add(de.get(1).toString());
//				p5.add( Chunk.NEWLINE );
//				p5.add( Chunk.NEWLINE );
//				p5.add(addi);
//				p5.add( Chunk.NEWLINE );
//				p5.add( Chunk.NEWLINE );
//				p5.add(tot);
//				p5.add(String.valueOf(totalamt));
//				p5.setAlignment(Element.ALIGN_CENTER);
//				
//				Paragraph p6 = new Paragraph();
//				p6.add(image1);
//				p6.add(a7a);
//				
//				p6.setAlignment(Element.ALIGN_LEFT);
//				
//		   	PdfPTable table=new PdfPTable(2);
//			table.addCell(p2);
//			table.addCell(p3);
//			
//			PdfPTable table1=new PdfPTable(1);
//			table1.addCell(p4);
//			
//			
//			
//			
//			document.add(p1);
//			document.add( Chunk.NEWLINE );
//			
//			      
//			document.add(p);
//			document.add( Chunk.NEWLINE );
//	       
//			document.add(table);
//			document.add( Chunk.NEWLINE );
//			document.add(image);
//			document.add( Chunk.NEWLINE );
//			document.add(p4);
//			document.add( Chunk.NEWLINE );
//			document.add( Chunk.NEWLINE );
//			document.add(p5);
//			document.add( Chunk.NEWLINE );
//			document.add( Chunk.NEWLINE );
//			document.add( Chunk.NEWLINE );
//			
//			document.add( Chunk.NEWLINE );
//			document.add(p6);
//			
//			document.close();
//			
//			
//			DBClass2 db= new DBClass2();
//			java.sql.Connection con=db.connect();
//			Statement st= con.createStatement();
//			int i=st.executeUpdate("insert into forbank (name,software,amount) values('"+uname.substring(1)+"','"+sname.substring(1)+"','"+totalamt+"')");
//				}
			
		}
		 return date;
		 
      }
     
}
