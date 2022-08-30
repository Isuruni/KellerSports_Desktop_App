/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Codes.DBconnector;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class CustomerDetails extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet results=null;
    public CustomerDetails() {
        initComponents();
        conn = DBconnector.connect();
        tableFill();
    }

    public void tableFill(){
    try{
        
            String sql ="Select customerid,userName,Address FROM users";
            pst=conn.prepareStatement(sql);
            results=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(results));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
     public void clear(){
         
         userid.setText("");
         name.setText("");
         address.setText("");
         
     }
     
     public void getTableData(){
         
        String cname, address1,cId;
        
         int row= table1.getSelectedRow();
         cId =table1.getValueAt(row, 0).toString();
         cname= table1.getValueAt(row, 1).toString();
         address1=table1.getValueAt(row, 2).toString();
         
         
         userid.setText(cId);
         name.setText(cname);
         address.setText(address1);
         
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        userid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        addbtn2 = new javax.swing.JButton();
        deletebtn1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        homeb5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Customer Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 36));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Customer ID", "Name", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 550, 350));

        jLabel8.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Customer ID :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        userid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useridActionPerformed(evt);
            }
        });
        jPanel1.add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 190, -1));

        jLabel5.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address : ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 90, -1));

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 190, 110));

        jLabel6.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 110, 60, -1));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 190, -1));

        edit.setBackground(new java.awt.Color(51, 153, 255));
        edit.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        edit.setForeground(new java.awt.Color(0, 0, 102));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 100, 30));

        clear.setBackground(new java.awt.Color(51, 153, 255));
        clear.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 0, 102));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 100, 30));

        addbtn2.setBackground(new java.awt.Color(51, 153, 255));
        addbtn2.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        addbtn2.setForeground(new java.awt.Color(0, 0, 102));
        addbtn2.setText("Add");
        addbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(addbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 100, 30));

        deletebtn1.setBackground(new java.awt.Color(51, 153, 255));
        deletebtn1.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        deletebtn1.setForeground(new java.awt.Color(0, 0, 102));
        deletebtn1.setText("Delete");
        deletebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(deletebtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 100, 30));

        jLabel9.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Back to admin home");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        homeb5.setBackground(new java.awt.Color(51, 153, 255));
        homeb5.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        homeb5.setForeground(new java.awt.Color(0, 0, 102));
        homeb5.setText("Admin Home");
        homeb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeb5ActionPerformed(evt);
            }
        });
        jPanel1.add(homeb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(900, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void useridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useridActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        String cname,address1,cid;
        cid=userid.getText();
        cname= name.getText();
        address1=address.getText();
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to update data?"); 
        if(confirm==0){
        if(cid.equals("") || cname.equals("")|| address1.equals("") )
        {
            JOptionPane.showMessageDialog(this,"All fields are compulsory");
            
        }
        else{
            try{
               String sql="update users set username='"+cname+"',address='"+address1+"' where customerid='"+cid+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(this, "Customer details successfully updated");
             
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,e);

            }
            tableFill();
            }
    }
    }//GEN-LAST:event_editActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       clear();
    }//GEN-LAST:event_clearActionPerformed

    private void addbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtn2ActionPerformed
         String cname,address1,cId;

        cId= userid.getText();
        cname= name.getText();
        address1=address.getText();

        if(cId.equals("") || cname.equals("")|| address1.equals("") )
        {
            JOptionPane.showMessageDialog(this,"All fields are compulsory");
        }
        else{
            try{
             String sql= "Select customerid from users  where customerid='"+cId+"'";
             pst=conn.prepareStatement(sql);
             results=pst.executeQuery();
             if(results.next()){
                 JOptionPane.showMessageDialog(this,"This customerId already exists");
             }
             else{

              sql="Insert into users Values ('"+cId+"', '"+cname+"','"+address1+"')";
                pst=conn.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(this, "Customer details successfully added");
            }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,e);
                    }
            tableFill();
        
        }
    }//GEN-LAST:event_addbtn2ActionPerformed

    private void deletebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn1ActionPerformed
         String cId=userid.getText();
        if(cId.equals("")){
            JOptionPane.showMessageDialog(this, "It is mandatory to insert product Id before deleting");
        }
        else{
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to delete data?"); 
        
        if(confirm==0){
            
            try{
                String sql= "Delete from users where customerid='"+cId+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Customer Details successfully deleted");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error Occurred");
                
            }
            tableFill();
            clear();
        }
        }
    }//GEN-LAST:event_deletebtn1ActionPerformed

    private void homeb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeb5ActionPerformed
        AdminHome adminHomePage = new AdminHome();
        adminHomePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeb5ActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        getTableData();
    }//GEN-LAST:event_table1MouseClicked

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
            java.util.logging.Logger.getLogger(CustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn2;
    private javax.swing.JTextField address;
    private javax.swing.JButton clear;
    private javax.swing.JButton deletebtn1;
    private javax.swing.JButton edit;
    private javax.swing.JButton homeb5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTable table1;
    private javax.swing.JTextField userid;
    // End of variables declaration//GEN-END:variables
}
