package spring.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.CollageDao;
import spring.pojo.CollagePojo;
import spring.service.CollageService;

import java.util.List;
@Service
public class CollageServiceImple implements CollageService {
    @Autowired
    CollageDao collageDao;
    @Override
    public List<CollagePojo> SelectAll() {
        return collageDao.SelectAll();
    }
}
