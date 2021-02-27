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
public class Borrow {
    //id, readerId, bookId, statusId
    /**
     * 借阅id
     */
    private int _id;
    /**
     * 读者id
     */
    private int _readerId;
    /**
     * 读者名称
     */
    private String _readerName;
    /**
     * 借阅状态名称
     */
    private String _statusName;
    /**
     * 该次租金
     */
private double _account;

    public double getAccount() {
        return _account;
    }

    public void setAccount(double _account) {
        this._account = _account;
    }
    
    public String getReaderName() {
        return _readerName;
    }

    public void setReaderName(String _readerName) {
        this._readerName = _readerName;
    }

    public String getStatusName() {
        return _statusName;
    }

    public void setStatusName(String _statusName) {
        this._statusName = _statusName;
    }

    public String getBookName() {
        return _bookName;
    }

    public void setBookName(String _bookName) {
        this._bookName = _bookName;
    }
    /**
     * 图书名称
     */
    private String _bookName;
    /*
     * 图书id 数据库中的id
     */
    private int _bookId;
    /**
     * 状态
     */
    private int _statusId;
    /**
     * 借阅时间
     */
    private String _starDay;
    /**
     * 归还时间
     */
    private String _endDay;
    
    public String getStarDay() {
        return _starDay;
    }

    public void setStarDay(String _starDay) {
        this._starDay = _starDay;
    }

    public String getEndDay() {
        return _endDay;
    }

    public void setEndDay(String _endDay) {
        this._endDay = _endDay;
    }
   
    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getReaderId() {
        return _readerId;
    }

    public void setReaderId(int _readerId) {
        this._readerId = _readerId;
    }

    public int getBookId() {
        return _bookId;
    }

    public void setBookId(int _bookId) {
        this._bookId = _bookId;
    }

    public int getStatusId() {
        return _statusId;
    }

    public void setStatusId(int _statusId) {
        this._statusId = _statusId;
    }
    
}
