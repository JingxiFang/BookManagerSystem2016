/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.dao;

import com.bookstenancy.pojo.BookType;
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
public class BookTypeDao {
    /**
     * 添加图书类型信息
     * @param booktype 图书类型
     * @return  是否成功
     */
    public Boolean AddBookTypeInfo(BookType booktype) throws SQLException{
        String strsql="insert into BookType values(?,?,?,1)";
        List<Object> pars=new ArrayList<Object>();
        pars.add(booktype.getName());
        pars.add(booktype.getTypeStartHireRule());
        pars.add(booktype.getTypeEndHireRule());
        return SqlHelper.Execute(strsql, pars);
    }
    
    /**
     * 通过id查找图书类型
     * @param typeId 类型id
     * @return 图书类型详情
     * @throws SQLException 
     */
    public BookType SelectBookTypeById(String typeId) throws SQLException{
        String strsql="select * from booktype where flag=1 and typeid=?";
        List<Object> params=new ArrayList<Object>();
        params.add(typeId);
        Map<String,Object> mapType=new HashMap<String ,Object>();
        mapType=SqlHelper.returnSimpleResult(strsql, params);
        if(mapType.size()>0){
            return GetBookType(mapType);
        }
        else{
        return null;
        }
        
       
    }
    
    
    
    
    
    /**
     * 修改图书类别信息
     * @param booktype 图书类别信息
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean UpdateBookTypeByTypeId(BookType booktype) throws SQLException{
        String strsql="update BookType set typename=?,typeStartHireRule=?,typeEndHireRule=? where typeid=?";
        List<Object> pars=new ArrayList<Object>();
        pars.add(booktype.getName());
        pars.add(booktype.getTypeStartHireRule());
        pars.add(booktype.getTypeEndHireRule());
        pars.add(booktype.getId());
        return SqlHelper.Execute(strsql, pars);
    }
    
    
    /**
     * 通过id查找图书类型名称
     * @param typeid 类型id
     * @return  图书类别名称
     */
    public String SelectBookTypeNameById(String typeid) throws SQLException{
        String strsql="select typename from booktype where flag=1 and typeid=?";
        List<Object> params=new ArrayList<Object>();
        params.add(typeid);
        Map<String,Object> map=new HashMap<String ,Object>();
        map=SqlHelper.returnSimpleResult(strsql, params);
        String typeName="";
        if(map.size()>0){
            typeName= map.get("typename").toString();
        }
        return typeName;
    }
    
    /**
     * 查看有多少该类型的图书
     * @param typeid
     * @return 
     */
    public int SelectBookCountById(String typeid) throws SQLException{
        String strsql="select count(*) as nums from book where flag=1 and bookType=?";
        List<Object> params=new ArrayList<Object>();
        params.add(typeid);
        Map<String,Object> map=new HashMap<String ,Object>();
        map=SqlHelper.returnSimpleResult(strsql, params);
        int count= Integer.parseInt(map.get("nums").toString());
        return count;
    }
    
    /**
     * 假装删除图书类型
     * @param typeid 图书类型id
     * @return 是否成功
     * @throws SQLException 
     */
    public boolean DeleteBookTypeByTypeId(String typeid) throws SQLException{
        String strsql="update BookType set flag=0 where typeid=?";
        List<Object> pars=new ArrayList<Object>();
        pars.add(typeid);
        return SqlHelper.Execute(strsql, pars);
    }
    
    /**
     * 查找所有的图书类型
     * @return
     * @throws SQLException 
     */
    public List<BookType>SelectAllBookInfo() throws SQLException{
        String strsql="select * from booktype  where flag=1";
        List<Map<String,Object>> listMap=new ArrayList<Map<String ,Object>>();
        List<BookType>  listBook=new ArrayList<BookType>();
        listMap=SqlHelper.returnMultipleResult(strsql, null);
        if(listMap.size()>0){
            for(int i=0;i<listMap.size();i++){
                
                listBook.add(GetBookType(listMap.get(i)));
            }
        }
        return listBook;
    } 

    /**
     * 获得图书类型详情
     * @param mapType
     * @return  图书类型详情（id，名称，前三天租金 ，以后租金）
     */
    private BookType GetBookType(Map<String, Object> mapType) {
        BookType booktype=new BookType();
        booktype.setId(Integer.parseInt( mapType.get("typeid").toString()));
        booktype.setName( mapType.get("typename").toString());
        booktype.setTypeStartHireRule(Double.valueOf(mapType.get("typeStartHireRule").toString()));
        booktype.setTypeEndHireRule(Double.valueOf(mapType.get("typeEndHireRule").toString()));
        return booktype;
    }
    
    
    
}
