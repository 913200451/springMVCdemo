package spring.service.imple;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.service.FileUploadService;
@Service
public class FileUploadServiceImple implements FileUploadService {


    @Override
    public int upload(MultipartFile file) {

        return 0;
    }
}
