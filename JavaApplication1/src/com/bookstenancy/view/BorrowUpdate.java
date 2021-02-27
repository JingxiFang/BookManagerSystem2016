/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.view;

import com.bookstenancy.dao.BorrowDao;
import com.bookstenancy.dao.ReaderDao;
import com.bookstenancy.pojo.Borrow;
import com.bookstenancy.service.BorrowContorl;
import com.bookstenancy.util.SqlHelper;
import com.bookstenancy.util.Tool;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class BorrowUpdate extends javax.swing.JFrame {

    /**
     * Creates new form BorrowUpdate
     */
    public BorrowUpdate() {
           initComponents();
       
        
        setSize(800, 600);    
         
        //设置位置  
            int width=Tool.GetScreensize_Width();
        int Height=Tool.GetScreensize_Heigth();
        setLocation(width/2-this.getWidth()/2, Height/2-this.getHeight()/2);   
          
        String path = "src/Images/BorrowUpdate.jpg";  
        
        ImageIcon background = new ImageIcon(path);  
        
        JLabel label = new JLabel(background);  
      
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
         
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
       
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        
        setVisible(true);  
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("归还图书");

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        jLabel1.setText("归还图书");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        jLabel2.setText("读者编号");

        jButton1.setBackground(new java.awt.Color(0, 160, 233));
        jButton1.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("查询");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "借阅id", "图书编号", "图书名称", "借书时间", "当前金额"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 160, 233));
        jButton2.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("归还全部");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 160, 233));
        jButton3.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("归还选中项");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField2.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        jLabel3.setText("读者姓名");

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        jLabel4.setText("读者类型");

        jTextField3.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1)))
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(254, 359, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(369, 369, 369))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try {
            //查询读者姓名 显示在文本框中
            String readerID=jTextField1.getText();
            ReaderDao readerDao=new ReaderDao();
            jTextField2.setText(readerDao.SelectReaderNameById(readerID));
            jTextField3.setText(readerDao.SelectReaderTypeNameById(readerID));
            //查询读者借的书 显示在表格中
            BorrowDao borrowdao=new BorrowDao();
            List<Borrow> listBorrow=new ArrayList<Borrow>();
            listBorrow=borrowdao.SelectBorrowByReaderIdandStatusid(readerID, "1");//status =1 表示正在借阅
            
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);// 清除原有行
            for (int i=0;i<listBorrow.size();i++){
                //创建一个数组 便于往表格中放数据
                String[] arr=new String[5];
                Borrow borrow=new Borrow();
                borrow=listBorrow.get(i);
                arr[0]=Integer.toString(borrow.getId());
                arr[1]=Integer.toString( borrow.getBookId());
                arr[2]=borrow.getBookName();
                arr[3]=borrow.getStarDay();
                arr[4]=String.valueOf(borrow.getAccount());
                // 添加数据到表格
               tableModel.addRow(arr);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BorrowUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //获取表格中全部的id
        try {
            List<String> listBookId = new ArrayList<String>();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            int rowCount=tableModel.getRowCount();
            double accountSum=0;
            for(int i=0;i<rowCount;i++){
                //获取借阅号
                listBookId.add((String)tableModel.getValueAt(i, 0));
               
                accountSum+=Double.valueOf((String)tableModel.getValueAt(i, 4));
            }
            //归还所有的
            //获得总金额 提示
             int n = JOptionPane.showConfirmDialog(null, "一共"+accountSum+"元，确定归回吗？", "金额",JOptionPane.YES_NO_OPTION);
             if(n==0){
                Update(listBookId);
               //点击刷新（即再次查询）
               jButton1ActionPerformed(evt);
             }
        } 
        catch (SQLException ex) {
            Logger.getLogger(BorrowUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * 更改借阅号在 listBookId 中的所有的借阅记录 为 已归还
     * @param listBookId
     * @return
     * @throws SQLException 
     */
    public Boolean Update (List<String> listBookId) throws SQLException{
         BorrowContorl borrowcontorl=new BorrowContorl();
         for (int i=0;i<listBookId.size();i++){
               if(!borrowcontorl.UpdaeBorrow(listBookId.get(i),"2")){
                    JOptionPane.showMessageDialog(this,"系统异常请稍后重试", "异常",JOptionPane.ERROR_MESSAGE);
                    return false;
               } 
            }
         return true;
    }
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //  DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        try {
            List<String> listBookId = new ArrayList<String>();
            double accountSum=0;
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            int selectRows=jTable1.getSelectedRows().length;// 取得用户所选行的行数
            int[] selectIndexs=null;
            if(selectRows>0){
                selectIndexs=jTable1.getSelectedRows(); 
            }
            for(int i=0;i<selectRows;i++){
               
                // 用tableModel.getValueAt(row, column)取单元格数据
                listBookId.add((String)tableModel.getValueAt(selectIndexs[i], 0));
                accountSum+=Double.valueOf((String)tableModel.getValueAt(selectIndexs[i], 4));
            }
            //归还所有的
            //获得总金额 提示
             int n = JOptionPane.showConfirmDialog(null, "一共"+accountSum+"元，确定归回吗？", "金额",JOptionPane.YES_NO_OPTION);
             if(n==0){
                Update(listBookId);
               //点击刷新（即再次查询）
               jButton1ActionPerformed(evt);
             }
            //点击刷新（即再次查询）
               jButton1ActionPerformed(evt);
        }
        catch (SQLException ex) {
                Logger.getLogger(BorrowUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(BorrowUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
