// <张圳>

/*
    文件工具类，主要实现以下功能供前端调用：
    1. 复制文件、文件夹
    2. 删除文件、文件夹
    3. 重命名文件、文件夹
    4. 打开文件、文件夹
 * 
 */
package com.zz.fileutil;

import java.awt.Desktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUtil.
 */
public class FileUtil {
    
    /**
     * Open file.
     *
     * @param path the path
     * @param isFile the is file
     * @return true, if successful
     */
    public static boolean openFile(String path, boolean isFile) {
        String destination = isFile ? path : path.substring(0, path.lastIndexOf("\\"));
        File file = new File(destination);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            System.out.println("打开失败！");
            return false;
        }
        return true;
    }

    /**
     * Single file copy.
     *
     * @param srcPathStr the src path str
     * @param desPathStr the des path str
     */
    public static void singleFileCopy(String srcPathStr, String desPathStr) {
        if (!desPathStr.endsWith(File.separator)) {
            desPathStr += File.separator + srcPathStr.substring(srcPathStr.lastIndexOf("\\") + 1);
        }
        try {
            FileInputStream fis = new FileInputStream(srcPathStr);
            FileOutputStream fos = new FileOutputStream(desPathStr);
            byte datas[] = new byte[1024 * 8];
            int len = 0;
            while ((len = fis.read(datas)) != -1) {
                fos.write(datas, 0, len);
            }
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Dir copy.
     *
     * @param srcPathStr the src path str
     * @param desPathStr the des path str
     */
    public static void dirCopy(String srcPathStr, String desPathStr) {
        try {
            System.out.println(srcPathStr + "---" + desPathStr);

            new File(desPathStr).mkdirs();
            File filelist = new File(srcPathStr);
            String[] file = filelist.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (srcPathStr.endsWith(File.separator)) {
                    temp = new File(srcPathStr + file[i]);
                } else {
                    temp = new File(srcPathStr + File.separator + file[i]);
                }
                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(desPathStr + "/" + (temp.getName()).toString());
                    byte[] bufferarray = new byte[1024 * 64];
                    int prereadlength;
                    while ((prereadlength = input.read(bufferarray)) != -1) {
                        output.write(bufferarray, 0, prereadlength);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {
                    dirCopy(srcPathStr + "\\" + file[i], desPathStr + "\\" + file[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete single file.
     *
     * @param path the path
     * @return true, if successful
     */
    public static boolean deleteSingleFile(String path) {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Delete file.
     *
     * @param path the path
     * @param isFile the is file
     * @return true, if successful
     */
    public static boolean deleteFile(String path, boolean isFile) {
        if (isFile) {
            return deleteSingleFile(path);
        } else {
            if (!path.endsWith(File.separator)) {
                path += File.separator;
            }
            File dirFile = new File(path);
            if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
                return false;
            }
            boolean flag = true;
            File[] files = dirFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    flag = deleteSingleFile(files[i].getAbsolutePath());
                    if (!flag)
                        break;
                } else if (files[i].isDirectory()) {
                    flag = deleteFile(files[i].getAbsolutePath(), false);
                    if (!flag)
                        break;
                }
            }
            if (!flag) {
                return false;
            }
            if (dirFile.delete()) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Rename file.
     *
     * @param oldPath the old path
     * @param newName the new name
     * @return true, if successful
     */
    public static boolean renameFile(String oldPath, String newName) {
        String newPath = oldPath.substring(0, oldPath.lastIndexOf("\\") + 1) + newName;
        System.out.println(newPath);
        return new File(oldPath).renameTo(new File(newPath));
    }

}

// <张圳>
