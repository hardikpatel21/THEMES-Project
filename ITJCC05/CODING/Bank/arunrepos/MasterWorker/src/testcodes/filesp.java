/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testcodes;

import java.io.FileInputStream;

/**
 *
 * @author spiro16
 */
public class filesp {
    public static void main(String[] args) {
        try
        {
            FileInputStream fis=new FileInputStream("D:\\OverlDemo.java");
            System.out.println("avilablty "+fis.available());
            byte fl[]=new byte[fis.available()];

            int j=fis.available()/2;
            byte[] temp=new byte[j];
            for(int i=0;i<j;i++)
            {
                //System.out.println("i is "+i);
                temp[i]=fl[i];

            }
            byte[] k=new byte[fis.available()];
            fis.read(k);
             for(int i=212;i<424;i++)
             {
                 k[i]=fl[i];
             }
            String abc=new String(temp);
            String abx=new String(k);

           // System.out.println("j is "+abc);
            System.out.println("abx is "+abx);
           byte []a=new byte[j];
           fis.read(a);
           String s=new String(a);
            //System.out.println("s is "+s);





        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
