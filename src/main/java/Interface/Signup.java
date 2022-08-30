
package Interface;

import Codes.DBconnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Signup extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet results=null;
    public Signup() {
        initComponents();
        conn = DBconnector.connect();
    }

    public void signup(){
        String userName, password,email,userId;
        
        userName = uname2.getText();
        userId=uname3.getText();
        email=email1.getText();
        password= password2.getText();
        
        
        String sql = null;
        
        if(userName.equals("")||email.equals("")||password.equals("")||userId.equals("")){
            JOptionPane.showMessageDialog(this,"All the fields are mandatory");

        }
        else{
        try{
            sql= "Select username, password from admin  where "
                   + "username ='"+userName+"' AND password='"+password+"' AND userid='"+userId+"'";
             pst=conn.prepareStatement(sql);
             results=pst.executeQuery();
             if(results.next()){
                 JOptionPane.showMessageDialog(this,"You already have an account. Please login.");
             }
             
             else{
             sql= "Select userid from admin  where userid='"+userId+"'";
             pst=conn.prepareStatement(sql);
             results=pst.executeQuery();
             if(results.next()){
                 JOptionPane.showMessageDialog(this,"UserId should be unique");
             }
             else{
             sql= "Select password from admin  where password='"+password+"'";
             pst=conn.prepareStatement(sql);
             results=pst.executeQuery();
             if(results.next()){
                 JOptionPane.showMessageDialog(this,"Use another Password");
             }
             
             else{
                  sql="Insert into admin Values ('"+userId+"', '"+userName+"','"+password+"',"
                     + "'"+email+"')";
             pst=conn.prepareStatement(sql);
             pst.execute();
             JOptionPane.showMessageDialog(this, "You have successfully sign up");
             Login loginPage = new Login();
            loginPage.setVisible(true);
            this.dispose(); 
             }
             }
             }
            
            
         }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error Occurred");
           
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
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        email1 = new javax.swing.JTextField();
        password2 = new javax.swing.JPasswordField();
        uname2 = new javax.swing.JTextField();
        signupb3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        loginb3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        homeb2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        uname3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 37, -1, -1));

        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sign Up");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 129, 36));

        jLabel3.setFont(new java.awt.Font("Bodoni MT Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User ID :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bodoni MT Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bodoni MT Black", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password : ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        email1.setToolTipText("Enter your email");
        jPanel1.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 257, -1));

        password2.setToolTipText("Enter your password");
        password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password2ActionPerformed(evt);
            }
        });
        jPanel1.add(password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 257, -1));

        uname2.setToolTipText("Enter your user name");
        uname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uname2ActionPerformed(evt);
            }
        });
        jPanel1.add(uname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 257, -1));

        signupb3.setBackground(new java.awt.Color(51, 153, 255));
        signupb3.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        signupb3.setForeground(new java.awt.Color(0, 0, 102));
        signupb3.setText("Sign Up");
        signupb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupb3ActionPerformed(evt);
            }
        });
        jPanel1.add(signupb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Back to home");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 421, -1, -1));

        loginb3.setBackground(new java.awt.Color(51, 153, 255));
        loginb3.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        loginb3.setForeground(new java.awt.Color(0, 0, 102));
        loginb3.setText("LogIn");
        loginb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginb3ActionPerformed(evt);
            }
        });
        jPanel1.add(loginb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Already have an account?");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 372, -1, -1));

        homeb2.setBackground(new java.awt.Color(51, 153, 255));
        homeb2.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        homeb2.setForeground(new java.awt.Color(0, 0, 102));
        homeb2.setText("Home");
        homeb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeb2ActionPerformed(evt);
            }
        });
        jPanel1.add(homeb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 419, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pramodhi\\Documents\\NetBeansProjects\\KellerSports\\pictures\\Keller_Sports__2_-removebg-preview.png")); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bodoni MT Black", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("User name :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        uname3.setToolTipText("Enter your userID");
        uname3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uname3ActionPerformed(evt);
            }
        });
        jPanel1.add(uname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 257, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(811, 524));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password2ActionPerformed

    private void uname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uname2ActionPerformed

    private void signupb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupb3ActionPerformed
        signup();
    }//GEN-LAST:event_signupb3ActionPerformed

    private void loginb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginb3ActionPerformed
        Login loginPage = new Login();
        loginPage.setVisible(true);
        this.dispose();    }//GEN-LAST:event_loginb3ActionPerformed

    private void homeb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeb2ActionPerformed
        Home homePage = new Home();
        homePage.setVisible(true);
        this.dispose();    }//GEN-LAST:event_homeb2ActionPerformed

    private void uname3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uname3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uname3ActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email1;
    private javax.swing.JButton homeb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginb3;
    private javax.swing.JPasswordField password2;
    private javax.swing.JButton signupb3;
    private javax.swing.JTextField uname2;
    private javax.swing.JTextField uname3;
    // End of variables declaration//GEN-END:variables
}
