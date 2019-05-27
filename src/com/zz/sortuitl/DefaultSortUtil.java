// <张圳>

/*
    对搜索结果进行过滤，渲染，排序以及可视化时所用到的排序功能相关的
    字段，方法等。将每种类型进行编号，使用HashMap存储，查找效率高，
    进行相关操作也很便捷。
 * 
 */
package com.zz.sortuitl;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class DefaultSortUtil.
 */
public class DefaultSortUtil {

    /** The Constant noneRegex. */
    private static final String noneRegex = "";

    /** The Constant exeRegex. */
    private static final String exeRegex = "(\\.exe)$";

    /** The Constant compressRegex. */
    private static final String compressRegex = "(\\.rar|\\.zip|\\.7z)$";

    /** The Constant officeRegex. */
    private static final String officeRegex = "(\\.doc|\\.docx|\\.html|\\.pdf|\\.ppt|\\.pptx|\\.txt|\\.xls|\\.xlsx)$";

    /** The Constant imageRegex. */
    private static final String imageRegex = "(\\.ai|\\.bmp|\\.gif|\\.jpeg|\\.jpg|\\.png|\\.psd|\\.svg|\\.tiff)$";

    /** The Constant videoRegex. */
    private static final String videoRegex = "(\\.avi|\\.flv|\\.mkv|\\.mp4|\\.rmvb)$";

    /** The Constant musicRegex. */
    private static final String musicRegex = "(\\.cda|\\.flac|\\.mp3|\\.wav|\\.wma)$";

    /** The Constant procedureRegex. */
    private static final String procedureRegex = "(\\.c|\\.cpp|\\.m|\\.jar|\\.java|\\.py)$";

    /** The Constant allRegex. */
    private static final String[] allRegex = new String[] { noneRegex, exeRegex, compressRegex, officeRegex, imageRegex,
            videoRegex, musicRegex, procedureRegex };

    /** The Constant systemMap. */
    @SuppressWarnings("serial")
    private static final HashMap<String, Integer> systemMap = new HashMap<String, Integer>() {
        {
            put("exe", 11);
        }
    };

    /** The Constant compressMap. */
    @SuppressWarnings("serial")
    private static final HashMap<String, Integer> compressMap = new HashMap<String, Integer>() {
        {
            put("rar", 21);
            put("zip", 22);
            put("7z", 23);
        }
    };

    /** The Constant officeMap. */
    @SuppressWarnings("serial")
    private static final HashMap<String, Integer> officeMap = new HashMap<String, Integer>() {
        {
            put("doc", 31);
            put("docx", 32);
            put("html", 33);
            put("pdf", 34);
            put("ppt", 35);
            put("pptx", 36);
            put("txt", 37);
            put("xls", 38);
            put("xlsx", 39);
        }
    };

    /** The Constant imageMap. */
    @SuppressWarnings("serial")
    private static final HashMap<String, Integer> imageMap = new HashMap<String, Integer>() {
        {
            put("ai", 41);
            put("bmp", 42);
            put("gif", 43);
            put("jpeg", 44);
            put("jpg", 45);
            put("png", 46);
            put("psd", 47);
            put("svg", 48);
            put("tiff", 49);
        }
    };

    /** The Constant videoMap. */
    @SuppressWarnings("serial")
    private static final HashMap<String, Integer> videoMap = new HashMap<String, Integer>() {
        {
            put("avi", 51);
            put("flv", 52);
            put("mkv", 53);
            put("mp4", 54);
            put("rmvb", 55);
        }
    };

    /** The Constant musicMap. */
    @SuppressWarnings("serial")
    private static final HashMap<String, Integer> musicMap = new HashMap<String, Integer>() {
        {
            put("cda", 61);
            put("flac", 62);
            put("mp3", 63);
            put("wav", 64);
            put("wma", 65);
        }
    };

    /** The Constant procedureMap. */
    @SuppressWarnings("serial")
    private static final HashMap<String, Integer> procedureMap = new HashMap<String, Integer>() {
        {
            put("c", 71);
            put("cpp", 72);
            put("m", 73);
            put("jar", 74);
            put("java", 75);
            put("py", 76);
        }
    };

    /** The all kind. */
    private static String[] allKind = new String[] { "system", "compress", "office", "image", "video", "music",
            "procedure", "others" };

    /**
     * Tell kind.
     *
     * @param string
     *            the string
     * @return the int
     */
    public static int tellKind(String string) {
        if (systemMap.containsKey(string)) {
            return systemMap.get(string);
        } else if (compressMap.containsKey(string)) {
            return compressMap.get(string);
        } else if (officeMap.containsKey(string)) {
            return officeMap.get(string);
        } else if (imageMap.containsKey(string)) {
            return imageMap.get(string);
        } else if (videoMap.containsKey(string)) {
            return videoMap.get(string);
        } else if (musicMap.containsKey(string)) {
            return musicMap.get(string);
        } else if (procedureMap.containsKey(string)) {
            return procedureMap.get(string);
        } else {
            return 81;
        }
    }

    /**
     * Gets the allregex.
     *
     * @return the allregex
     */
    public static String[] getAllregex() {
        return allRegex;
    }

    /**
     * Gets the all kind.
     *
     * @return the all kind
     */
    public static String[] getAllKind() {
        return allKind;
    }
}

// <张圳>