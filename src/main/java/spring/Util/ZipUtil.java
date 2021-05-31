package spring.Util;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;


public class ZipUtil {

    /**
     * 解压
     * @param zipFile 待解压文件的路径
     * @param descDir 解压后的文件存储路径
     * @throws Exception
     */
    public static void unzip(File zipFile, File descDir) {
        try (ZipArchiveInputStream inputStream = getZipFile(zipFile)) {
            if (!descDir.exists()) {
                descDir.mkdirs();
            }
            ZipArchiveEntry entry = null;
            while ((entry = inputStream.getNextZipEntry())!= null) {
                    if (entry.isDirectory()) {
                        File directory = new File(descDir, entry.getName());
                        directory.mkdirs();
                    } else {
                        OutputStream os = null;
                        try {
                            os = new BufferedOutputStream(new FileOutputStream(new File(descDir, entry.getName())));
                            //输出文件路径信息
                            System.out.println("解压文件的当前路径为:" + descDir + entry.getName());
                            IOUtils.copy(inputStream, os);
                        } finally {
                            IOUtils.closeQuietly(os);
                        }
                    }
                }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ZipArchiveInputStream getZipFile(File zipFile) throws Exception {
        return new ZipArchiveInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
    }


}