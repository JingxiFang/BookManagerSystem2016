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
public class BookType {
    //typeid, typename, typeHrieRule
    /**
     * 类型编号
     */
    private int _id;
    /**
     * 类型名称
     */
    private String _name;
    
    /**
     * 前三天的租金
     */
    private double _typeStartHireRule;
    /**
     * 三天后的租金
     */
    private double _typeEndHireRule;

    public double getTypeStartHireRule() {
        return _typeStartHireRule;
    }

    public void setTypeStartHireRule(double _typeStartHireRule) {
        this._typeStartHireRule = _typeStartHireRule;
    }

    public double getTypeEndHireRule() {
        return _typeEndHireRule;
    }

    public void setTypeEndHireRule(double _typeEndHireRule) {
        this._typeEndHireRule = _typeEndHireRule;
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


}
