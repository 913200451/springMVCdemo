package spring.dao;

import org.springframework.stereotype.Repository;
import spring.pojo.UserPojo;
@Repository
public interface UserDao {
    public UserPojo SelectByUsername(String name);
}
