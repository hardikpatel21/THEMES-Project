package Monitor;

import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PRIndirectReference;
import com.lowagie.text.pdf.PRStream;
import com.lowagie.text.pdf.PRTokeniser;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfReader;

public class Compare_monitor 
{
	String orgl=null;
public void pdf(String path)
	{
	
	try 
	{
		Document document = new Document();
        document.open();
        PdfReader reader = new PdfReader("D:\\projectfinal\\ITJCC05\\CODING\\Coding\\ITJCC05-Themis\\WebContent\\Monitor\\"+path);
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
        orgl = buffer.toString();
        System.out.println("monitor copy"+orgl);
} catch (Exception e)
{
	e.printStackTrace();
}
	}

public String compare_with_monitor(List copy,String path)
{
	System.out.println("copy is"+copy);
	String CSP_copy=copy.get(8).toString();
	String user_copy=copy.get(9).toString();
	System.out.println("ddddddddd");
	String cond=null;
	pdf(path);
	if(!(CSP_copy.equals(orgl)))
	{
		 cond="CSP";
		
	}
	if(!(user_copy.equals(orgl)))
	{
		 cond="user";
		
	}
	System.out.println("condition is "+cond);
	return cond;
}



}
