// <张圳>

/*
    文件搜索类，项目核心功能实现类。
    采用直接遍历的方式来查找，使用了Java8中NIO中的
    文件操作的walkFileTree方法，性能相比传统的文件
    方法较高，搜索时间能满足需求。
 * 
 */
package com.zz.filesearch;

import java.io.File;

import java.io.IOException;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class FileSearch.
 */
public class FileSearch {

    /** The root path. */
    private Path rootPath;

    /** The target file name. */
    private String targetFileName;

    /** The search result. */
    private static Map<File, String> searchResult = null;

    /**
     * Instantiates a new file search.
     *
     * @param rootPath
     *            the root path
     * @param targetFileName
     *            the target file name
     */
    public FileSearch(String rootPath, String targetFileName) {
        this.rootPath = Paths.get(rootPath);
        this.targetFileName = targetFileName;
    }

    /**
     * Search.
     *
     * @param searchMode
     *            the search mode 搜索模式： suffix:后缀匹配 part:部分匹配 complete:完全匹配
     *            regex:正则匹配
     * @return the file search
     */
    public FileSearch search(String searchMode) {
        searchResult = new HashMap<>();
        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                String targetFilePath = null;

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileName = file.getFileName().toString();
                    if ("part".equals(searchMode)) {
                        if (fileName.contains(targetFileName)) {
                            targetFilePath = file.toAbsolutePath().toString();
                            searchResult.put(file.toFile(), targetFilePath);
                            return FileVisitResult.CONTINUE;
                        } else {
                            return FileVisitResult.CONTINUE;
                        }
                    } else if ("suffix".equals(searchMode)) {
                        if (fileName.endsWith(targetFileName)) {
                            targetFilePath = file.toAbsolutePath().toString();
                            searchResult.put(file.toFile(), targetFilePath);
                            return FileVisitResult.CONTINUE;
                        } else {
                            return FileVisitResult.CONTINUE;
                        }
                    } else if ("regex".equals(searchMode)) {
                        if (fileName.matches(targetFileName)) {
                            targetFilePath = file.toAbsolutePath().toString();
                            searchResult.put(file.toFile(), targetFilePath);
                            return FileVisitResult.CONTINUE;
                        } else {
                            return FileVisitResult.CONTINUE;
                        }
                    } else {
                        if (fileName.equals(targetFileName)) {
                            targetFilePath = file.toAbsolutePath().toString();
                            searchResult.put(file.toFile(), targetFilePath);
                            return FileVisitResult.TERMINATE;
                        } else {
                            return FileVisitResult.CONTINUE;
                        }
                    }
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Gets the search result.
     * 
     * 将搜索到的结果用HashMap保存，即：<文件名，文件路径> 先保存，后展示，相比于使用“消费者-生产者”模式（采用多线程
     * 每搜索出一个符合条件的结果，搜索线程就将其放入阻塞队列，展示 线程则从中取出展示）速度可能会减慢，但由于其他功能需求，需要
     * 将结果进行存储，故而采用单线程遍历，后存储。
     *
     * @return the search result
     */
    public Map<File, String> getSearchResult() {
        return searchResult;
    }
}

// <张圳>
