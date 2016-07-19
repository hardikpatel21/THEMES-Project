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

public class Ex2
{

	String test=null;
	String test2=null;
	String name=null,mail=null,phone=null,add=null,sw=null,date=null, day=null,cost=null;
	List l= new ArrayList();
	List l1= new ArrayList();
	
	public void pdf2(String path)
	{
		
	
	try 
	{
        Document document = new Document();
        document.open();
        PdfReader reader = new PdfReader("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05-Themis\\WebContent\\BILL\\"+path);
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
		int i=test2.indexOf("NAME");
		int j=test2.indexOf("kasi");
		String ary[]=test2.split(" ");
		System.out.println( test2+"~~~~~~~~~~~~~~~~~~~~~~~~ "+i+ary[48]+"~~~~");
		
		int rate=Integer.parseInt(ary[48]);
		
	} catch (Exception e)
{
	e.printStackTrace();
}

	}
	public static void main(String[] args)
	{
		Ex2 e= new Ex2();
		System.out.println("hai");
		e.pdf2("arun-EDITOR bill.pdf");
		
		
	}

}

