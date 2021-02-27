/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.service;

import com.bookstenancy.dao.ReaderDao;
import com.bookstenancy.pojo.Reader;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 74080
 */
public class ReaderContorl {
    ReaderDao readerdao=new ReaderDao();
    /**
     * 添加读者信息
     * @param reader
     * @return
     * @throws SQLException 
     */
    public int AddReader(Reader reader) throws SQLException{
        return readerdao.AddReader(reader);
    }
    
    /**
     * 获得刚刚插入的读者的id
     * @return
     * @throws SQLException 
     */   
    public String GetReaderid() throws SQLException{
        return readerdao.GetReaderid();
    }
    
    
    /**
     * 通过读者编号查找读者姓名 
     * @param readerID  读者编号
     * @return 读者姓名
     * @throws SQLException 
     */
    public String SelectReaderNameById(String readerID) throws SQLException {
        return readerdao.SelectReaderNameById(readerID);
    }
    
    
    /**
     * 查找读者类型名称
     * @param readerID  读者id
     * @return 读者类型名称
     * @throws SQLException 
     */
    public String SelectReaderTypeNameById(String readerID)  throws SQLException{
        return readerdao.SelectReaderTypeNameById(readerID);
    }
    /**
     * 查找读者信息 
     * @param readerId 读者id
     * @return 读者信息 （姓名 手机号码  读者类型）
     * @throws SQLException 
     */
    public Reader SelectReaderInfoById(String readerId) throws SQLException{
        return readerdao.SelectReaderInfoById(readerId);
    }
    
    
    /**
     * 修改读者信息 
     * @param reader 读者信息 （姓名 电话号码 类型）
     * @return 返回是否成功
     * @throws SQLException 
     */
    public Boolean UpdateReaderInfo(Reader reader) throws SQLException{
        return readerdao.UpdateReaderInfo(reader);
    }
    
    
    /***
     * 假装删除掉读者
     * @param readerid
     * @return 是否已经删除
     * @throws SQLException 
     */
    public Boolean DeleteReaderInfo(String readerid) throws SQLException{
        return readerdao.DeleteReaderInfo(readerid);
    }
    
    /**
     * 获取所有的用户信息
     * @return
     * @throws SQLException 
     */
    public List<Reader>SelectAllReaderInfo() throws SQLException{
        return readerdao.SelectAllReaderInfo();
    }
    
    
     /**
     * 通过读者类型查看读者信息
     * @param typeName
     * @return 该类型的所有读者
     * @throws SQLException 
     */
    public List<Reader>SelectReaderByTypeName(String typeName) throws SQLException{
        return readerdao.SelectReaderByTypeName(typeName);
    }
    
     /**
     * 通过读者手机号码 查找读者
     * @param phone
     * @return
     * @throws SQLException 
     */
    public List<Reader>SelectReaderByPhoneNum(String phone) throws SQLException{
        return readerdao.SelectReaderByPhoneNum(phone);
    }
    
    
    /**
     * 按照姓名 模糊查找 读者信息 
     * @param readerName
     * @return 姓名中包含 readerName的读者信息
     * @throws SQLException 
     */
    public List<Reader>RoughSelectReaderByReaderName(String readerName) throws SQLException{
        return readerdao.RoughSelectReaderByReaderName(readerName);
    }
    
}
