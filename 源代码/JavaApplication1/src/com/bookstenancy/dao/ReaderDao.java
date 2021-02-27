/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.dao;

import com.bookstenancy.pojo.Reader;
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
public class ReaderDao {
    /**
     * 添加读者信息
     * @param reader
     * @return
     * @throws SQLException 
     */
    public int AddReader(Reader reader) throws SQLException{
        String strSql="insert into Reader(readerName,readerType,readerPhone,resigterTime,flag) values(?,(select typeid from readerType where typename=?),?,GETDATE(),1)" ;
        List<Object> pars = new ArrayList<Object>();
        int readerID=0;
        pars.add(reader.getName());
        pars.add(reader.getType());
        pars.add(reader.getPhone());
        readerID=SqlHelper.ExecuteGetID(strSql, pars);
         
        return readerID;
        
    }
    /**
     * 获得刚刚插入的读者的id
     * @return
     * @throws SQLException 
     */   
    public String GetReaderid() throws SQLException{
        String strsql="select @@identity as id";
        List<Object> pars = new ArrayList<Object>();
         Map<String, Object> map = new HashMap<String, Object>();
        map=SqlHelper.returnSimpleResult(strsql, pars);
        return map.get("id").toString();
    }
    
    /**
     * 通过读者编号查找读者姓名 
     * @param readerID  读者编号
     * @return 读者姓名
     * @throws SQLException 
     */
    public String SelectReaderNameById(String readerID) throws SQLException {
        String strsql="select readerName from reader where flag=1 and readerId = ?";
        List<Object> pars = new ArrayList<Object>();
        Map<String, Object> map = new HashMap<String, Object>();
        pars.add(readerID);
        map=SqlHelper.returnSimpleResult(strsql, pars);
        String ReaderName="";
        if(map.size()>0){
            ReaderName=map.get("readerName").toString();
        }
        return ReaderName;
    }

    
    /**
     * 查找读者类型名称
     * @param readerID  读者id
     * @return 读者类型名称
     * @throws SQLException 
     */
    public String SelectReaderTypeNameById(String readerID)  throws SQLException{
        String strsql="select rt.typeName from reader inner join readerType rt on rt.typeId=reader.readerid where flag=1 and readerId = ?";
        List<Object> pars = new ArrayList<Object>();
        Map<String, Object> map = new HashMap<String, Object>();
        pars.add(readerID);
        map=SqlHelper.returnSimpleResult(strsql, pars);
        String typeName="";
        if(map.size()>0){
            typeName=map.get("typeName").toString();
        }
        return typeName;
    }
    
    /**
     * 查找读者信息 
     * @param readerId 读者id
     * @return 读者信息 （姓名 手机号码  读者类型）
     * @throws SQLException 
     */
    public Reader SelectReaderInfoById(String readerId) throws SQLException{
        String strsql="select * from reader inner join readerType rt on rt.typeId=reader.readerType where flag=1 and readerId = ?";
        List<Object> pars = new ArrayList<Object>();
        pars.add(readerId);
        Map<String, Object> map = new HashMap<String, Object>();
        map=SqlHelper.returnSimpleResult(strsql, pars);
        Reader reader=new Reader();
        if(map.size()>0){
            reader=getReader(map);
        }
        return reader;
    }
    
    
    /**
     * 修改读者信息 
     * @param reader 读者信息 （姓名 电话号码 类型）
     * @return 返回是否成功
     * @throws SQLException 
     */
    public Boolean UpdateReaderInfo(Reader reader) throws SQLException{
        String strsql="update reader set readerName=?,readerPhone=?,readerType=(select typeId from ReaderType where typeName=?) where readerId=?";
        List<Object> pars=new ArrayList<Object>();
        pars.add(reader.getName());
        pars.add(reader.getPhone());
        pars.add(reader.getType());
        pars.add(reader.getId());
        return SqlHelper.Execute(strsql, pars);
    }
    
    
    /***
     * 假装删除掉读者
     * @param readerid
     * @return 是否已经删除
     * @throws SQLException 
     */
    public Boolean DeleteReaderInfo(String readerid) throws SQLException{
        String strsql="update reader set flag=0 where readerid=?";
        List<Object> pars=new ArrayList<Object>();
        pars.add(readerid);
        return SqlHelper.Execute(strsql, pars);
    }
    
