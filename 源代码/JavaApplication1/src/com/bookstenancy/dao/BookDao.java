/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.dao;

import com.bookstenancy.pojo.Book;
import com.bookstenancy.util.SqlHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 74080
 */
public class BookDao {
    
    /**
     * 添加新书
     * @param book
     * @return 是否添加成功
     * @throws SQLException 
     */
    public Boolean AddBook(Book book) throws SQLException{
        String strSql="insert into Book values((select typeid from BookType where typename=?),?,?,?,?,?,?,?,1)" ;
        List<Object> pars = new ArrayList<Object>();
        //pars.add(book.getId());
        pars.add(book.getType());
        pars.add(book.getName());
        pars.add(book.getPrice());
        pars.add(book.getConcern());
        pars.add(book.getAuthor());
        pars.add(book.getTotality());
        pars.add(book.getCurInv());
        pars.add(book.getDescribe());
        return SqlHelper.Execute(strSql, pars);

    }
    
    /**
     * 通过用户输入的图书id查找图书姓名
     * @param bookId
     * @return  图书名称 
     * @throws java.sql.SQLException
     */
    public String SelectBookNameById(String bookId) throws SQLException{
        String strsql="select bookName from book where flag=1 and Id=?";
        List<Object> pars = new ArrayList<Object>();
        Map<String, Object> map = new HashMap<String, Object>();
        pars.add(bookId);
        map=SqlHelper.returnSimpleResult(strsql, pars);
        String bookName="";
        if(map.size()>0){
            bookName=map.get("bookName").toString();
        }
        return bookName;
    }
    
    
    /**
     * 通过图书id查找图书的详细信息
     * @param bookId
     * @return
     * @throws SQLException 
     */
    public Book  SelectBookById(String bookId) throws SQLException{
        String strsql="select * from book inner join  BookType bt on bt.typeid=Book.bookType where Book.flag=1 and Book.Id=?";
        List<Object> pars = new ArrayList<Object>();
         pars.add(bookId);
        Map<String, Object> map = new HashMap<String, Object>();
        Book book=new Book();
        map=SqlHelper.returnSimpleResult(strsql, pars);
        if(map.size()>0){
            book=getBook(map);
        }
        else{
            book=null;
        }
         return book;
    }
    
    /**
     * 获取图书对象
     * @param map 
     * @return 
     */
    private Book getBook(Map<String,Object>  map ){
        Book book=new Book();
        book.setId(map.get("Id").toString());
        book.setName(map.get("bookName").toString());
        book.setAuthor(map.get("bookAuthor").toString());
        book.setConcern(map.get("bookConcern").toString());
        book.setPrice(Double.parseDouble(map.get("bookPrice").toString()) );
        book.setDescribe(map.get("Describe").toString());
        book.setTotality(Integer.parseInt(map.get("bookTotality").toString()));
        book.setType(map.get("typename").toString());
        book.setCurInv(Integer.parseInt(map.get("bookCurInv").toString()));
        return book;
    }
             
    
    /**
     * 通过id 假装删除图书 
     * @param bookId
     * @return
     * @throws SQLException 
     */
    public Boolean DeleteBookById(String bookId) throws SQLException{
        String strsql="update book set flag=0 where id=?";
        List<Object> pars = new ArrayList<Object>();
        pars.add(bookId);
        return SqlHelper.Execute(strsql, pars);
    }
    
