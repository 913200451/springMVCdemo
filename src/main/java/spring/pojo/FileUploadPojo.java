package spring.pojo;

import java.util.Arrays;

public class FileUploadPojo {

    byte[] FileData;


    public byte[] getFileData() {
        return FileData;
    }

    public void setFileData(byte[] fileData) {
        FileData = fileData;
    }

    @Override
    public String toString() {
        return "FileUploadEntity{" +
                "FileData=" + Arrays.toString(FileData) +
                '}';
    }
}
