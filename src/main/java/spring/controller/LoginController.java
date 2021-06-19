package spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.pojo.UserPojo;
import spring.service.LoginService;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/login.do")
    @ResponseBody
    String Login(@RequestBody UserPojo user){
        return Integer.toString(loginService.LoginByUsername(user.getUsername(),user.getPassword()));
    }
}