    /**
     * 修改图书信息
     * @param book
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean UpdateBookInfoById(Book book) throws SQLException{
        String strsql ="update book set bookType=(select typeid from booktype where typename=?),bookName=?,bookPrice=?,bookConcern=?,bookAuthor=?,bookTotality=?,Describe=? where id=?";
         List<Object> pars = new ArrayList<Object>();
        //pars.add(book.getId());
        pars.add(book.getType());
        pars.add(book.getName());
        pars.add(book.getPrice());
        pars.add(book.getConcern());
        pars.add(book.getAuthor());
        pars.add(book.getTotality());
       
        pars.add(book.getDescribe());
        pars.add(book.getId());
        return SqlHelper.Execute(strsql, pars);
        
    }
    
    /**
     * 更改图书的当前库存
     * @param bookid
     * @return
     * @throws SQLException 
     */
    public Boolean UpdateBookCurInv(String bookid) throws SQLException{
        String strsql="update book set bookcurinv=bookcurinv-1 where id=?";
        List<Object> pars = new ArrayList<Object>();
        pars.add(bookid);
        return SqlHelper.Execute(strsql, pars);
    }
    
    /**
     * 通过图书名称获取图书集合
     * @param bookName
     * @return 图书详细信息集合
     * @throws SQLException 
     */
    public List<Book> RoughtSelectBookByName(String bookName) throws SQLException{
        String strsql="select * from book inner join booktype on Book.bookType=bookType.typeid where book.flag=1  and bookName like '%"+bookName+"%'";
        List<Map<String,Object>> listMap=new ArrayList<Map<String ,Object>>();
        List<Book>  listBook=new ArrayList<Book>();
        listMap=SqlHelper.returnMultipleResult(strsql, null);
        if(listMap.size()>0){
            for(int i=0;i<listMap.size();i++){
                Book book=new Book();
                book=getBook(listMap.get(i));
                listBook.add(book);
            }
        }
        return listBook;
    }
    
    /**
     * 通过出版社名称查找图书详细信息
     * @param bookConcern
     * @return
     * @throws SQLException 
     */
    public List<Book>SelectBookByConcern(String bookConcern) throws SQLException{
        String strsql="select * from book inner join booktype on Book.bookType=bookType.typeid where book.flag=1  and bookConcern=?";
        List<Object> pars = new ArrayList<Object>();
        pars.add(bookConcern);
        List<Map<String,Object>> listMap=new ArrayList<Map<String ,Object>>();
        List<Book>  listBook=new ArrayList<Book>();
        listMap=SqlHelper.returnMultipleResult(strsql, pars);
        if(listMap.size()>0){
            for(int i=0;i<listMap.size();i++){
                Book book=new Book();
                book=getBook(listMap.get(i));
                listBook.add(book);
            }
        }
        return listBook;
    }
    
    
    /**
     * 通过图书类型查看图书信息
     * @param bookTypeName
     * @return
     * @throws SQLException 
     */ 
    public List<Book>SelectBookByTypeName(String bookTypeName) throws SQLException{
        String strsql="select * from book inner join booktype on Book.bookType=bookType.typeid where book.flag=1  and typename=?";
        List<Object> pars = new ArrayList<Object>();
        pars.add(bookTypeName);
        List<Map<String,Object>> listMap=new ArrayList<Map<String ,Object>>();
        List<Book>  listBook=new ArrayList<Book>();
        listMap=SqlHelper.returnMultipleResult(strsql, pars);
        if(listMap.size()>0){
            for(int i=0;i<listMap.size();i++){
                Book book=new Book();
                book=getBook(listMap.get(i));
                listBook.add(book);
            }
        }
        return listBook;
    }
     
    /**
     * 查找所有的图书信息
     * @return
     * @throws SQLException 
     */
    public List<Book>SelectAllBookInfo() throws SQLException{
        String strsql="select * from book inner join booktype on Book.bookType=bookType.typeid where book.flag=1";
        List<Map<String,Object>> listMap=new ArrayList<Map<String ,Object>>();
        List<Book>  listBook=new ArrayList<Book>();
        listMap=SqlHelper.returnMultipleResult(strsql, null);
        if(listMap.size()>0){
            for(int i=0;i<listMap.size();i++){
                Book book=new Book();
                book=getBook(listMap.get(i));
                listBook.add(book);
            }
        }
        return listBook;
    } 
     
     
}