    /**
     * 获取所有的用户信息
     * @return
     * @throws SQLException 
     */
    public List<Reader>SelectAllReaderInfo() throws SQLException{
        String strsql=" select * from reader inner join readerType rt on rt.typeId=reader.readerType where flag=1 ";
        List<Map<String,Object>> listMap=new ArrayList<Map<String ,Object>>();
        List<Reader>  listReader=new ArrayList<Reader>();
        listMap=SqlHelper.returnMultipleResult(strsql, null);
        if(listMap.size()>0){
            for(int i=0;i<listMap.size();i++){
                Reader reader=new Reader();
                reader=getReader(listMap.get(i));
                listReader.add(reader);
            }
        }
        return listReader;
    } 

    /**
     * 获取读者信息
     * @param map
     * @return 
     */ 
    private Reader getReader(Map<String, Object> map) {
        Reader reader=new Reader();
        reader.setId(Integer.parseInt(map.get("readerId").toString()));
        reader.setName(map.get("readerName").toString());
        reader.setPhone(map.get("readerPhone").toString());
        reader.setType(map.get("typeName").toString());
        reader.setResigterTime(map.get("ResigterTime").toString());
        return reader;
    }
    
    /**
     * 通过读者类型查看读者信息
     * @param typeName
     * @return 该类型的所有读者
     * @throws SQLException 
     */
    public List<Reader>SelectReaderByTypeName(String typeName) throws SQLException{
        String strsql="  select * from reader inner join readerType rt on rt.typeId=reader.readerType where flag=1 and typeName =?";
        List<Object> pars=new ArrayList<Object>();
        pars.add(typeName);
        List<Map<String,Object>> listMap=new ArrayList<Map<String ,Object>>();
        List<Reader>  listReader=new ArrayList<Reader>();
        listMap=SqlHelper.returnMultipleResult(strsql, pars);
        if(listMap.size()>0){
            for(int i=0;i<listMap.size();i++){
                Reader reader=new Reader();
                reader=getReader(listMap.get(i));
                listReader.add(reader);
            }
        }
        return listReader;
    } 

    /**
     * 通过读者手机号码 查找读者
     * @param phone
     * @return
     * @throws SQLException 
     */
    public List<Reader>SelectReaderByPhoneNum(String phone) throws SQLException{
        String strsql="  select * from reader inner join readerType rt on rt.typeId=reader.readerType where flag=1 and readerPhone =?";
        List<Object> pars=new ArrayList<Object>();
        pars.add(phone);
        List<Map<String,Object>> listMap=new ArrayList<Map<String ,Object>>();
        List<Reader>  listReader=new ArrayList<Reader>();
        listMap=SqlHelper.returnMultipleResult(strsql, pars);
        if(listMap.size()>0){
            for(int i=0;i<listMap.size();i++){
                Reader reader=new Reader();
                reader=getReader(listMap.get(i));
                listReader.add(reader);
            }
        }
        return listReader;
    } 

    
    
    /**
     * 按照姓名 模糊查找 读者信息 
     * @param readerName
     * @return 姓名中包含 readerName的读者信息
     * @throws SQLException 
     */
    public List<Reader>RoughSelectReaderByReaderName(String readerName) throws SQLException{
        String strsql="  select * from reader inner join readerType rt on rt.typeId=reader.readerType where flag=1 and readerName like '%"+readerName+"%'";
        List<Map<String,Object>> listMap=new ArrayList<Map<String ,Object>>();
        List<Reader>  listReader=new ArrayList<Reader>();
        listMap=SqlHelper.returnMultipleResult(strsql, null);
        if(listMap.size()>0){
            for(int i=0;i<listMap.size();i++){
                Reader reader=new Reader();
                reader=getReader(listMap.get(i));
                listReader.add(reader);
            }
        }
        return listReader;
    } 
      
}
