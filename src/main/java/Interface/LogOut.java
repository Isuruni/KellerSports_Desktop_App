/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import javax.swing.JFrame;

/**
 *
 * @author Pramodhi
 */
public class LogOut extends javax.swing.JFrame {

    /**
     * Creates new form LogOut
     */
    public LogOut() {
        initComponents();
    }

    public void logOut(JFrame context, Login loginForm){
        loginForm.isLogged =false;
        context.setVisible(false);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        homeb3 = new javax.swing.JButton();
        homeb5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("You have successfully logged out");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 280, -1));

        jLabel8.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Log In again");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Back to home");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        homeb3.setBackground(new java.awt.Color(51, 153, 255));
        homeb3.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        homeb3.setForeground(new java.awt.Color(0, 0, 102));
        homeb3.setText("Home");
        homeb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeb3ActionPerformed(evt);
            }
        });
        jPanel1.add(homeb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        homeb5.setBackground(new java.awt.Color(51, 153, 255));
        homeb5.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        homeb5.setForeground(new java.awt.Color(0, 0, 102));
        homeb5.setText("LogIn");
        homeb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeb5ActionPerformed(evt);
            }
        });
        jPanel1.add(homeb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(594, 175));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeb3ActionPerformed
        Home homePage = new Home();
        homePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeb3ActionPerformed

    private void homeb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeb5ActionPerformed
        Login loginPage = new Login();
        loginPage.setVisible(true);
        this.dispose();    }//GEN-LAST:event_homeb5ActionPerformed

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
            java.util.logging.Logger.getLogger(LogOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeb3;
    private javax.swing.JButton homeb5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
