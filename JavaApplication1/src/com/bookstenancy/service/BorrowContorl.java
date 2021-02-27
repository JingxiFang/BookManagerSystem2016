/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.service;

import com.bookstenancy.dao.BorrowDao;
import com.bookstenancy.pojo.Borrow;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 74080
 */
public class BorrowContorl {
    BorrowDao borrowdao=new BorrowDao();
    /**
     * 添加借阅信息
     * @param borrow
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean AddBorrow(Borrow borrow ) throws SQLException{
        return borrowdao.AddBorrow(borrow);
    }
    /**
     * 通过读者id和状态id查找借阅信息
     * @param readid 读者id
     * @param statusid 状态id
     * @return 借阅信息  
     */
    public List<Borrow> SelectBorrowByReaderIdandStatusid(String readid,String statusid ) throws SQLException{
        return borrowdao.SelectBorrowByReaderIdandStatusid(readid, statusid);
    }
    
     /**
     * 修改借阅记录 
     * @param borrowId
     * @return
     * @throws SQLException 
     */
    public Boolean UpdaeBorrow(String borrowId,String statusId ) throws SQLException{
        return borrowdao.UpdaeBorrow(borrowId, statusId);
    }
    
    /**
     * 根据图书编号查找借阅信息 
     * @param bookid 图书编号
     * @return 借阅信息 （读者id 读者姓名 借阅时间 状态）
     * @throws SQLException 
     */
    public List<Borrow> SelectBorrowByBookID (String bookid) throws SQLException{
        return borrowdao.SelectBorrowByBookID(bookid);
    }
    
    
    /**
     * 通过读者id获取该读者的借阅信息
     * @param readerId
     * @return
     * @throws SQLException 
     */
     public List<Borrow> SelectBorrowByReaderID(String readerId) throws SQLException{
         return borrowdao.SelectBorrowByReaderID(readerId);
     }
     
     /**
       * 获取单本数的租金
       * @param borrowId 借阅id
       * @return 
       * @throws SQLException 
       */
    public double getAccount(int borrowId) throws SQLException{
        return borrowdao.getAccount(borrowId);
    }
    
}
