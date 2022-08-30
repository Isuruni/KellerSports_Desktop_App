
package Interface;

import Codes.DBconnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet results=null;
    boolean isLogged;
    public Login() {
        initComponents();
        conn = DBconnector.connect();
    }
    public void login(){
        String userName, password;
        
        userName = unamebox1.getText();
        password= password1.getText();
        
        String sql = null;
        
        if(userName.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(this, "All the fields are mandatory");

        }
        else{
        try{
            
           sql="Select username, password from admin  where username ='"+userName+"' AND password='"+password+"' ";
            pst=conn.prepareStatement(sql);
            results=pst.executeQuery();
            while(results.next()){
                isLogged=true;
            }
           
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(this, "Error Occurred");
            isLogged=false;
            
        }
       
    }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        unamebox1 = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        loginb2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        signupb2 = new javax.swing.JButton();
        homeb1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LogIn");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 22, 129, 36));

        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User name :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 102, -1, -1));

        jLabel3.setFont(new java.awt.Font("Bodoni MT Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 162, -1, -1));

        unamebox1.setToolTipText("Enter your user name");
        unamebox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unamebox1ActionPerformed(evt);
            }
        });
        jPanel1.add(unamebox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 103, 240, -1));

        password1.setToolTipText("Enter your password.");
        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });
        jPanel1.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 163, 240, -1));

        loginb2.setBackground(new java.awt.Color(51, 153, 255));
        loginb2.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        loginb2.setForeground(new java.awt.Color(0, 0, 102));
        loginb2.setText("LogIn");
        loginb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginb2ActionPerformed(evt);
            }
        });
        jPanel1.add(loginb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Back to home");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        signupb2.setBackground(new java.awt.Color(51, 153, 255));
        signupb2.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        signupb2.setForeground(new java.awt.Color(0, 0, 102));
        signupb2.setText("Sign Up");
        signupb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupb2ActionPerformed(evt);
            }
        });
        jPanel1.add(signupb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        homeb1.setBackground(new java.awt.Color(51, 153, 255));
        homeb1.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        homeb1.setForeground(new java.awt.Color(0, 0, 102));
        homeb1.setText("Home");
        homeb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeb1ActionPerformed(evt);
            }
        });
        jPanel1.add(homeb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Don't have an account?");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pramodhi\\Documents\\NetBeansProjects\\KellerSports\\pictures\\Keller_Sports__2_-removebg-preview.png")); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, -30, 680, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(809, 423));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginb2ActionPerformed
        
        login();
        if(isLogged==true){
        
          AdminHome homePage = new AdminHome();
          homePage.setVisible(true);
          this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Please sign up befor login.");
        }
        
            }//GEN-LAST:event_loginb2ActionPerformed

    private void signupb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupb2ActionPerformed
        Signup signupPage = new Signup();
        signupPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signupb2ActionPerformed

    private void homeb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeb1ActionPerformed
        Home homePage = new Home();
        homePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeb1ActionPerformed

    private void unamebox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unamebox1ActionPerformed

    }//GEN-LAST:event_unamebox1ActionPerformed

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeb1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginb2;
    private javax.swing.JPasswordField password1;
    private javax.swing.JButton signupb2;
    private javax.swing.JTextField unamebox1;
    // End of variables declaration//GEN-END:variables
}
