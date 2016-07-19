/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UploadFile.java
 *
 * Created on Aug 3, 2012, 12:04:17 PM
 */

package itjnw08;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Spiro9
 */
public class UploadFile extends javax.swing.JFrame {

    /** Creates new form UploadFile */
    public UploadFile() {
        initComponents();
        setSize(450,550);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("UPLOAD A NEW FILE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 20, 130, 14);

        jLabel2.setText("Previously  Uploaded Files");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 150, 14);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(254, 43, 70, 93);

        jLabel3.setText("Select a Network");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(46, 181, 130, 14);

        jRadioButton1.setText("Network 1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(185, 180, 120, 23);

        jRadioButton2.setText("Network 2");
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(300, 180, 110, 23);

        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(213, 250, 120, 23);

        jLabel4.setText("Choose a File");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 250, 100, 14);

        jButton2.setText("UPLOAD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 310, 290, 23);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(40, 364, 290, 20);

        jButton3.setText("CLOSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(113, 420, 110, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        
       
        ButtonGroup bg=new ButtonGroup();
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
       

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            fc=new JFileChooser();
        fc.showOpenDialog(null);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
try{


     if(jRadioButton1.isSelected())
{
    foldername="Network 1";
    
}

        if(jRadioButton2.isSelected())
        {
            foldername="Network 2";
            
        }

     f1=fc.getSelectedFile();
       fname=f1.getName();

     fis=new FileInputStream(f1);
     byte b[]=new byte[fis.available()];
     fis.read(b);
   
     al=new ArrayList();
     al.add(foldername);
     al.add(fname);
     al.add(b);

     System.out.println("selected file name is:"+fname);
     System.out.println("selected path name is:"+f1.getAbsolutePath());

     s=new Socket("localhost",456);

     ous=new ObjectOutputStream(s.getOutputStream());
     ous.writeObject(al);


      ois=new ObjectInputStream(s.getInputStream());
      s1=   (String) ois.readObject();

      JOptionPane jop=new JOptionPane();
      jop.showMessageDialog(rootPane,s1);
     

        }catch(Exception e)
{
           e.printStackTrace(); 
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new UploadFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
String fname,foldername;
ObjectOutputStream ous;
ObjectInputStream ois;
FileInputStream fis;
JFileChooser fc;
ArrayList al;
String s1;
Socket s;
File f1;
}
