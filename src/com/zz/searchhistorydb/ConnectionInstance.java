// <张圳>

/*
    获取数据库连接实例，采用单例模式。
    数据库为MySQL。
 * 
 */
package com.zz.searchhistorydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionInstance.
 */
public class ConnectionInstance {

    /** The Constant USER. */
    private static final String USER = "root";

    /** The Constant PASSWORD. */
    private static final String PASSWORD = "123456";

    /** The Constant DB_NAME. */
    private static final String DB_NAME = "os_lab_file_search";

    /** The Constant CHARACTER_ENCODING. */
    private static final String CHARACTER_ENCODING = "characterEncoding=GBK";

    /** The Constant TIME_ZONE. */
    private static final String TIME_ZONE = "serverTimezone=GMT";

    /** The Constant SSL. */
    private static final String SSL = "useSSL=false";

    /** The Constant DRIVER_NAME. */
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    /** The Constant DB_URL. */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?" + CHARACTER_ENCODING + "&"
            + TIME_ZONE + "&" + SSL;

    /** The connection. */
    private static Connection connection;

    /**
     * Inits the connection.
     */
    public static void initConnection() {
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("连接出错！");
            e.printStackTrace();
        }
    }

    /**
     * Gets the conn instance.
     *
     * @return the conn instance
     */
    public static Connection getConnInstance() {
        if (connection == null) {
            initConnection();
        }
        return connection;
    }

}

// <张圳>