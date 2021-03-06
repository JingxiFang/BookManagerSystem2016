/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.view;

import com.bookstenancy.dao.ReaderDao;
import com.bookstenancy.pojo.Reader;
import com.bookstenancy.util.Tool;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class ReaderAdd extends javax.swing.JFrame {

    /**
     * Creates new form ReaderAdd
     */
    public ReaderAdd() {
         initComponents();
        
        setSize(600, 630);    
         
            int width=Tool.GetScreensize_Width();
        int Height=Tool.GetScreensize_Heigth();
        setLocation(width/2-this.getWidth()/2, Height/2-this.getHeight()/2);   
          
        String path = "src/Images/ReaderAdd.jpg";  
        
        ImageIcon background = new ImageIcon(path);  
        
        JLabel label = new JLabel(background);  
      
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
         
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
       
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
         setResizable(false);
        setVisible(true);  
        GetNowTime();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
       
    }

    /**
     * 获取系统当前时间 放在jTextField5中
     */
    private void GetNowTime(){
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        java.util.Date startDt=new java.util.Date();// new Date()为获取当前系统时间
        String strTime=df.format(startDt);
        jTextField5.setText(strTime);
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
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("增加读者");

        jLabel1.setFont(new java.awt.Font("等线 Light", 0, 24)); // NOI18N
        jLabel1.setText("添加读者信息");

        jLabel2.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jLabel2.setText("编号");

        jTextField1.setText("(系统自动生成)");
        jTextField1.setToolTipText("");
        jTextField1.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jLabel3.setText("姓名");

        jLabel4.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jLabel4.setText("手机号码");

        jLabel5.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jLabel5.setText("类别");

        jLabel6.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jLabel6.setText("注册时间");

        jTextField5.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(0, 160, 233));
        jButton1.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jButton1.setText("储存");
        jButton1.setToolTipText("");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 160, 233));
        jButton2.setFont(new java.awt.Font("等线 Light", 0, 18)); // NOI18N
        jButton2.setText("取消");
        jButton2.setToolTipText("");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("微软雅黑", 0, 15)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "普通", "会员", "黄金会员" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(228, 228, 228)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(156, 156, 156)
                            .addComponent(jLabel2)
                            .addGap(69, 69, 69)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(69, 69, 69)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(69, 69, 69)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(69, 69, 69)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //获取信息 放在读者对象中
       Reader reader=new Reader();
       reader.setName(jTextField2.getText());
       reader.setPhone(jTextField3.getText());
       reader.setType(jComboBox1.getSelectedItem().toString());
      //注册时间用系统获得
      // reader.setResigterTime(jTextField5.getText());
        //放在数据库中
        ReaderDao readerDao=new ReaderDao();
        try {
            int readerid=readerDao.AddReader(reader);
            if(readerid!=0){
                //是否继续添加
                 int n = JOptionPane.showConfirmDialog(null, "添加成功 读者编号为"+readerid+".  \n 是否继续添加?", "添加",JOptionPane.YES_NO_OPTION);
                if(n==0){
                    //jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    //jTextField4.setText("");
                    jComboBox1.setSelectedIndex(0);
                    GetNowTime();
                } 
                else{
                    this.dispose();
                }
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "抱歉 系统繁忙 请稍后重试", "！",JOptionPane.WARNING_MESSAGE); 
                 this.dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "抱歉 系统繁忙 请稍后重试", "！",JOptionPane.WARNING_MESSAGE); 
            Logger.getLogger(ReaderAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ReaderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReaderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReaderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReaderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReaderAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
