/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Codes.DBconnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Pramodhi
 */
public class Orders extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet results=null;
    public Orders() {
        initComponents();
        conn = DBconnector.connect();
        tableFill();
    }

    public void tableFill(){
    try{
        
            String sql ="Select * FROM orders";
            pst=conn.prepareStatement(sql);
            results=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(results));
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error Occurred");
        }
    }
    public void clear(){
         
         orderid.setText("");
         productid.setText("");
         customerid.setText("");
         quantity.setText("");
         Date date1 = new Date();
         date.setDate((date1));
        
         
     }
   public void getTableData(){
         
        String pId, oId,cId,oquantity,odate;
        
         int row= table1.getSelectedRow();
         oId =table1.getValueAt(row, 0).toString();
         pId= table1.getValueAt(row, 1).toString();
         cId=table1.getValueAt(row, 2).toString();
         oquantity=table1.getValueAt(row, 3).toString();
         odate=table1.getValueAt(row, 4).toString();
         
         
         orderid.setText(oId);
         productid.setText(pId);
         customerid.setText(cId);
         quantity.setText(oquantity);
         Date date1 = new Date();
         SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
         
        try { 
            date1 = ft.parse(odate);
             date.setDate((date1));
        } catch (ParseException ex) {
            Logger.getLogger(Orders.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        orderid = new javax.swing.JTextField();
        productid = new javax.swing.JTextField();
        customerid = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        addbtn2 = new javax.swing.JButton();
        deletebtn1 = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        homeb5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 36));

        jLabel8.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Order ID :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customer ID :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, -1));

        jLabel7.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 120, -1));

        jLabel9.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Product ID :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, -1));

        jLabel5.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 90, -1));

        orderid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderidActionPerformed(evt);
            }
        });
        jPanel1.add(orderid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 190, -1));

        productid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productidActionPerformed(evt);
            }
        });
        jPanel1.add(productid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 190, -1));

        customerid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customeridActionPerformed(evt);
            }
        });
        jPanel1.add(customerid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 190, -1));

        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 190, -1));

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

        jLabel10.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Back to admin home");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

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

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Product ID", "Customer ID", "Quantity", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setShowGrid(true);
        table1.getTableHeader().setReorderingAllowed(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 550, 350));

        date.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 520));

        setSize(new java.awt.Dimension(900, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void orderidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderidActionPerformed

    private void productidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productidActionPerformed

    private void customeridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customeridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customeridActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void addbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtn2ActionPerformed
        String oId,pId,cId,oquantity,odate;
        oId= orderid.getText();
        pId= productid.getText();
        cId=customerid.getText();
        oquantity=quantity.getText();
       
        Date date1=new Date();
        date1=date.getDate();
        SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
         
        odate=ft.format(date1);
        
        if(oId.equals("") || pId.equals("")|| cId.equals("")||oquantity.equals("") )
        {
            JOptionPane.showMessageDialog(this,"All fields are compulsory except for the date");
        }
        else{
            
            try{
                
                String sql= "Select orderid from orders  where orderid='"+oId+"'";
                pst=conn.prepareStatement(sql);
                results=pst.executeQuery();
                if(results.next()){
                    JOptionPane.showMessageDialog(this,"This OrderId already exists");
                }
                else{

                    sql="Insert into orders Values ('"+oId+"', '"+pId+"','"+cId+"','"+oquantity+"','"+odate+"')";
                    pst=conn.prepareStatement(sql);
                    pst.execute();

                    JOptionPane.showMessageDialog(this, "Order details successfully added");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,e);
            }
            tableFill();

        }
    }//GEN-LAST:event_addbtn2ActionPerformed

    private void deletebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtn1ActionPerformed
        String oId=orderid.getText();
        if(oId.equals("")){
            JOptionPane.showMessageDialog(this, "It is mandatory to insert Ordeer Id before deleting");
        }
        else{
            int confirm = JOptionPane.showConfirmDialog(this, "Do you want to delete data?");

            if(confirm==0){

                try{
                    String sql= "Delete from orders where orderid='"+oId+"'";
                    pst=conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(this, "Order Details successfully deleted");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Error Occurred");

                }
                tableFill();
                clear();
            }
        }
    }//GEN-LAST:event_deletebtn1ActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        String oId,pId,cId,oquantity, odate;

        oId= orderid.getText();
        pId= productid.getText();
        cId=customerid.getText();
        oquantity=quantity.getText();
        Date date1=new Date();
        date1=date.getDate();
        SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
         
        odate=ft.format(date1);
        
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to update data?");
        if(confirm==0){
            if(oId.equals("") || pId.equals("")|| cId.equals("")||oquantity.equals(""))
            {
                JOptionPane.showMessageDialog(this,"All fields are compulsory");
            }
            else{
                try{
                    String sql="update orders set orderid='"+oId+"',productid='"+pId+"',customerid='"+cId+"',quantity='"+oquantity+"',date='"+odate+"' where orderid='"+oId+"'";
                    pst=conn.prepareStatement(sql);
                    pst.execute();

                    JOptionPane.showMessageDialog(this, "Order details successfully updated");

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
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn2;
    private javax.swing.JButton clear;
    private javax.swing.JTextField customerid;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton deletebtn1;
    private javax.swing.JButton edit;
    private javax.swing.JButton homeb5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField orderid;
    private javax.swing.JTextField productid;
    private javax.swing.JTextField quantity;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
