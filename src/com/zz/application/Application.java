// <张圳>

/*
    本项目的主函数入口。
    项目背景：北理工计算机操作系统综合实验，自主命题，
    做了一个本地文件搜索小工具。
 * 
 */
package com.zz.application;

import com.zz.gui.GUI;

// TODO: Auto-generated Javadoc
/**
 * The Class Application. 项目的主函数入口所在类。
 */
public class Application {

    /**
     * The main method. 单例模式获取GUI类的一个实例（最简单的单例模式， 此处不用考虑多线程下的安全性）
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        GUI.getGUIInstance();
    }
}

// <张圳>