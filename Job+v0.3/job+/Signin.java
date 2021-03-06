
package job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Signin extends javax.swing.JFrame {

   Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    public Signin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        backb = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        signin = new javax.swing.JLabel();
        homep = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setBackground(new java.awt.Color(22, 134, 236));
        jComboBox1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HR Team Member", "Candidate", "Employee", "Team Manager" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 300, 50));

        backb.setText(" ");
        backb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbMouseClicked(evt);
            }
        });
        getContentPane().add(backb, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 110, 30));

        txtuser.setBackground(new java.awt.Color(252, 250, 251));
        txtuser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtuser.setBorder(null);
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 270, 20));

        txtpass.setBackground(new java.awt.Color(252, 250, 251));
        txtpass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpass.setBorder(null);
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 270, 20));

        signin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signinMouseClicked(evt);
            }
        });
        getContentPane().add(signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 230, 50));

        homep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/job/Signin.jpg"))); // NOI18N
        homep.setText(" ");
        getContentPane().add(homep, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbMouseClicked
            Home a = new Home();
            a.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_backbMouseClicked

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void signinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinMouseClicked
         String username = txtuser.getText();
        String password = txtpass.getText();
        String type = (String) jComboBox1.getSelectedItem();
        
        
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost/jobplusdb","root","");
         
        
         if(jComboBox1.getSelectedItem().equals("HR Team Member"))
         {
             pst=con.prepareStatement("select * from user where username=? and password=? and type=? ");
             pst.setString(1, username);
             pst.setString(2, password);
             pst.setString(3, type);
             rs = pst.executeQuery();
             
             if (rs.next())
          {
             JOptionPane.showMessageDialog(this,"Successful Login as a HR Team Member!");
             HRTeamMember a = new HRTeamMember();
             a.setVisible(true);
             this.dispose();
             
              
          }
          else
          {
             JOptionPane.showMessageDialog(this,"Username,password or type of user are incorrect","Error",JOptionPane.ERROR_MESSAGE); 
             txtuser.setText("");
             txtpass.setText("");
          }
             
         }
         else if (jComboBox1.getSelectedItem().equals("Team Manager"))
         {
             
              pst=con.prepareStatement("select * from user where username=? and password=? and type=? ");
             pst.setString(1, username);
             pst.setString(2, password);
             pst.setString(3, type);
             rs = pst.executeQuery();
             
             if (rs.next())
          {
             JOptionPane.showMessageDialog(this,"Successful Login as a Team Manager!");
             TeamManager a = new TeamManager();
             a.setVisible(true);
             this.dispose();
             
              
          }
          else
          {
             JOptionPane.showMessageDialog(this,"Username,password or type of user are incorrect","Error",JOptionPane.ERROR_MESSAGE); 
             txtuser.setText("");
             txtpass.setText("");
          } 
             
             
             
         }
         else
         {
             
         }
        }catch (ClassNotFoundException ex) {
         Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
         Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signinMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backb;
    private javax.swing.JLabel homep;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel signin;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
