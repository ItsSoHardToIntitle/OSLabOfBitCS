// <张圳>

/*
    项目中涉及到的所有排序功能的实现所要的各种比较器
    Comparotor.
 * 
 */
package com.zz.sortuitl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import com.zz.gui.SortBox;

// TODO: Auto-generated Javadoc
/**
 * The Class SortUtil.
 */
public class SortUtil {

    /** The simple date format. */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    /**
     * Sort by file name.
     *
     * @return the comparator
     */
    public static Comparator<File> sortByFileName() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int valCmp = o1.getName().compareTo(o2.getName());
                if (SortBox.isReverseOrder()) {
                    if (valCmp == 0) {
                        return o2.getAbsolutePath().compareTo(o1.getAbsolutePath());
                    }
                    return o2.getName().compareTo(o1.getName());
                } else {
                    if (valCmp == 0) {
                        return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
                    }
                    return o1.getName().compareTo(o2.getName());
                }
            }
        };
    }

    /**
     * Sort by file path.
     *
     * @return the comparator
     */
    public static Comparator<File> sortByFilePath() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (SortBox.isReverseOrder()) {
                    return o2.getAbsolutePath().compareTo(o1.getAbsolutePath());
                } else {
                    return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
                }
            }
        };
    }

    /**
     * Sort by file size.
     *
     * @return the comparator
     */
    public static Comparator<File> sortByFileSize() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int valCmp = (int) (o1.length() - (o2.length()));
                if (SortBox.isReverseOrder()) {
                    if (valCmp == 0) {
                        return o2.getAbsolutePath().compareTo(o1.getAbsolutePath());
                    }
                    return (int) (o2.length() - o1.length());
                } else {
                    if (valCmp == 0) {
                        return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
                    }
                    return (int) (o1.length() - o2.length());
                }
            }
        };
    }

    /**
     * Sort by last modify time.
     *
     * @return the comparator
     */
    public static Comparator<File> sortByLastModifyTime() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int valCmp = simpleDateFormat.format(o2.lastModified())
                        .compareTo(simpleDateFormat.format(o1.lastModified()));
                if (SortBox.isReverseOrder()) {
                    if (valCmp == 0) {
                        return o2.getAbsolutePath().compareTo(o1.getAbsolutePath());
                    }
                    return simpleDateFormat.format(o2.lastModified())
                            .compareTo(simpleDateFormat.format(o1.lastModified()));
                } else {
                    if (valCmp == 0) {
                        return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
                    }
                    return simpleDateFormat.format(o1.lastModified())
                            .compareTo(simpleDateFormat.format(o2.lastModified()));
                }
            }
        };
    }

    /**
     * Sort by suffix.
     *
     * @return the comparator
     */
    public static Comparator<File> sortBySuffix() {
        return new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String fileName1 = o1.getName();
                String fileName2 = o2.getName();

                String string1 = fileName1.substring(fileName1.lastIndexOf(".") + 1);
                String string2 = fileName2.substring(fileName2.lastIndexOf(".") + 1);

                int seq1 = DefaultSortUtil.tellKind(string1);
                int seq2 = DefaultSortUtil.tellKind(string2);

                if (seq1 == seq2) {
                    int valCmp = fileName1.compareTo(fileName2);
                    if (SortBox.isReverseOrder()) {
                        if (valCmp == 0) {
                            return o2.getAbsolutePath().compareTo(o1.getAbsolutePath());
                        }
                        return fileName2.compareTo(fileName1);
                    } else {
                        if (valCmp == 0) {
                            return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
                        }
                        return fileName1.compareTo(fileName2);
                    }
                }

                if (SortBox.isReverseOrder()) {
                    return seq2 - seq1;
                } else {
                    return seq1 - seq2;
                }
            }
        };
    }

    /**
     * Sort by value.
     *
     * @return the comparator
     */
    public static Comparator<Map.Entry<String, Integer>> sortByValue() {
        return new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        };
    }
}

// <张圳>