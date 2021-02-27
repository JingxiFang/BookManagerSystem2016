/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.util;


import java.util.List;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 74080
 */
public class SqlHelper {
    
    static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=BookStore_JAVA";//数据库URL
	static String UNAME = "sa";       //访问数据库的用户名
	static String UPWD = "fang147/*";    //访问数据库的密码
	private static Connection conn = null;
        //定义sql语句的执行对象
        private static PreparedStatement pStatement;
        //定义查询返回的结果集合
        private static ResultSet resultset;	
        
        /***
         * 连接数据库
         * @return 
         */
	private static Connection getConnection( ) {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,UNAME,UPWD);
			System.out.println("连接成功");
		} catch (Exception e) {
			System.out.println("【错误】连接数据库失败：" + e.getMessage( ));
			e.printStackTrace( );
		}
		return conn;
	}
        
        /**
         * 关闭数据库连接
         */
	private static void closeConnection( ) {
		try {
			if (conn != null)
				conn.close( );
			conn = null;
			
		} catch (Exception e) {
			System.out.println("【错误】数据库连接关闭失败：" + e.getMessage( ));
			e.printStackTrace( );
		}
	}
        
  /**
     * 完成对数据库的增删改操作
     * @param sql语句
     * @param 传入的占位符，List集合
     * @return SQL语句执行成功返回true,否则返回false
     * @throws SQLException
     */
    public static boolean Execute(String sql,List<Object>params) throws SQLException
    {
        int result = -1;//设置为
        conn=getConnection();
        pStatement = conn.prepareStatement(sql);  //填充占位符
        int index = 1; //从第一个开始添加
        if(params != null && !params.isEmpty())
        {
            for(int i = 0;i<params.size();i++)
            {
                pStatement.setObject(index++,params.get(i));//填充占位符
            }
        }
        result = pStatement.executeUpdate();//执行成功将返回大于0的数
        return  result>0 ? true : false;
    }
      
    public static int ExecuteGetID(String sql,List<Object>params) throws SQLException
    {
        int result = -1;//设置为
        conn=getConnection();
        pStatement  =  conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); ;  //填充占位符
        int index = 1; //从第一个开始添加
        if(params != null && !params.isEmpty())
        {
            for(int i = 0;i<params.size();i++)
            {
                pStatement.setObject(index++,params.get(i));//填充占位符
            }
        }
        result = pStatement.executeUpdate();//执行成功将返回大于0的数
        resultset=pStatement.getGeneratedKeys();
        int id=0;//保存生成的ID  
        if (resultset != null&&resultset.next()) {  
            id=resultset.getInt(1) ; 
        } 
        return  id;
    }    



   /**
    * 数据库查询操作，返回单条记录
     * @param sql
     * @param params
    * @param sql语句
    * @param 传入的占位符
    * @return 返回Map集合类型，包含查询的结果
    * @throws SQLException
    */
    public static Map<String,Object> returnSimpleResult(String sql,List<Object> params) throws SQLException 
    {
        Map<String, Object> map = new HashMap<String, Object>();
        int index = 1;//从1开始设置占位符
        conn=getConnection();
        pStatement = conn.prepareStatement(sql);
        if(params != null && !params.isEmpty()) /*判断参数是否为空*/
        { 
          for(int i = 0;i<params.size();i++) /*循环填充占位符*/
          {
                //System.out.println(conn);
                pStatement.setString(index++, params.get(i).toString());
          }
        }
        //resultset = pStatement.executeQuery(sql);
        resultset = pStatement.executeQuery();
        /*  将查询结果封装到map集合*/
        ResultSetMetaData metaDate = resultset.getMetaData();//获取resultSet列的信息
        int columnLength = metaDate.getColumnCount();//获得列的长度
        while(resultset.next())
        {
            for(int i = 0;i<columnLength;i++)
            {
                String metaDateKey = metaDate.getColumnName(i+1);//获得列名
                Object resultsetValue = resultset.getObject(metaDateKey);//通过列名获得值
                if(resultsetValue == null)
                {
                    resultsetValue = "";//转成String类型
                }
                map.put(metaDateKey, resultsetValue);//添加到map集合（以上代码是为了将从数据库返回的值转换成map的key和value）
            }
        }
        conn=getConnection();
        return map;
    }
    /**
     * 查询数据库，返回多条记录
     * @param sql
     * @param params
     * @param sql语句
     * @param 占位符
     * @return list集合，包含查询的结果
     * @throws SQLException 
     */
    public static List<Map<String,Object>> returnMultipleResult(String sql,List<Object> params) throws SQLException
    {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        //填充占位符
        int index = 1;
        pStatement = conn.prepareStatement(sql);
        if(params != null && !params.isEmpty())
        {
            for(int i = 0;i<params.size();i++)
            {
                pStatement.setObject(index++, params.get(i));
            }
        }
        //执行SQL语句
        resultset = pStatement.executeQuery();
        //封装resultset成map类型
        ResultSetMetaData metaDate = resultset.getMetaData();//获取列信息,交给metaDate
        int columnlength = metaDate.getColumnCount();
        while(resultset.next())
        {
            Map<String, Object> map = new HashMap<String, Object>();
            for(int i = 0;i<columnlength;i++)
            {
                String metaDateKey = metaDate.getColumnName(i+1);//获取列名
                Object resultsetValue = resultset.getObject(metaDateKey);
                if(resultsetValue == null)
                {
                    resultsetValue = "";
                }
                map.put(metaDateKey, resultsetValue);
            }
            list.add(map);
        }
        return list;
    }
   
    }
    
        
        
        


