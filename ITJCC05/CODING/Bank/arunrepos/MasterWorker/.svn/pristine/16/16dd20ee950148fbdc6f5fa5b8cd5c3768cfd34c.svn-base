package Master;
import Database.Dbconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class ServerLogin extends javax.swing.JFrame {


    public ServerLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        suname = new javax.swing.JTextField();
        spassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 14));
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("SERVER-LOGIN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(130, 10, 120, 31);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("User Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 70, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 120, 60, 20);
        jPanel1.add(suname);
        suname.setBounds(110, 80, 110, 20);
        jPanel1.add(spassword);
        spassword.setBounds(110, 120, 110, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login_button.gif"))); // NOI18N
        jLabel4.setToolTipText("LOGIN");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(110, 170, 50, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_cancel.png"))); // NOI18N
        jLabel5.setToolTipText("EXIT");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(200, 180, 40, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        try {
                    String uname = suname.getText();
                    char[] pass = spassword.getPassword();
                    String pswrd=new String(pass);
                    Dbconnection c1 = Dbconnection.getconnect();
                    Connection c = c1.validation();
                   
                    Statement stmt=c.createStatement();
                    int i = 0;
                    ResultSet rs=stmt.executeQuery("select * from serverlogin  where username='"+uname+"'and pass='"+pswrd+"'");
                    while(rs.next())
                    {
                       
                       i=1;
                    }
                     if(i==1)
                        {
                            JOptionPane.showMessageDialog(rootPane, "valid user");
                       this.dispose();

                            Server o=new Server();
                           o.main(null);
                           // o.setVisible(true);
                                
                        }
                            else
                        {
                            JOptionPane.showMessageDialog(rootPane, "invalid login");
                        }

             }
        catch (SQLException ex) 
        {
            ex.printStackTrace();

        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
   System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField spassword;
    private javax.swing.JTextField suname;
    // End of variables declaration//GEN-END:variables
}
