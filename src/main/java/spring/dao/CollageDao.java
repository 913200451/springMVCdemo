package spring.dao;

import org.springframework.stereotype.Repository;
import spring.pojo.CollagePojo;

import java.util.List;
@Repository
public interface CollageDao {
public List<CollagePojo> SelectAll();
public CollagePojo SelectById(int id);
}
