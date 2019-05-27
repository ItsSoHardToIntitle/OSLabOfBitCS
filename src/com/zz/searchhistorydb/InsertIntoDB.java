// <张圳>

/*
    进行数据库的插入操作，主要包含：
    1. 用户的搜索记录（序号，时间，输入关键字，搜索模式）
    2. 每次以图表可视化时的更加细致的展示（序号，类别，对于数量）
 * 
 */
package com.zz.searchhistorydb;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.zz.resultvisual.ResultVisual;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertIntoDB.
 */
public class InsertIntoDB {

    /** The simple date format. */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    /** The Constant SEARCH_HISTORY_TB. */
    private static final String SEARCH_HISTORY_TB = "search_history (time,search_keyword,search_mode)";

    /** The Constant SPECIFIC_KIND. */
    private static final String SPECIFIC_KIND = "specific_kind (each_kind,number)";

    /** The Constant KINDS. */
    private static final String KINDS = "kinds (each_kind,number)";

    /** The search history sql. */
    private static String searchHistorySql = "insert into " + SEARCH_HISTORY_TB + " values(?,?,?)";

    /** The specific kind sql. */
    private static String specificKindSql = "insert into " + SPECIFIC_KIND + " values(?,?)";

    /** The kinds sql. */
    private static String kindsSql = "insert into " + KINDS + " values(?,?)";

    /** The conn. */
    private static Connection conn = ConnectionInstance.getConnInstance();

    /** The prepared statement. */
    private static PreparedStatement preparedStatement = null;

    /**
     * Insert into history tb.
     *
     * @param time
     *            the time
     * @param searchKeyWord
     *            the search key word
     * @param searchMode
     *            the search mode
     */
    public static void insertIntoHistoryTb(long time, String searchKeyWord, String searchMode) {
        try {
            preparedStatement = conn.prepareStatement(searchHistorySql);
            preparedStatement.setString(1, simpleDateFormat.format(time));
            preparedStatement.setString(2, searchKeyWord);
            preparedStatement.setString(3, searchMode);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Intsert into visual res.
     */
    public static void intsertIntoVisualRes() {
        List<Map.Entry<String, Integer>> specificKind = ResultVisual.getSpecificKindList();
        List<Map.Entry<String, Integer>> kinds = ResultVisual.getKindList();
        Iterator<Map.Entry<String, Integer>> iterator = specificKind == null ? null : specificKind.iterator();
        Iterator<Map.Entry<String, Integer>> iterator2 = kinds == null ? null : kinds.iterator();
        try {
            if (specificKind != null) {
                while (iterator.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator.next();
                    preparedStatement = conn.prepareStatement(specificKindSql);
                    preparedStatement.setString(1, entry.getKey());
                    preparedStatement.setInt(2, entry.getValue());
                    preparedStatement.execute();
                }
            }
            if (kinds != null) {
                while (iterator2.hasNext()) {
                    Map.Entry<String, Integer> entry = iterator2.next();
                    preparedStatement = conn.prepareStatement(kindsSql);
                    preparedStatement.setString(1, entry.getKey());
                    preparedStatement.setInt(2, entry.getValue());
                    preparedStatement.execute();
                }
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

// <张圳>