package Workers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author spiro16
 */
public class Worker extends javax.swing.JFrame implements Runnable {
    int cport;
    public Worker() {        
            initComponents();
        }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        list1 = new java.awt.List();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        warea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel1.setText("WORKER ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(148, 21, 87, 14);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/signOut.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(360, 270, 49, 50);

        jButton1.setText("FINISHED");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(190, 280, 110, 30);

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(260, 40, 91, 14);
        jPanel1.add(list1);
        list1.setBounds(30, 90, 50, 80);

        jLabel4.setText("FILE NAME");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 70, 90, 14);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(100, 90, 160, 90);

        jLabel5.setText("WORK DISCRIPTION");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(100, 70, 140, 14);

        warea.setColumns(20);
        warea.setRows(5);
        jScrollPane2.setViewportView(warea);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 210, 166, 96);

        jLabel6.setText("WORKING AREA");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 190, 100, 14);

        jButton2.setText("browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(190, 250, 110, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
  
      this.dispose();
      try
      {
        List li=new ArrayList();
        so=new Socket(servip,910);
        ObjectOutputStream oos=new ObjectOutputStream(so.getOutputStream());
        li.add("signout");
        li.add(workername);
        li.add("");
        li.add("");
        oos.writeObject(li);
         
       }
      catch(Exception w)
      {
          w.printStackTrace();
      }

      new workerLogin().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          this.dispose();
        
      try
      {
        

          List li=new ArrayList();
        so=new Socket(servip,910);
        ObjectOutputStream oos=new ObjectOutputStream(so.getOutputStream());
        li.add("signout");
        li.add(workername);
        li.add("");
        li.add("");
        oos.writeObject(li);
      
       }
      catch(Exception w)
      {
          w.printStackTrace();
      }

      new workerLogin().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String document=warea.getText();
        String file=list1.getSelectedItem();
        boolean b = false;
       try
       {
       b=file.equals("null");
       b=true;
        List li=new ArrayList();
        li.add("finish");
        li.add(" "+document);
        li.add(file);
        li.add(workername);
        try
        {
         so=new Socket(servip,910);
        ObjectOutputStream oos=new ObjectOutputStream(so.getOutputStream());
        oos.writeObject(li);
        jTextArea1.setText("");
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        warea.setText("");
        list1.remove(file);
        }finally
       {
            if(b==false)
            {
                 System.out.println("b is# "+b);
                 JOptionPane.showMessageDialog(rootPane, "please select");
            }

        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       JFileChooser jf=new JFileChooser();
       jf.showOpenDialog(jf);
       File file=jf.getSelectedFile();
       try
       {
        FileInputStream fis=new FileInputStream(file);
        byte b[]=new byte[fis.available()];
        fis.read(b);
        String s=new String(b);
        warea.append(s);
        }catch(Exception e)
       {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

//                Worker wor=new Worker();
//                      wor.clos();
//                      System.out.println("hellooooo");
//                       wor.contains(wor);
//                       System.out.println("haiiioiiiii");
//                      wor.setVisible(true);
                     

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.List list1;
    private javax.swing.JTextArea warea;
    // End of variables declaration//GEN-END:variables
String workername;
    void name(String uname,String port,String servip) {
        port1=port;
        this.servip=servip;
  
        workername=uname;
        jLabel1.setText("Worker : "+uname);
        jLabel3.setText("Port : "+port);
        contains(new Worker() );


    }

Socket so;
ServerSocket ss;
String port1;
Thread t;
String servip;
   

    public void run() {

        try
        {
            while(true)
            {
            so=ss.accept();
            ObjectInputStream ois=new ObjectInputStream(so.getInputStream());
            List ll=new ArrayList();
          ll=(List)ois.readObject();
          String frsevr=ll.get(0).toString().trim();
          String descrption=ll.get(1).toString().trim();
           
         list1.add(frsevr);
         jTextArea1.append(descrption+"\n");

            }
        }catch(IOException ioex)
        {
            ioex.printStackTrace();
        }
        catch(ClassNotFoundException cs)
        {
            cs.printStackTrace();
        }
    }

    private void contains(Worker wor) {
        
   

       int cport=Integer.parseInt(port1);
       try
       {
          ss=new ServerSocket(cport);
         t=new Thread(this);
          t.start();
       }
       catch(IOException ioe)
       {
           ioe.printStackTrace();
     }  

 }
}
