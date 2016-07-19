package CNA;

import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PRIndirectReference;
import com.lowagie.text.pdf.PRStream;
import com.lowagie.text.pdf.PRTokeniser;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfReader;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Example1
{

	String test=null;
	String test2=null;
	String name=null,mail=null,phone=null,add=null,sw=null,date=null, day=null,cost=null;
	List l= new ArrayList();
	List l1= new ArrayList();
	public void pdf(String path)
	
	
	{
	try 
	{
        Document document = new Document();
        document.open();
        PdfReader reader = new PdfReader("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05-Themis\\WebContent\\SLA\\"+path);
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
	}
	public void pdf2(String path)
	{
		
	
	try 
	{
        Document document = new Document();
        document.open();
        PdfReader reader = new PdfReader("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05-Themis\\WebContent\\USLA\\"+path);
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
        test2 = buffer.toString();
        System.out.println(test);
		int i=test.indexOf("NAME");
		int j=test.indexOf("kasi");
		String ary[]=test.split(" ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~ "+i+"   j  "+j+"   "+ary[33]+"~~~~"+ary[36]+"~~~~"+ary[38]+"~~~~"+ary[40]+"~~~~"+ary[43]+"~~~~"+ary[45]+"~~~~"+ary[49]+"~~~~"+ary[26]+"~~~~"+ary[27]+"~~~~"+ary[28]+"~~~~"+ary[29]+"~~~~"+ary[30]+"~~~~"+ary[31]+"~~~~");
			
		name=ary[33];
		mail=ary[36];
		phone=ary[38];
		add=ary[40];
		sw=ary[43];
		day=ary[45].substring(1);
		cost=ary[49].substring(1);
		date=ary[26]+" "+ary[27]+" "+ary[28]+" "+ary[29]+" "+ary[30]+" "+ary[31];
		
		l.add(name);
		l.add(mail);
		l.add(phone);
		l.add(add);
		l.add(sw);
		l.add(day);
		l.add(cost);
		l.add(date);
	} catch (Exception e)
{
	e.printStackTrace();
}

	}
	public static List compare(String path)
	{
		Example1 e= new Example1();
		e.pdf(path);
		e.pdf2(path);
		if(e.test.equals(e.test2))
		{
			System.out.println("MATCH");
			System.out.println(e.l);
			return e.l;
		}
			else
		{
				System.out.println("UN-MATCH");
				e.l.add(e.test);
				e.l.add(e.test2);
				System.out.println(e.l);
				return e.l;
		}
		
	}

}

