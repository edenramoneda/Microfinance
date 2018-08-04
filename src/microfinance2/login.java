/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microfinance2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

/**
 *
 * @author john
 */
public class login extends javax.swing.JFrame {


    public login() {
        initComponents();
    }
    String url,user,pass;
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 29, 29));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setBackground(new java.awt.Color(57, 18, 216));
        login.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setText("LOGIN");
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.setOpaque(true);
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginMousePressed(evt);
            }
        });
        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginKeyPressed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 160, 30));

        exit.setBackground(new java.awt.Color(57, 18, 216));
        exit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("                 EXIT");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setOpaque(true);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitMousePressed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 160, 30));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/microfinance2/Male User_40px.png"))); // NOI18N
        jPanel1.add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 80, 70));

        username.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 161, 30));

        password.setEchoChar('\u25cf');
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 161, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 260, 410));

        setSize(new java.awt.Dimension(254, 406));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMousePressed
       
        
        
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        url = "jdbc:sqlserver://EDENRAMONEDA:1433;databaseName=Core2";
        user = "sa";
        pass = "edenrams";
        Connection con = DriverManager.getConnection(url,user,pass);
        String sql = "Select *from adaccounts where username = ? and password = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,username.getText());
        pst.setString(2,password.getText());
        ResultSet rs = pst.executeQuery();
        MainFrame m = new MainFrame();
        m.setVisible(true);
        if(rs.next()){
            JOptionPane.showMessageDialog(null,"Welcome!");
            this.hide();
        }else{
           JOptionPane.showMessageDialog(null,"Invalid Username and Password");
           username.setText(null);
           password.setText(null);
        }
        
        
    }catch(Exception e){
    
        
        
    }
    }//GEN-LAST:event_loginMousePressed

    private void exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMousePressed

    private void usernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyPressed

    }//GEN-LAST:event_usernameKeyPressed

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
    
    }//GEN-LAST:event_usernameKeyTyped

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
    System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        
    }//GEN-LAST:event_loginMouseClicked

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed

    }//GEN-LAST:event_passwordKeyPressed

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped

    }//GEN-LAST:event_passwordKeyTyped

    private void loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginKeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try{
                    Thread.sleep(4000);
                }
                catch(Exception e){
                    
                }
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JLabel icon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel login;
    private static javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
