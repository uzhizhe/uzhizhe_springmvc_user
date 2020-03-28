package com.uzhizhe.user.web.controller;

import com.uzhizhe.beans.User;
import com.uzhizhe.user.web.webservice.UserWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
@Controller
@RequestMapping("/uzhizhe")
public class UserController {

    @Autowired
    private UserWebService userWebService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public @ResponseBody User getUser(@RequestParam String uid){
        System.out.println("获取用户信息, uid:" + uid);
        ModelAndView modelAndView = new ModelAndView("userInfo");
        User user = userWebService.findUser(uid);
        System.out.println(user);
        modelAndView.addObject("user", user);
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(){
        System.out.println("获取所有用户的信息 ~_~");
        ModelAndView modelAndView = new ModelAndView("userInfoList");
        User user = userWebService.findUser("1001");
        User user2 = userWebService.findUser("1002");
        User user3 = userWebService.findUser("1003");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

}
