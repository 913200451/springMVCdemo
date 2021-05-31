package spring.Util;

import org.springframework.web.multipart.MultipartFile;

public class TypecheckUtil {


    public static boolean checktype(MultipartFile file)
    {
        String fileName=file.getOriginalFilename();
        String[] fileTyle=fileName.split("\\.");
        if(fileTyle.length!=0){
            if(fileTyle[fileTyle.length-1].equals("docx")) return true;
        }

        return false;

    }
}
