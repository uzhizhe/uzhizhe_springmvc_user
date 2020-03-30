package com.uzhizhe.user.web.controller;

import com.uzhizhe.beans.User;
import com.uzhizhe.user.web.vo.UserVo;
import com.uzhizhe.user.web.webservice.UserWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    //query user by uid
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody UserVo getUser(@RequestParam String uid) throws Exception{
        System.out.println("获取用户信息, uid:" + uid);
        ModelAndView modelAndView = new ModelAndView("userInfo");
        UserVo userVo = userWebService.findUser(uid);
        System.out.println(userVo);
        modelAndView.addObject("user", userVo);
        return userVo;
    }

    //query all user
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(){
        System.out.println("获取所有用户的信息 ~_~");
        ModelAndView modelAndView = new ModelAndView("userInfoList");
        List<UserVo> userVoList = userWebService.queryAllUser();
        modelAndView.addObject("userList", userVoList);
        return modelAndView;
    }

    //add user
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView addUser(UserVo userVo) throws Exception{
        System.out.println("添加用户:" + userVo);
        userWebService.addUser(userVo);
        return getUsers();
    }

    //delete user by uid
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public ModelAndView delUser(@RequestParam String uid) throws Exception{
        System.out.println("删除用户:" + uid);
        userWebService.removeUser(uid);
        return getUsers();
    }


}
