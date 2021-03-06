package spring.Util;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipUtil {
    public static void decompression(String zipFile,String destination) throws IOException {
        ZipFile zip=new ZipFile(zipFile);
        Enumeration en=zip.entries();
        ZipEntry entry=null;
        byte[] buffer=new byte[8192];
        int length=-1;
        InputStream input=null;
        BufferedOutputStream bos=null;
        File file=null;

        while(en.hasMoreElements()) {
            entry=(ZipEntry)en.nextElement();
            if(entry.isDirectory()) {
                System.out.println("directory");
                continue;
            }

            input=zip.getInputStream(entry);
            file=new File(destination,entry.getName());
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            bos=new BufferedOutputStream(new FileOutputStream(file));

            while(true) {
                length=input.read(buffer);
                if(length==-1) break;
                bos.write(buffer,0,length);
            }
            bos.close();
            input.close();
        }
        zip.close();
    }

}
