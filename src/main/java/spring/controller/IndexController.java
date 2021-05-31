package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.service.CollageService;

@Controller
public class IndexController {
    /*
     */@Autowired
    CollageService collageService;
    @RequestMapping("/index.do")
    public ModelAndView dosome(){
        ModelAndView mv = new ModelAndView();
        //等价于request.setAttribute("msg","****");
        mv.addObject("collages",collageService.SelectAll());
        //等价于request.getRequestDispatcher("/").forword(..);
        mv.setViewName("index");
        return mv;
    }
}
