/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstenancy.util;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author 74080
 */
public class Tool {
    /***
     * 获取屏幕的宽度
     * @return 屏幕宽度
     */
    public static int GetScreensize_Width(){
        Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
        return (int)screensize.getWidth();
    }
    /***
     * 获取屏幕的高度
     * @return 屏幕的高度
     */
    public static int GetScreensize_Heigth(){
        Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
        return (int)screensize.getHeight();
    }
}
