/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package itjnw08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;

/**
 *
 * @author Spiro9
 */
public class UploadToServer extends javax.swing.JFrame implements Runnable,ActionListener  {

    /**
     * @param args the command line arguments
     */
    public UploadToServer()
    {
        b1=new JButton();
        b1.setText("Do want to cancel the execution?");

        b1.addActionListener(this);
            add(b1);
       initComponents();
    }

    public void actionPerformed(ActionEvent e) {
    if ("Do want to cancel the execution?".equals(e.getActionCommand())) {
         System.out.println("cancelled");
         System.exit(0);
       

        }

    }


    public static void main(String[] args) {
        // TODO code application logic here
        UploadToServer up=new UploadToServer();
        up.call(up);

    }
void call(UploadToServer up)
    {
    t=new Thread(up);
    t.start();
    }

    public void run() {
 
      for(;;) try{
            ss=new ServerSocket(456);
            s=ss.accept();
            portno=s.getPort();
            
            System.out.println("port number="+portno);
        ip=s.getRemoteSocketAddress().toString();
          System.out.println("ip="+ip);
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
          al=(ArrayList)  ois.readObject();

           foldername=(String) al.get(0);
          filename=(String) al.get(1);
          b=(byte[]) al.get(2);

            System.out.println("folder name is:"+foldername);

            pname="D:\\SERVER\\"+foldername+"\\"+filename;

          f=new File(pname);
          FileOutputStream fos=new FileOutputStream(f);
          fos.write(b);

       
             ous=new ObjectOutputStream(s.getOutputStream());
     ous.writeObject("File sucessfully stored in "+foldername);


     FileWriter f=new FileWriter("D:\\path.txt",true);
    BufferedWriter bw=new BufferedWriter(f);
    bw.write(pname+"  "+ip);
    bw.newLine();
    

            bw.close();
            fos.close();
            s.close();
            ss.close();

        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }
    String foldername,filename,pname,ip;
    ObjectOutputStream ous;
    ObjectInputStream ois;
    FileOutputStream fos;
    ServerSocket ss;
    ArrayList al;
    JButton b1;
    Socket s;
    int portno;
    Thread t;
    byte b[];
    File f;

    private void initComponents() {
        
        setTitle("Server is in running mode");
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

}
