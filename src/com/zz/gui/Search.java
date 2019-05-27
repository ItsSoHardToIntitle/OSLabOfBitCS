// <张圳>

/*
    搜索类，为前后端结合的核心类。
    主要功能为：
    1. 调用FileSearch类进行搜索
    2. 将搜索结果进行展示
    3. 记录每次的搜索时间，搜索结果的数目
    4. 调用InsertIntoDB类保存搜素记录
    5. 保存每次过滤、排序功能要使用到的数据
    6. ……
 * 
 */
package com.zz.gui;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.table.DefaultTableModel;

import com.zz.filesearch.FileSearch;
import com.zz.searchhistorydb.InsertIntoDB;
import com.zz.sortuitl.DefaultSortUtil;
import com.zz.sortuitl.SortUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Search.
 */
public class Search {

    /** The search path chosen. */
    private static String searchPathChosen;

    /** The user input str. */
    private static String userInputStr;

    /** The search result map. */
    private static Map<File, String> searchResultMap;

    /** The specific kind map. */
    private static Map<String, Integer> specificKindMap = new HashMap<>();

    /** The kind map. */
    private static Map<String, Integer> kindMap = new HashMap<>();

    /** The Constant SIZE. */
    private static final String SIZE = "条目数量：";

    /** The start time. */
    private static long startTime = 0;

    /** The end time. */
    private static long endTime = 0;

    /** The tab col number. */
    private static int tabColNumber = 4;

    /** The search result size. */
    private static int searchResultSize;

    /** The res tab attribute. */
    private static String[] resTabAttribute = new String[] { "文件名", "路径", "大小", "最后修改时间" };

    /** The search result strings. */
    private static Object[] searchResultStrings;

    /** The simple date format. */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    /** The sorted map. */
    private static SortedMap<File, String> sortedMap;

    /**
     * Start search.
     */
    public static void startSearch() {
        specificKindMap.clear();
        kindMap.clear();

        startTime = System.currentTimeMillis();
        userInputStr = GUI.getInputTextField().getText();

        InsertIntoDB.insertIntoHistoryTb(startTime, userInputStr, MenuBar.getSearchMode());
        FileSearch fileSearch = new FileSearch(searchPathChosen, userInputStr);

        searchResultMap = fileSearch.search(MenuBar.getSearchMode()).getSearchResult();
        endTime = System.currentTimeMillis();

        String time = "搜索时间：" + String.valueOf((endTime - startTime) / 1000.0) + "ms";
        MessegeBox.getTimeLabel().setText(time);
        showSearchResult();
    }

    /**
     * Show search result.
     */
    public static void showSearchResult() {
        searchResultSize = searchResultMap.size();
        MessegeBox.getSizeLabel().setText(SIZE + String.valueOf(searchResultSize));

        Iterator<Entry<File, String>> iterator = searchResultMap.entrySet().iterator();
        File file = null;
        String path = "";
        long length = 0;
        String lastModify = "";

        int no = 0;
        String fileName = "";
        String fileNameSuffix = "";

        String kind = "";
        GUI.setDefaultTableModel((DefaultTableModel) GUI.getSearchResultTable().getModel());
        specificKindMap.clear();
        kindMap.clear();
        while (iterator.hasNext()) {
            Entry<File, String> entry = iterator.next();
            file = entry.getKey();
            path = entry.getValue();
            length = file.length() / 1024;
            lastModify = simpleDateFormat.format(file.lastModified());

            searchResultStrings = new Object[tabColNumber];
            fileName = file.getName();
            fileNameSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            no = DefaultSortUtil.tellKind(fileNameSuffix);
            if (fileName.contains(".") && no != 81) {
                specificKindMap.put(fileNameSuffix, specificKindMap.getOrDefault(fileNameSuffix, 0) + 1);
            }
            kind = DefaultSortUtil.getAllKind()[no / 10 - 1];
            kindMap.put(kind, kindMap.getOrDefault(kind, 0) + 1);

            searchResultStrings[0] = String.valueOf(no) + fileName;
            searchResultStrings[1] = path;
            searchResultStrings[2] = length;
            searchResultStrings[3] = lastModify;

            GUI.getDefaultTableModel().addRow(searchResultStrings);
        }

        GUI.getSearchResultTable().setModel(GUI.getDefaultTableModel());
    }

    /**
     * Renew result map.
     */
    public static void renewResultMap() {
        sortedMap.putAll(searchResultMap);
        searchResultMap = sortedMap;
        GUI.getDefaultTableModel().setRowCount(0);
        Search.showSearchResult();
    }

    /**
     * Sort search result map.
     *
     * @param sortWay
     *            the sort way
     */
    public static void sortSearchResultMap(int sortWay) {
        switch (sortWay) {
        case 0:
            sortedMap = new TreeMap<File, String>(SortUtil.sortByFileName());
            renewResultMap();
            break;
        case 1:
            sortedMap = new TreeMap<File, String>(SortUtil.sortByFilePath());
            renewResultMap();
            break;
        case 2:
            sortedMap = new TreeMap<File, String>(SortUtil.sortByFileSize());
            renewResultMap();
            break;
        case 3:
            sortedMap = new TreeMap<File, String>(SortUtil.sortByLastModifyTime());
            renewResultMap();
            break;
        case 4:
            sortedMap = new TreeMap<File, String>(SortUtil.sortBySuffix());
            renewResultMap();
            break;
        default:
            break;
        }

    }

    /**
     * Sets the search path chosen.
     *
     * @param searchPathChosen
     *            the new search path chosen
     */
    public static void setSearchPathChosen(String searchPathChosen) {
        Search.searchPathChosen = searchPathChosen;
    }

    /**
     * Gets the search path chosen.
     *
     * @return the search path chosen
     */
    public static String getSearchPathChosen() {
        return searchPathChosen;
    }

    /**
     * Gets the res tab attribute.
     *
     * @return the res tab attribute
     */
    public static String[] getResTabAttribute() {
        return resTabAttribute;
    }

    /**
     * Gets the specific kind map.
     *
     * @return the specific kind map
     */
    public static Map<String, Integer> getSpecificKindMap() {
        return specificKindMap;
    }

    /**
     * Gets the kind map.
     *
     * @return the kind map
     */
    public static Map<String, Integer> getKindMap() {
        return kindMap;
    }
}

// <张圳>