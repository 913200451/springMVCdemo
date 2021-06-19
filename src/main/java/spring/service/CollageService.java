package spring.service;

import spring.pojo.CollagePojo;

import java.util.List;

public interface CollageService {
    public List<CollagePojo> SelectAll();
    public CollagePojo SelectById(int id);
}
