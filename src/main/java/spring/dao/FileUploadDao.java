package spring.dao;


import org.springframework.stereotype.Repository;
import spring.pojo.FileUploadPojo;
@Repository
public interface FileUploadDao {
    public int upload(FileUploadPojo file);
}
