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
public class Manager {
    private int _managerId;
    private String _managerName;
    private String _managerPWD;
    private String _managerState;

    public String getManagerState() {
        return _managerState;
    }

    public void setManagerState(String _managerState) {
        this._managerState = _managerState;
    }

    public int getManagerId() {
        return _managerId;
    }

    public void setManagerId(int _managerId) {
        this._managerId = _managerId;
    }

    public String getManagerName() {
        return _managerName;
    }

    public void setManagerName(String _managerName) {
        this._managerName = _managerName;
    }

    public String getManagerPWD() {
        return _managerPWD;
    }

    public void setManagerPWD(String _managerPWD) {
        this._managerPWD = _managerPWD;
    }
    
   
}
