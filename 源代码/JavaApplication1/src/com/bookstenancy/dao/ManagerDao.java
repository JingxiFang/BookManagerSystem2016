/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.dao;

import com.bookstenancy.pojo.Manager;
import com.bookstenancy.util.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 74080
 */                                           
public class ManagerDao {
    /**
     * 通过用户名 获取用户密码
     * @param userName
     * @return
     * @throws SQLException 
     */
    public String UserPwd(String userName) throws SQLException{
        Map<String, Object> map = new HashMap<String, Object>();
        String strsql="select managerPWD from manager where managerName= ?";
        List<Object> pars = new ArrayList<Object>();
        pars.add(userName);
        map=SqlHelper.returnSimpleResult(strsql, pars);
        String pwd=map.get("managerPWD").toString();
        return pwd;
    }
    
    /**
     * 修改用户状态
     * @param uName 用户名
     * @param status  1 表示在线 0 表示不在线
     * @return 是否成功
     */
    public Boolean UpdateManagerStatus(String uName ,int status) throws SQLException{
        String strSql="update Manager set managerstate=? where managerName=? ";
        List<Object> list= new ArrayList<Object>();
        list.add(status);
        list.add(uName);
        return SqlHelper.Execute(strSql, list);        
    }
    
    /**
     * 添加管理员信息
     * @param manager 管理员信息
     * @return 事故成功
     * @throws SQLException 
     */
    public Boolean InsertManager(Manager manager) throws SQLException{
        String strSql="insert into Manager values(?,?,0)";
        List<Object> pars=new ArrayList<Object>();
        pars.add(manager.getManagerName());
        pars.add(manager.getManagerPWD());
        return SqlHelper.Execute(strSql, pars);       
    }
    
    /**
     * 假装删掉了用户 
     * @param managername 用户名
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean DaleteManager(String managername) throws SQLException{
        String strSql="update Manager set flag=0 where managerName=?";
        List<Object> pars=new ArrayList<Object>();
        pars.add(managername);
        return SqlHelper.Execute(strSql, pars);  
    }
    
    /**
     * 查看用户名是否存在
     * @param managername
     * @return 
     * @throws SQLException 
     */
    public int selectExictTheManagerByName(String managername) throws SQLException{
        String strSql="select count(*) as num from manager where flag=1 and  managerName=?";
        List<Object> pars=new ArrayList<Object>();
        pars.add(managername);
        Map<String, Object> map = new HashMap<String, Object>();
        map=SqlHelper.returnSimpleResult(strSql, pars);
        return Integer.parseInt( map.get("num").toString());
    }
    
    
    /**
     * 查看所有管理的用户名和在线状态
     * @return
     * @throws SQLException 
     */
    public List<Manager> selectAllManagerIdAndState() throws SQLException{
        String strSql="  select  managerName, managerState from manager where flag=1 ";
        List <Map<String, Object>> map = new ArrayList<Map<String, Object>>();
        map=SqlHelper.returnMultipleResult(strSql, null);
        List<Manager> listManager=new ArrayList<Manager>();
        for(int i=0;i<map.size();i++){
            Manager manager=new Manager();
            manager.setManagerName(map.get(i).get("managerName").toString());
            String stateid=map.get(i).get("managerState").toString();
            if(stateid.equals("0")){
                manager.setManagerState("不在岗");
            }
            else if(stateid.equals("1")){
                 manager.setManagerState("工作中");
            }
            listManager.add(manager);
        }
        return listManager;
    }
    
    /**
     * 修改密码
     * @param mName
     * @param mNewPwd
     * @return 是否成功
     * @throws SQLException 
     */
    public Boolean UpdatePwd(String mName,String mNewPwd) throws SQLException{
        String strSql="update manager set managerPwd=? where managerName=?";
        List<Object> pars=new ArrayList<Object>();
        pars.add(mNewPwd);
        pars.add(mName);
        return SqlHelper.Execute(strSql, pars);  
    }

}
