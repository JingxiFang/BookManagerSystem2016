/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.service;

import com.bookstenancy.dao.ManagerDao;
import com.bookstenancy.pojo.Manager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 74080
 */
public class ManagerContorl {
    
    ManagerDao managerdao=new ManagerDao();
    
    /**
     * 通过用户名 获取用户密码
     * @param userName
     * @return
     * @throws SQLException 
     */
     public String UserPwd(String userName) throws SQLException{
         return managerdao.UserPwd(userName);
     }
     
     /**
     * 修改用户状态
     * @param uName 用户名
     * @param status  1 表示在线 0 表示不在线
     * @return 是否成功
     */
    public Boolean UpdateManagerStatus(String uName ,int status) throws SQLException{
        return managerdao.UpdateManagerStatus(uName, status);
    }
    
    /**
     * 添加管理员信息
     * @param manager 管理员信息
     * @return 事故成功
     * @throws SQLException 
     */
    public Boolean InsertManager(Manager manager) throws SQLException{
        return managerdao.InsertManager(manager);
    }
     
    
    /**
     * 假装删掉了用户 
     * @param managername 用户名
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean DaleteManager(String managername) throws SQLException{
        return managerdao.DaleteManager(managername);
    }
    
     /**
     * 查看用户名是否存在
     * @param managername
     * @return 
     * @throws SQLException 
     */
    public int selectExictTheManagerByName(String managername) throws SQLException{
        return managerdao.selectExictTheManagerByName(managername);
    }
    
    /**
     * 查看所有管理的用户名和在线状态
     * @return
     * @throws SQLException 
     */
    public List<Manager> selectAllManagerIdAndState() throws SQLException{
        return managerdao.selectAllManagerIdAndState();
    }
    
    /**
     * 修改密码
     * @param mName
     * @param mNewPwd
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean UpdatePwd(String mName,String mNewPwd) throws SQLException{
        return managerdao.UpdatePwd(mName, mNewPwd);
    }
     
}
