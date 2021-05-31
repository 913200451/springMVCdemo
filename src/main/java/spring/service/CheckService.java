package spring.service;

import org.springframework.web.servlet.ModelAndView;

import java.io.File;

public interface CheckService {
public ModelAndView checkline(File f, int id,ModelAndView mv);
public ModelAndView checktitles(File f,int id,ModelAndView mv);
}
