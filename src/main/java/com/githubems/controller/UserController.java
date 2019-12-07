package com.githubems.controller;

import com.githubems.entity.User;
import com.githubems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 康得辉 on 2019/12/7.
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    //登录
    @RequestMapping("login")
    public Map login(User user, HttpSession session){
       Map<String, Object> map = new HashMap<>();
        try {
            User login = userService.Login(user);
            session.setAttribute("user",login);
        } catch (Exception e) {
            String s = e.getMessage();
            e.printStackTrace();
            map.put("status",s);
            map.put("message","请重新等登录");
        }
        return map;
    }
    //注册
    @RequestMapping("regist")
    public Map regist(User user){
        Map<String, Object> map = new HashMap<>();
        userService.regist(user);
        map.put("status", "注册成功！");
        return map;
    }

}
