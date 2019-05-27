// <����>

/*
    �ļ������࣬��Ŀ���Ĺ���ʵ���ࡣ
    ����ֱ�ӱ����ķ�ʽ�����ң�ʹ����Java8��NIO�е�
    �ļ�������walkFileTree������������ȴ�ͳ���ļ�
    �����ϸߣ�����ʱ������������
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
     *            the search mode ����ģʽ�� suffix:��׺ƥ�� part:����ƥ�� complete:��ȫƥ��
     *            regex:����ƥ��
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
     * ���������Ľ����HashMap���棬����<�ļ������ļ�·��> �ȱ��棬��չʾ�������ʹ�á�������-�����ߡ�ģʽ�����ö��߳�
     * ÿ������һ�����������Ľ���������߳̾ͽ�������������У�չʾ �߳������ȡ��չʾ���ٶȿ��ܻ��������������������������Ҫ
     * ��������д洢���ʶ����õ��̱߳�������洢��
     *
     * @return the search result
     */
    public Map<File, String> getSearchResult() {
        return searchResult;
    }
}

// <����>
