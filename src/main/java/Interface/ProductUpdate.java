/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Codes.DBconnector;
import Codes.Model;
import Codes.Product;
import java.awt.Image;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Pramodhi
 */
public class ProductUpdate extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement pst=null;
     ResultSet results=null;
    public ProductUpdate() {
        initComponents();
        conn = DBconnector.connect();
        tableFill();
    }

    public void tableFill(){
    try{
         
            ArrayList<Product> list = new ArrayList<Product>();        
            String sql ="Select * FROM products";
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
        table2.setModel(model);
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
     public void getTableData(){
         
        String pname, pcategory,pId, pquantity,pprice;
        
         int row= table2.getSelectedRow();
         pId =table2.getValueAt(row, 0).toString();
         pname= table2.getValueAt(row, 1).toString();
         pquantity=table2.getValueAt(row, 2).toString();
         pprice=table2.getValueAt(row, 3).toString();
         pcategory =table2.getValueAt(row, 4).toString();
         
         productid3.setText(pId);
         name.setText(pname);
         quantity.setText(pquantity);
         price.setText(pprice);
         categories.setSelectedItem(pcategory);
         
         if(table2.getValueAt(row, 5)!=null){
            ImageIcon image = (ImageIcon) table2.getValueAt(row,5);
            Image image1 = image.getImage().getScaledInstance(imagelb.getWidth(),imagelb.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon image2= new ImageIcon(image1);
            imagelb.setIcon(image2);
         }
         else{
             System.out.println("No Image Available");
         }
         
     }
     
     public void search(){
         String word=search.getText();
         ArrayList<Product> list = new ArrayList<Product>(); 
         
         try{
             String sql="Select * From products where name LIKE '%"+word+"%' "
                     + "or category LIKE '%"+word+"%' ";
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
        table2.setModel(model);
        
         }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error Occurred");
         }
     }
     
     public void edit(){
         String pname, pcategory,pId, pquantity,pprice;
        
         pId =productid3.getText();
         pname= name.getText();
         pquantity=quantity.getText();
         pprice=price.getText();
         pcategory = categories.getSelectedItem().toString();
          
         int confirm = JOptionPane.showConfirmDialog(this, "Do you want to update data?"); 

         if(confirm==0){
        if(pId.equals("") || pname.equals("")|| pquantity.equals("")||pprice.equals("")||pcategory.equals(""))
        {
            JOptionPane.showMessageDialog(this,"All fields are compulsory");
        }
        else{
           try{
             
             String sql="Update products set name='"+pname+"',quantity='"+pquantity+"',"
                     + "price='"+pprice+"',category='"+pcategory+"' where productid='"+pId+"'";
             pst=conn.prepareStatement(sql);
             pst.execute();
            
            JOptionPane.showMessageDialog(this, "Data Updated");
         }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error Occurred");
           
         }
        tableFill();
     } 
        }
         
     }
     
     public void clear(){
         search.setText("");
         productid3.setText("");
         name.setText("");
         quantity.setText("");
         price.setText("");
         imageurl.setText("");
         imagelb.setIcon(null);
         categories.setSelectedIndex(0);
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        imageurl = new javax.swing.JTextField();
        categories = new javax.swing.JComboBox<>();
        attachbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        homeb5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        productid3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        productid1 = new javax.swing.JTextField();
        search = new javax.swing.JTextField();
        addbtn1 = new javax.swing.JButton();
        imagelb = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        editbtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Bodoni MT Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Products Update");
        jLabel2.setAutoscrolls(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 240, 36));

        jLabel3.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select Image :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Price :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 190, -1));

        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 190, -1));

        imageurl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageurlActionPerformed(evt);
            }
        });
        jPanel1.add(imageurl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 200, -1));

        categories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clothes", "Shoes", "Equipments", "Others" }));
        jPanel1.add(categories, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 190, -1));

        attachbtn.setBackground(new java.awt.Color(51, 153, 255));
        attachbtn.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        attachbtn.setForeground(new java.awt.Color(0, 0, 102));
        attachbtn.setText("Attach");
        attachbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachbtnActionPerformed(evt);
            }
        });
        jPanel1.add(attachbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, -1, -1));

        clearbtn.setBackground(new java.awt.Color(51, 153, 255));
        clearbtn.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        clearbtn.setForeground(new java.awt.Color(0, 0, 102));
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel1.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 100, -1));

        deletebtn.setBackground(new java.awt.Color(51, 153, 255));
        deletebtn.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(0, 0, 102));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel1.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 100, -1));

        jLabel8.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Product ID: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bodoni MT Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Back to admin home");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 580, -1, -1));

        homeb5.setBackground(new java.awt.Color(51, 153, 255));
        homeb5.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        homeb5.setForeground(new java.awt.Color(0, 0, 102));
        homeb5.setText("Admin Home");
        homeb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeb5ActionPerformed(evt);
            }
        });
        jPanel1.add(homeb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 580, -1, -1));

        table2.setAutoCreateRowSorter(true);
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Category", "Image"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setRowHeight(190);
        table2.setShowGrid(true);
        table2.getTableHeader().setReorderingAllowed(false);
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setResizable(false);
            table2.getColumnModel().getColumn(0).setPreferredWidth(100);
            table2.getColumnModel().getColumn(1).setPreferredWidth(100);
            table2.getColumnModel().getColumn(2).setResizable(false);
            table2.getColumnModel().getColumn(2).setPreferredWidth(50);
            table2.getColumnModel().getColumn(3).setResizable(false);
            table2.getColumnModel().getColumn(3).setPreferredWidth(50);
            table2.getColumnModel().getColumn(5).setPreferredWidth(200);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 760, 470));

        productid3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productid3ActionPerformed(evt);
            }
        });
        jPanel1.add(productid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 190, -1));

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 280, -1));

        addbtn1.setBackground(new java.awt.Color(51, 153, 255));
        addbtn1.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        addbtn1.setForeground(new java.awt.Color(0, 0, 102));
        addbtn1.setText("Add");
        addbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(addbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 100, -1));

        imagelb.setBackground(new java.awt.Color(255, 255, 255));
        imagelb.setForeground(new java.awt.Color(255, 255, 255));
        imagelb.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(imagelb, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 200, 200));

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 190, -1));

        editbtn1.setBackground(new java.awt.Color(51, 153, 255));
        editbtn1.setFont(new java.awt.Font("Bodoni MT Black", 1, 12)); // NOI18N
        editbtn1.setForeground(new java.awt.Color(0, 0, 102));
        editbtn1.setText("Edit");
        editbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(editbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1180, 664));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void imageurlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageurlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imageurlActionPerformed

    private void attachbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachbtnActionPerformed
     JFileChooser choose= new JFileChooser();
     choose.showOpenDialog(this);
     java.io.File f=choose.getSelectedFile();
     filename=f.getAbsolutePath();
     imageurl.setText(filename);
     Image getAbsolutePath=null;
     ImageIcon icon=new ImageIcon(filename);
     Image image=icon.getImage().getScaledInstance(imagelb.getWidth(),imagelb.getHeight(),Image.SCALE_SMOOTH);
     imagelb.setIcon(icon);
  
    }//GEN-LAST:event_attachbtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        String pId=productid3.getText();
        if(pId.equals("")){
            JOptionPane.showMessageDialog(this, "It is mandatory to insert product Id before deleting");
        }
        else{
        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to delete data?"); 
        
        if(confirm==0){
            
            try{
                String sql= "Delete from products where productid='"+pId+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Product successfully deleted");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Error Occurred");
                
            }
            tableFill();
            clear();
        }
        }
      
    }//GEN-LAST:event_deletebtnActionPerformed

    private void homeb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeb5ActionPerformed
        AdminHome adminHomePage = new AdminHome();
        adminHomePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeb5ActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        getTableData();
    }//GEN-LAST:event_table2MouseClicked

    private void productid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productid1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void productid3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productid3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productid3ActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        search();
    }//GEN-LAST:event_searchKeyReleased

    private void addbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtn1ActionPerformed
        String pname, pcategory;
        String pId=productid3.getText();
        pname= name.getText();
        String pquantity=quantity.getText();
        String pprice=price.getText();
        pcategory = categories.getSelectedItem().toString();
        String image=imageurl.getText();
        byte[] byteData = image.getBytes();
       
    
         if(pId.equals("") || pname.equals("")|| pquantity.equals("") ||pprice.equals("") ||pcategory.equals(""))
         {
              JOptionPane.showMessageDialog(this,"All fields are compulsory");
         }
         else{
             try{
            Blob img = new SerialBlob(byteData);
            String sql= "Select productid from products  where productid='"+pId+"'";
             pst=conn.prepareStatement(sql);
             results=pst.executeQuery();
             if(results.next()){
                 JOptionPane.showMessageDialog(this,"This productId already exists");
             }
             
             else{
                 sql="Insert into products Values ('"+pId+"', '"+pname+"','"+pquantity+"',"
                     + "'"+pprice+"','"+pcategory+"','"+image+"')";
             pst=conn.prepareStatement(sql);
             pst.execute();
            
            JOptionPane.showMessageDialog(this, "Product successfully added");
             }
         }catch(Exception e){
            JOptionPane.showMessageDialog(this,e);
           
         }
        
           tableFill();
         }
         
    }//GEN-LAST:event_addbtn1ActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void editbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtn1ActionPerformed
 
           edit()  ;
           
    }//GEN-LAST:event_editbtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn1;
    private javax.swing.JButton attachbtn;
    private javax.swing.JComboBox<String> categories;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton editbtn1;
    private javax.swing.JButton homeb5;
    private javax.swing.JLabel imagelb;
    private javax.swing.JTextField imageurl;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JTextField productid1;
    private javax.swing.JTextField productid3;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField search;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
String filename="";
int s=0;
byte[] image=null;
}

