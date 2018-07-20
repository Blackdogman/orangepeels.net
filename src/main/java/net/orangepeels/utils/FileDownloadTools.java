package net.orangepeels.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileDownloadTools {
    public static void downLoadFile(String fileUrl, String downloadPath) throws IOException {
        InputStream fromInputStream;
        String[] fromPathSplit = fileUrl.split("/");
        String fileName = fromPathSplit[fromPathSplit.length - 1];
        String toPath = downloadPath + fileName;
        URL url;
        URLConnection conn;
        try {
            url = new URL(fileUrl.trim());
            fromInputStream = url.openStream();
        } catch (Exception ex) {
            return;
        }
        System.out.println("开始下载文件: " + fileUrl);
        doFiles(fromInputStream, toPath);
    }

    /**
     * 对于本地文件的复制
     *
     * @param fromPath 来源地址
     * @param toPath   目标地址
     * @throws IOException 抛出io异常
     */
    private static void doFiles(String fromPath, String toPath) throws IOException {
        File fromFile = new File(fromPath);
        File toFile = new File(toPath);


        FileInputStream fileInputStream = new FileInputStream(fromFile);
        if (!toFile.exists()) {
            toFile.createNewFile();
        } else {
            toFile.delete();
            toFile.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(toFile);
        byte[] tempBytes = new byte[256];
        int readLength;
        while ((readLength = fileInputStream.read(tempBytes)) > 0) {
            fileOutputStream.write(tempBytes, 0, readLength);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    /**
     * 针对流转为File的方法
     *
     * @param fromPath 来源流
     * @param toPath   目标文件
     * @throws IOException 抛出io异常
     */
    private static void doFiles(InputStream fromPath, String toPath) throws IOException {
        File toFile = new File(toPath);
        InputStream fileInputStream = fromPath;
        if (toFile.exists()) {
            toFile.delete();
        }
        toFile.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(toFile);
        byte[] tempBytes = new byte[4096];
        int readLength;
        long currentLength = 0;
        int numFlag = 0;
        String startTime = new SimpleDateFormat("yyyyMMdd hh:mm:ss:SSS").format(new Date());
        while ((readLength = fileInputStream.read(tempBytes)) > 0) {
            currentLength += readLength;
            numFlag++;
            if (numFlag % 100 == 0 || currentLength == readLength) {
                System.out.println("已经下载: " + currentLength / 1024 + " kb");
                numFlag = 0;
            }
            fileOutputStream.write(tempBytes, 0, readLength);
        }
        System.out.println("开始时间: " + startTime);
        System.out.println("结束时间: " + new SimpleDateFormat("yyyyMMdd hh:mm:ss:SSS").format(new Date()));
        fileInputStream.close();
        fileOutputStream.close();
    }
}
