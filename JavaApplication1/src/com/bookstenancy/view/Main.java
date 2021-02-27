/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.view;

import com.bookstenancy.service.ManagerContorl;
import com.bookstenancy.util.Tool;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
/**
 *
 * @author 74080
 */
public class Main extends javax.swing.JFrame {
private static String mName=null;
    /**
     * Creates new form Main
     */
    public Main(String uName) {
        initComponents();
        
        
        //设置大小  
        setSize(1064, 782);  
        //设置位置  
            int width=Tool.GetScreensize_Width();
        int Height=Tool.GetScreensize_Heigth();
        setLocation(width/2-this.getWidth()/2, Height/2-this.getHeight()/2);   
        //背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）  
        String path = "src/Images/main.jpg";  
        setResizable(false);

       
        // 背景图片  
        ImageIcon background = new ImageIcon(path);  
        // 把背景图片显示在一个标签里面  
        JLabel label = new JLabel(background);  
        // 把标签的大小位置设置为图片刚好填充整个面板  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // 把背景图片添加到分层窗格的最底层作为背景  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        //设置可见  
        setVisible(true);  
        //点关闭按钮时退出  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.mName=uName;
         jLabel2.setText(uName);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        jMenu20 = new javax.swing.JMenu();
        jMenu33 = new javax.swing.JMenu();
        jMenu34 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenu35 = new javax.swing.JMenu();
        jMenu36 = new javax.swing.JMenu();
        jMenu37 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu38 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu39 = new javax.swing.JMenu();
        jMenu40 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu23 = new javax.swing.JMenu();
        jMenu29 = new javax.swing.JMenu();
        jMenu30 = new javax.swing.JMenu();
        jMenu31 = new javax.swing.JMenu();
        jMenu32 = new javax.swing.JMenu();
        jMenu24 = new javax.swing.JMenu();
        jMenu25 = new javax.swing.JMenu();
        jMenu26 = new javax.swing.JMenu();
        jMenu28 = new javax.swing.JMenu();
        jMenu41 = new javax.swing.JMenu();
        jMenu42 = new javax.swing.JMenu();
        jMenu44 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Little Light");

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18)); // NOI18N
        jLabel1.setText("当前用户：");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 24)); // NOI18N
        jLabel2.setText("jLabel2");

        jMenuBar1.setPreferredSize(new java.awt.Dimension(70, 50));

        jMenu1.setText("    借阅    ");

        jMenu3.setText("借书");
        jMenu3.setPreferredSize(new java.awt.Dimension(83, 30));
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu3);

        jMenu4.setText("还书");
        jMenu4.setPreferredSize(new java.awt.Dimension(83, 30));
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu4);

        jMenu5.setText("借阅记录查询");
        jMenu5.setPreferredSize(new java.awt.Dimension(143, 30));

        jMenu6.setText("按照图书查询");
        jMenu6.setPreferredSize(new java.awt.Dimension(143, 30));
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenu5.add(jMenu6);

        jMenu9.setText("按照读者查询");
        jMenu9.setPreferredSize(new java.awt.Dimension(143, 30));
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenu9.add(jSeparator1);

        jMenu5.add(jMenu9);

        jMenu1.add(jMenu5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("    维护    ");

        jMenu11.setText("图书信息");
        jMenu11.setPreferredSize(new java.awt.Dimension(117, 30));

        jMenu12.setText("增加");
        jMenu12.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu12MouseClicked(evt);
            }
        });
        jMenu11.add(jMenu12);

        jMenu13.setText("删除");
        jMenu13.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu13MouseClicked(evt);
            }
        });
        jMenu11.add(jMenu13);

        jMenu14.setText("修改");
        jMenu14.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu14MouseClicked(evt);
            }
        });
        jMenu11.add(jMenu14);

        jMenu2.add(jMenu11);

        jMenu17.setText("图书类别信息");
        jMenu17.setPreferredSize(new java.awt.Dimension(143, 30));

        jMenu18.setText("增加");
        jMenu18.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu18MouseClicked(evt);
            }
        });
        jMenu17.add(jMenu18);

        jMenu19.setText("删除");
        jMenu19.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu19MouseClicked(evt);
            }
        });
        jMenu17.add(jMenu19);

        jMenu20.setText("修改");
        jMenu20.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu20MouseClicked(evt);
            }
        });
        jMenu17.add(jMenu20);

        jMenu2.add(jMenu17);

        jMenuBar1.add(jMenu2);

        jMenu33.setText("    查询    ");

        jMenu34.setText("图书信息");
        jMenu34.setPreferredSize(new java.awt.Dimension(113, 30));

        jMenu15.setText("查看全部");
        jMenu15.setPreferredSize(new java.awt.Dimension(113, 30));
        jMenu15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu15MouseClicked(evt);
            }
        });
        jMenu34.add(jMenu15);

        jMenu35.setText("名称查询");
        jMenu35.setPreferredSize(new java.awt.Dimension(113, 30));
        jMenu35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu35MouseClicked(evt);
            }
        });
        jMenu34.add(jMenu35);

        jMenu36.setText("编号查询");
        jMenu36.setPreferredSize(new java.awt.Dimension(113, 30));
        jMenu36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu36MouseClicked(evt);
            }
        });
        jMenu34.add(jMenu36);

        jMenu37.setText("出版社查询");
        jMenu37.setPreferredSize(new java.awt.Dimension(127, 30));
        jMenu37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu37MouseClicked(evt);
            }
        });
        jMenu34.add(jMenu37);

        jMenu7.setText("类型查询");
        jMenu7.setPreferredSize(new java.awt.Dimension(113, 30));
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenu34.add(jMenu7);

        jMenu33.add(jMenu34);

        jMenu38.setText("读者信息");
        jMenu38.setPreferredSize(new java.awt.Dimension(113, 30));

        jMenu16.setText("查看全部");
        jMenu16.setPreferredSize(new java.awt.Dimension(117, 30));
        jMenu16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu16MouseClicked(evt);
            }
        });
        jMenu38.add(jMenu16);

        jMenu39.setText("姓名查询");
        jMenu39.setPreferredSize(new java.awt.Dimension(113, 30));
        jMenu39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu39MouseClicked(evt);
            }
        });
        jMenu38.add(jMenu39);

        jMenu40.setText("手机号码查询");
        jMenu40.setPreferredSize(new java.awt.Dimension(143, 30));
        jMenu40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu40MouseClicked(evt);
            }
        });
        jMenu38.add(jMenu40);

        jMenu8.setText("类型查找");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenu38.add(jMenu8);

        jMenu33.add(jMenu38);

        jMenu10.setText("图书类别信息");
        jMenu10.setPreferredSize(new java.awt.Dimension(143, 30));
        jMenu10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu10MouseClicked(evt);
            }
        });
        jMenu33.add(jMenu10);

        jMenuBar1.add(jMenu33);

        jMenu23.setText("    管理    ");

        jMenu29.setText("读者信息");
        jMenu29.setPreferredSize(new java.awt.Dimension(113, 30));

        jMenu30.setText("增加");
        jMenu30.setPreferredSize(new java.awt.Dimension(83, 30));
        jMenu30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu30MouseClicked(evt);
            }
        });
        jMenu29.add(jMenu30);

        jMenu31.setText("删除");
        jMenu31.setPreferredSize(new java.awt.Dimension(83, 30));
        jMenu31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu31MouseClicked(evt);
            }
        });
        jMenu29.add(jMenu31);

        jMenu32.setText("修改");
        jMenu32.setPreferredSize(new java.awt.Dimension(83, 30));
        jMenu32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu32MouseClicked(evt);
            }
        });
        jMenu29.add(jMenu32);

        jMenu23.add(jMenu29);

        jMenu24.setText("管理员信息");
        jMenu24.setPreferredSize(new java.awt.Dimension(127, 30));

        jMenu25.setText("增加");
        jMenu25.setPreferredSize(new java.awt.Dimension(83, 30));
        jMenu25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu25MouseClicked(evt);
            }
        });
        jMenu24.add(jMenu25);

        jMenu26.setText("删除");
        jMenu26.setPreferredSize(new java.awt.Dimension(83, 30));
        jMenu26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu26MouseClicked(evt);
            }
        });
        jMenu24.add(jMenu26);

        jMenu28.setText("查询");
        jMenu28.setPreferredSize(new java.awt.Dimension(83, 30));
        jMenu28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu28MouseClicked(evt);
            }
        });
        jMenu24.add(jMenu28);

        jMenu23.add(jMenu24);

        jMenuBar1.add(jMenu23);

        jMenu41.setText("    工具    ");

        jMenu42.setText("修改密码");
        jMenu42.setPreferredSize(new java.awt.Dimension(113, 30));
        jMenu42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu42MouseClicked(evt);
            }
        });
        jMenu41.add(jMenu42);

        jMenu44.setText("注销");
        jMenu44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu44MouseClicked(evt);
            }
        });
        jMenu41.add(jMenu44);

        jMenuBar1.add(jMenu41);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(475, 475, 475)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(499, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(623, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu12MouseClicked
        // TODO add your handling code here:
         BookAdd bookadd=new BookAdd();
        bookadd.show();
    }//GEN-LAST:event_jMenu12MouseClicked

    private void jMenu44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu44MouseClicked
        // TODO add your handling code here:
        ManagerContorl managercontorl=new ManagerContorl();
        try {
            managercontorl.UpdateManagerStatus(mName, 0);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login login=new Login();
        login.show();
    }//GEN-LAST:event_jMenu44MouseClicked

    private void jMenu30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu30MouseClicked
        // TODO add your handling code here:
        ReaderAdd readerAddF=new ReaderAdd();
        readerAddF.show();
    }//GEN-LAST:event_jMenu30MouseClicked

    private void jMenu32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu32MouseClicked
        // TODO add your handling code here:
       ReaderUpdate ruF=new ReaderUpdate();
       ruF.show();
    }//GEN-LAST:event_jMenu32MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        BorrowAdd borrowAdd =new BorrowAdd();
        borrowAdd.show();
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        BorrowUpdate borrowUpdate=new BorrowUpdate();
        borrowUpdate.show();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        RecordSearchByBookId recordSearch=new RecordSearchByBookId();
        recordSearch.show();
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        // TODO add your handling code here:
        RecordSearchByReaderId recordSearch=new RecordSearchByReaderId();
        recordSearch.show();
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenu13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu13MouseClicked
        // TODO add your handling code here:
        BookDelete bookdelete= new BookDelete();
        bookdelete.show();
    }//GEN-LAST:event_jMenu13MouseClicked

    private void jMenu14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu14MouseClicked
        // TODO add your handling code here:
        BookUpdateById bookupdate=new BookUpdateById();
        bookupdate.show();
    }//GEN-LAST:event_jMenu14MouseClicked

    private void jMenu18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu18MouseClicked
        // TODO add your handling code here:
       CatrgoryAdd ac= new CatrgoryAdd();
       ac.show();
        
    }//GEN-LAST:event_jMenu18MouseClicked

    private void jMenu19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu19MouseClicked
        // TODO add your handling code here:
        CategoryDelete cd=new CategoryDelete();
        cd.show();
    }//GEN-LAST:event_jMenu19MouseClicked

    private void jMenu20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu20MouseClicked
        // TODO add your handling code here:
        CategoryUpdateById cu=new CategoryUpdateById();
        cu.show();
    }//GEN-LAST:event_jMenu20MouseClicked

    private void jMenu31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu31MouseClicked
        // TODO add your handling code here:
        ReaderDelete rd=new ReaderDelete();
        rd.show();
    }//GEN-LAST:event_jMenu31MouseClicked

    private void jMenu25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu25MouseClicked
        // TODO add your handling code here:
        while(true){
            String str=JOptionPane.showInputDialog(null,"请输入口令：\n","title",JOptionPane.PLAIN_MESSAGE,null,null,null).toString();
            if(str.equals("芝麻开门")){
                UserAdd us=new UserAdd();
                us.show();
                break;
            }
            else{
                 JOptionPane.showMessageDialog(null, "口令错误", ":(",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenu25MouseClicked

    private void jMenu26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu26MouseClicked
        // TODO add your handling code here:
        while(true){
            String str=JOptionPane.showInputDialog(null,"请输入口令：\n","title",JOptionPane.PLAIN_MESSAGE,null,null,null).toString();
            if(str.equals("芝麻开门")){

                UserDelete ud=new UserDelete();
                ud.show();
                 break;
            }
            else{
                 JOptionPane.showMessageDialog(null, "口令错误", ":(",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenu26MouseClicked

    private void jMenu28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu28MouseClicked
        // TODO add your handling code here:
        while(true){
            String str=JOptionPane.showInputDialog(null,"请输入口令：\n","title",JOptionPane.PLAIN_MESSAGE,null,null,null).toString();
            if(str.equals("芝麻开门")){
                UserSearch us=new UserSearch();
                us.show();
                break;
            }
            else{
                 JOptionPane.showMessageDialog(null, "口令错误", ":(",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenu28MouseClicked

    private void jMenu42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu42MouseClicked
        // TODO add your handling code here:
        ChangePassword cp=new ChangePassword(mName);
        cp.show();
    }//GEN-LAST:event_jMenu42MouseClicked

    private void jMenu36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu36MouseClicked
        // TODO add your handling code here:
        BookSearchByID bs=new BookSearchByID();
        bs.show();
    }//GEN-LAST:event_jMenu36MouseClicked

    private void jMenu35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu35MouseClicked
        // TODO add your handling code here:
        BookSearchByName bs=new BookSearchByName();
        bs.show();
    }//GEN-LAST:event_jMenu35MouseClicked

    private void jMenu37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu37MouseClicked
        // TODO add your handling code here:
        BookSearchByConcert bsc=new BookSearchByConcert();
        bsc.show();
    }//GEN-LAST:event_jMenu37MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        BookSearchByTypeName bstype=new BookSearchByTypeName();
        bstype.show();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu15MouseClicked
        // TODO add your handling code here:
        BookSearch bs=new BookSearch();
        bs.show();
    }//GEN-LAST:event_jMenu15MouseClicked

    private void jMenu16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu16MouseClicked
        // TODO add your handling code here:
        ReaderSearchAll rsa=new ReaderSearchAll();
        rsa.show();
        
    }//GEN-LAST:event_jMenu16MouseClicked

    private void jMenu39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu39MouseClicked
        // TODO add your handling code here:
        ReaderSearchByName rsbN=new ReaderSearchByName();
        rsbN.show();
    }//GEN-LAST:event_jMenu39MouseClicked

    private void jMenu40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu40MouseClicked
        // TODO add your handling code here:
        ReaderSearchByPhone rsbp=new ReaderSearchByPhone();
        rsbp.show();
    }//GEN-LAST:event_jMenu40MouseClicked

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        // TODO add your handling code here:
        ReaderSearchByType rsbt=new ReaderSearchByType();
        rsbt.show();
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu10MouseClicked
        // TODO add your handling code here:
        BookTypeSearchAll btsa=new BookTypeSearchAll();
        btsa.show();
    }//GEN-LAST:event_jMenu10MouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(mName).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu26;
    private javax.swing.JMenu jMenu28;
    private javax.swing.JMenu jMenu29;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu30;
    private javax.swing.JMenu jMenu31;
    private javax.swing.JMenu jMenu32;
    private javax.swing.JMenu jMenu33;
    private javax.swing.JMenu jMenu34;
    private javax.swing.JMenu jMenu35;
    private javax.swing.JMenu jMenu36;
    private javax.swing.JMenu jMenu37;
    private javax.swing.JMenu jMenu38;
    private javax.swing.JMenu jMenu39;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu40;
    private javax.swing.JMenu jMenu41;
    private javax.swing.JMenu jMenu42;
    private javax.swing.JMenu jMenu44;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}