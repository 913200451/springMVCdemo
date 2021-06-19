package spring.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.api.scripting.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spring.pojo.CollagePojo;
import spring.service.CollageService;

import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping(value="getcollage.do",produces = { "text/html;charset=utf-8" })//不加这个传安卓端时会变成问号
    @ResponseBody
    public String getcollage()
    {
        String jsonArray;
        ObjectMapper mapper = new ObjectMapper();
        List<String> collagenames=new ArrayList<>();
        List<CollagePojo> pojoList=collageService.SelectAll();
        jsonArray=JSONObject.toJSONString(pojoList);
        return jsonArray;                                                           //返回一个JSON格式的String
    }
    @RequestMapping(value="getformat.do",produces = { "text/html;charset=utf-8" })
    @ResponseBody
    public String getformat(@RequestBody CollagePojo collagePojo)
    {
        int id=collagePojo.getId();
        return JSONObject.toJSONString(collageService.SelectById(id));
    }
}
