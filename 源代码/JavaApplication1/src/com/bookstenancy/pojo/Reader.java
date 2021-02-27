/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.pojo;

import java.sql.Date;

/**
 *
 * @author 74080
 */
public class Reader {
    //readerId, readerName, readerType, readerPhone, readerAdderess
    /**
     * 编号
     */
    private int _id;
    /**
     * 姓名
     */
    private String _name;
    /**
     * 类型
     */
    private String _type;
    /**
     * 电话号码
     */
    private String _phone;
    /**
     * 地址
     */
    private String _address;
    
    /**
     * 注册时间
     */
    private String _resigterTime; 
    /**
     * 可借阅时间
     */
    private int _readDays;

    public int getReadDays() {
        return _readDays;
    }

    public void setReadDays(int _readDays) {
        this._readDays = _readDays;
    }
    public String getResigterTime() {
        return _resigterTime;
    }

    public void setResigterTime(String _resigterTime) {
        this._resigterTime = _resigterTime;
    }
 
    public int getId() {
        return _id;
    }

   
    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String _phone) {
        this._phone = _phone;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }
}
