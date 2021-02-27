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
public class ReaderType {
    //typeId, typeName, typePrivilege
    /**
     * 类型id
     */
    private int _id;
    /**
     * 类型名称
     */
    private String _name;
    /**
     * 类型特权
     */
    private double _privilege;

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

    public double getPrivilege() {
        return _privilege;
    }

    public void setPrivilege(double _privilege) {
        this._privilege = _privilege;
    }
}
