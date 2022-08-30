/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Codes.DBconnector;
import Codes.Model;
import Codes.Product;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Pramodhi
 */
public class Shoes extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
     ResultSet results=null;
    public Shoes() {
        initComponents();
        conn = DBconnector.connect();
        tableFill();
    }
     public void tableFill(){    
            String shoes="Shoes";
            String sql ="Select * FROM products where category='"+shoes+"'";
            getTable(sql);
       
    }
    
    public void getTable(String sql){
                    ArrayList<Product> list = new ArrayList<Product>();     

        try{
            pst=conn.prepareStatement(sql);
        
            results=pst.executeQuery();
            Product p;
                while(results.next()){
                p = new Product(
                results.getInt(1),
                results.getString(2),
                results.getInt(3),
                results.getDouble(4),
                results.getString(5),
                results.getBytes(6)
                );
                list.add(p);
                }
                
                String[] columnName = {"ProductId","Name","Quantity","Price","Category","Image"};
        Object[][] rows = new Object[list.size()][7];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).pId;
            rows[i][1] = list.get(i).name;
            rows[i][2] = list.get(i).quantity;
            rows[i][3] = list.get(i).price;
            rows[i][4] = list.get(i).category;

            
            if(list.get(i).image != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).image).getImage()
             .getScaledInstance(190, 170, Image.SCALE_SMOOTH) );   
                
            rows[i][5] = image;
            }
            else{
                rows[i][5] = null;
            }
            
        }
        
        Model model = new Model(rows, columnName);
        table.setModel(model);
    }
         catch(Exception e){
    JOptionPane.showMessageDialog(this, "Error Occurred");
    }
    }
   

      public void search(){
        String word=search.getText();
        String shoes="Shoes";
        String sql="Select * From products where category = '"+shoes+"'  and name LIKE '%"+word+"%' ";
         getTable(sql);
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        productid1 = new javax.swing.JTextField();
        search = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        homeb3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Shoes");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 110, 36));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productid1ActionPerformed(evt);
            }
        });
        jPanel3.add(productid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 190, -1));

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel3.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 280, -1));

        jLabel7.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Back to product categories");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, -1, -1));

        homeb3.setBackground(new java.awt.Color(51, 153, 255));
        homeb3.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        homeb3.setForeground(new java.awt.Color(0, 0, 102));
        homeb3.setText("Product Categories");
        homeb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeb3ActionPerformed(evt);
            }
        });
        jPanel1.add(homeb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 550, -1, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ProductId", "Name", "Quantity", "Price", "Category", "Image"
            }
        ));
        table.setRowHeight(200);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 740, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 590));

        setSize(new java.awt.Dimension(845, 633));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void productid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productid1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        search();
    }//GEN-LAST:event_searchKeyReleased

    private void homeb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeb3ActionPerformed
        Products produtsPage = new Products();
        produtsPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeb3ActionPerformed

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
            java.util.logging.Logger.getLogger(Shoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Shoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Shoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Shoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Shoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeb3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField productid1;
    private javax.swing.JTextField search;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
