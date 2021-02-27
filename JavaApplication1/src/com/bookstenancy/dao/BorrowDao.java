/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.dao;

import com.bookstenancy.pojo.Borrow;
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
public class BorrowDao {
    /**
     * 添加借阅信息
     * @param borrow
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean AddBorrow(Borrow borrow ) throws SQLException{
           String strsql="insert into Reader_Book_Status(readerId, bookId, statusId, starDay) values(?,?,1,GETDATE())";
           List<Object> pars = new ArrayList<Object>();
           pars.add(borrow.getReaderId()); 
           pars.add(borrow.getBookId());
           return SqlHelper.Execute(strsql, pars);
   }
    /**
     * 通过读者id和状态id查找借阅信息
     * @param readid 读者id
     * @param statusid 状态id
     * @return 借阅信息  
     */
    public List<Borrow> SelectBorrowByReaderIdandStatusid(String readid,String statusid ) throws SQLException{
        String strsql="exec SelectReaderBorrowBook  ?,?";
        //放参数
        List<Object> pars = new ArrayList<Object>();
        pars.add(statusid);
        pars.add(readid);
        //用于放借阅信息
        List<Borrow> listBorrow=new ArrayList<Borrow>();
        //放数据层返回的数据
        List<Map<String,Object>> listSql=new ArrayList<Map<String,Object>>();
        listSql=SqlHelper.returnMultipleResult(strsql, pars);
        if(listSql.size()>0) {
            for (int i=0;i<listSql.size();i++){
                Borrow borrow =new Borrow();
                borrow.setId(Integer.parseInt(listSql.get(i).get("id").toString()));
                borrow.setBookId(Integer.parseInt(listSql.get(i).get("Id").toString()));
                borrow.setBookName(listSql.get(i).get("bookName").toString());
                borrow.setStarDay(listSql.get(i).get("starDay").toString());
                borrow.setAccount(getAccount(borrow.getId())) ;
                listBorrow.add(borrow);
            }
        }
        return listBorrow;        
    }
    /**
     * 修改借阅记录 
     * @param borrowId
     * @return
     * @throws SQLException 
     */
    public Boolean UpdaeBorrow(String borrowId,String statusId ) throws SQLException{
        String strsql="update Reader_Book_Status set endday=GetDate(), statusid=? where id= ?";
        List<Object> pars = new ArrayList<Object>();   
        pars.add(statusId);
        pars.add(borrowId);
        return  SqlHelper.Execute(strsql, pars);
    }
    
    /**
     * 根据图书编号查找借阅信息 
     * @param bookid 图书编号
     * @return 借阅信息 （读者id 读者姓名 借阅时间 状态）
     * @throws SQLException 
     */
    public List<Borrow> SelectBorrowByBookID (String bookid) throws SQLException{
        String strsql="exec SelectBorrowByBookID ? ";
        List<Object> pars = new ArrayList<Object>();
        pars.add(bookid);
        //放数据层返回的数据
        List<Map<String,Object>> listSql=new ArrayList<Map<String,Object>>();
        listSql=SqlHelper.returnMultipleResult(strsql, pars);
        return GetBorrowByBook(listSql);
    }
    
    /**
     * 以图书为依据获得记录对象 
     * @param listSql
     * @return  借阅信息 （读者id 读者姓名 借阅时间 状态）
     */
    private List<Borrow> GetBorrowByBook(List<Map<String,Object>> listSql) throws SQLException{
        List<Borrow> listBorrow=new ArrayList<Borrow>();
        if(listSql.size()>0) {
            for (int i=0;i<listSql.size();i++){
                Borrow borrow =new Borrow();
                borrow.setId(Integer.parseInt(listSql.get(i).get("borrowId").toString()));
                borrow.setReaderId(Integer.parseInt(listSql.get(i).get("readerId").toString()));
                borrow.setStarDay(listSql.get(i).get("starDay").toString());
                borrow.setReaderName(listSql.get(i).get("readerName").toString());
                borrow.setStatusName(listSql.get(i).get("statusName").toString());
                borrow.setAccount(getAccount(borrow.getId())) ;
                listBorrow.add(borrow);
            }
        }
        return listBorrow;     
    }
 
    
    
    /**
     * 通过读者id获取该读者的借阅信息
     * @param readerId
     * @return
     * @throws SQLException 
     */
     public List<Borrow> SelectBorrowByReaderID(String readerId) throws SQLException{
      String strsql="exec SelectBorrowByReaderID ? ";
        List<Object> pars = new ArrayList<Object>();
        pars.add(readerId);
        //放数据层返回的数据
        List<Map<String,Object>> listSql=new ArrayList<Map<String,Object>>();
        listSql=SqlHelper.returnMultipleResult(strsql, pars);
        return GetBorrowByReader(listSql);
     }
    
     /**
      * 以读者为依据获取借阅信息
      * @param listSql
      * @return 借阅信息 （图书id 图书姓名 借阅时间 状态）
      */
      private List<Borrow> GetBorrowByReader(List<Map<String,Object>> listSql) throws SQLException{
        List<Borrow> listBorrow=new ArrayList<Borrow>();
        if(listSql.size()>0) {
            for (int i=0;i<listSql.size();i++){
                Borrow borrow =new Borrow();
                borrow.setId(Integer.parseInt(listSql.get(i).get("borrowId").toString()));
                borrow.setBookId(Integer.parseInt(listSql.get(i).get("Id").toString()));
                borrow.setStarDay(listSql.get(i).get("starDay").toString());
                borrow.setBookName(listSql.get(i).get("bookName").toString());
                borrow.setStatusName(listSql.get(i).get("statusName").toString());
                borrow.setAccount(getAccount(borrow.getId())) ;
                listBorrow.add(borrow);
            }
        }
        return listBorrow;     
    }
    
      /**
       * 获取单本数的租金
       * @param borrowId 借阅id
       * @return 
       * @throws SQLException 
       */
    public double getAccount(int borrowId) throws SQLException{
        //获取这本书的开始日期和今日天数差 n    租赁前三天租金 后三天租金
        String strsql="exec SelectReaderDaysAndHirele ?";
        List<Object> pars = new ArrayList<Object>();
        pars.add(borrowId);
        Map<String,Object> map=new HashMap<String,Object>();
        map=SqlHelper.returnSimpleResult(strsql, pars);
        double typeEndHireRule=Double.valueOf( map.get("typeEndHireRule").toString());
        double typeStartHireRule=Double.valueOf( map.get("typeStartHireRule").toString());
        int readDays=Integer.parseInt(map.get("days").toString());
        double typePrivilege=Double.valueOf( map.get("typePrivilege").toString());
        if(readDays>3){
            //3*开始三天+（n-3）*后边天数
            return ((readDays-3)*typeEndHireRule+3*typeStartHireRule)*typePrivilege;
        }
        else{
            return (readDays*typeStartHireRule)*typePrivilege;
        }
    
    } 
    
}
