/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.service;

import com.bookstenancy.dao.BookDao;
import com.bookstenancy.pojo.Book;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 *
 * @author 74080
 */
public class BookContorl {
    BookDao bookdao=new BookDao();
    /**
     * 添加新书
     * @param book
     * @return 是否添加成功
     * @throws SQLException 
     */
    public Boolean AddBook(Book book) throws SQLException{
        return bookdao.AddBook(book);
    }
    
    /**
     * 通过用户输入的图书id查找图书姓名
     * @param bookId
     * @return  图书名称 
     * @throws java.sql.SQLException
     */
    public String SelectBookNameById(String bookId) throws SQLException{
        return bookdao.SelectBookNameById(bookId);
    }
    
    /**
     * 通过图书id查找图书的详细信息
     * @param bookId
     * @return
     * @throws SQLException 
     */
    public Book  SelectBookById(String bookId) throws SQLException{
         return bookdao.SelectBookById(bookId);
    }
    
    
    /**
     * 通过id 假装删除图书 
     * @param bookId
     * @return
     * @throws SQLException 
     */
    public Boolean DeleteBookById(String bookId) throws SQLException{
        return bookdao.DeleteBookById(bookId);
    }
    
    
    /**
     * 修改图书信息
     * @param book
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean UpdateBookInfoById(Book book) throws SQLException{
        return bookdao.UpdateBookInfoById(book);
    }
    
    
    /**
     * 更改图书的当前库存
     * @param bookid
     * @return
     * @throws SQLException 
     */
    public Boolean UpdateBookCurInv(String bookid) throws SQLException{
        return bookdao.UpdateBookCurInv(bookid);
    }
    
    /**
     * 通过图书名称获取图书集合
     * @param bookName
     * @return 图书详细信息集合
     * @throws SQLException 
     */
    public List<Book> RoughtSelectBookByName(String bookName) throws SQLException{
        return bookdao.RoughtSelectBookByName(bookName);
    }
    
    /**
     * 通过出版社名称查找图书详细信息
     * @param bookConcern
     * @return
     * @throws SQLException 
     */
    public List<Book>SelectBookByConcern(String bookConcern) throws SQLException{
        return bookdao.SelectBookByConcern(bookConcern);
    }
    
    /**
     * 通过图书类型查看图书信息
     * @param bookTypeName
     * @return
     * @throws SQLException 
     */ 
    public List<Book>SelectBookByTypeName(String bookTypeName) throws SQLException{
        return bookdao.SelectBookByTypeName(bookTypeName);
    }
    
    
    /**
     * 查找所有的图书信息
     * @return
     * @throws SQLException 
     */
    public List<Book>SelectAllBookInfo() throws SQLException{
        return bookdao.SelectAllBookInfo();
    }
}
    
