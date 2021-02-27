/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.pojo;

/**
 *
 * @author 74080
 */
public class Book {

    public String getDescribe() {
        return _describe;
    }

    public void setDescribe(String _describe) {
        this._describe = _describe;
    }
    
    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getConcern() {
        return _concern;
    }

    public void setConcern(String _concern) {
        this._concern = _concern;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String _author) {
        this._author = _author;
    }

    public int getTotality() {
        return _totality;
    }

    public void setTotality(int _totality) {
        this._totality = _totality;
    }

    public int getCurInv() {
        return _CurInv;
    }

    public void setCurInv(int _CurInv) {
        this._CurInv = _CurInv;
    }
    /**
     * 编号
     */    
    private String _id;
    /**
     * 类型id
     */
    private String  _type;
    /**
     * 姓名
     */
    private String _name;
    /**
     * 价格
     */
    private double price;
    /**
     * 出版社
     */
    private String  _concern; 
    /**
     * 作者
     */
    private String _author;
    /**
     * 原始库存
     */
    private int _totality;
    /**
     * 当前
     */
    private int _CurInv;
    /**
     * 描述
     */
    private String _describe;

  
}
