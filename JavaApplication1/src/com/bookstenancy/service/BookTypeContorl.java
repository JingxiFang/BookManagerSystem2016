/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.service;

import com.bookstenancy.dao.BookTypeDao;
import com.bookstenancy.pojo.BookType;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 74080
 */
public class BookTypeContorl {
    BookTypeDao booktypedao=new BookTypeDao();
    
    /**
     * 添加图书类型信息
     * @param booktype 图书类型
     * @return  是否成功
     */
    public Boolean AddBookTypeInfo(BookType booktype) throws SQLException{
        return booktypedao.AddBookTypeInfo(booktype);
    }
    
    /**
     * 通过id查找图书类型
     * @param typeId 类型id
     * @return 图书类型详情
     * @throws SQLException 
     */
    public BookType SelectBookTypeById(String typeId) throws SQLException{
        return booktypedao.SelectBookTypeById(typeId);
    }
    
    /**
     * 修改图书类别信息
     * @param booktype 图书类别信息
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean UpdateBookTypeByTypeId(BookType booktype) throws SQLException{
        return booktypedao.UpdateBookTypeByTypeId(booktype);
    }
    
    /**
     * 通过id查找图书类型名称
     * @param typeid 类型id
     * @return  图书类别名称
     */
    public String SelectBookTypeNameById(String typeid) throws SQLException{
        return booktypedao.SelectBookTypeNameById(typeid);
    }
    
    /**
     * 查看有多少该类型的图书
     * @param typeid
     * @return 
     */
    public int SelectBookCountById(String typeid) throws SQLException{
        return booktypedao.SelectBookCountById(typeid);
    }
    
    /**
     * 假装删除图书类型
     * @param typeid 图书类型id
     * @return 是否成功
     * @throws SQLException 
     */
    public boolean DeleteBookTypeByTypeId(String typeid) throws SQLException{
        return booktypedao.DeleteBookTypeByTypeId(typeid);
    }
    
    
    /**
     * 查找所有的图书类型
     * @return
     * @throws SQLException 
     */
    public List<BookType>SelectAllBookInfo() throws SQLException{
        return booktypedao.SelectAllBookInfo();
    }
    
    
}
