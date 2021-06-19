package spring.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.UserDao;
import spring.pojo.UserPojo;
import spring.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserDao userDao;
    @Override
    public int LoginByUsername(String name,String pass) {
        String password;
        if(userDao.SelectByUsername(name)==null) return 4;
        //System.out.println(password);
        else password=userDao.SelectByUsername(name).getPassword();
        if(pass.equals(password)){
            return 1;
        }
        else if(pass!=null)
        {
            return 2;
        }
        else if(pass==null)
        {
            return 3;
        }
        return 0;
    }
}
