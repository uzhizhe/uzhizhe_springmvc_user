package com.uzhizhe.user.web.controller;

import com.uzhizhe.beans.bo.UserBo;
import com.uzhizhe.beans.dto.PagedDTO;
import com.uzhizhe.user.web.vo.UserVo;
import com.uzhizhe.user.web.webservice.UserWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public @ResponseBody
    UserVo getUser(@RequestParam String uid) throws Exception {
        System.out.println("获取用户信息, uid:" + uid);
        ModelAndView modelAndView = new ModelAndView("userInfo");
        UserVo userVo = userWebService.findUser(uid);
        System.out.println(userVo);
        modelAndView.addObject("user", userVo);
        return userVo;
    }

    //query all user
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                 @RequestParam(name = "pageSize", required = false, defaultValue = "3") Integer pageSize,
                                 @RequestParam(name = "uid", required = false) String uid,
                                 @RequestParam(name = "userName", required = false) String userName,
                                 @RequestParam(name = "address", required = false) String address,
                                 @RequestParam(name = "age", required = false) Integer age,
                                 @RequestParam(name = "gender", required = false) Integer gender) {

        UserBo userBo = new UserBo(page, pageSize, userName, uid, age, gender);
        System.out.println("获取用户的信息, userBo:" + userBo);
        ModelAndView modelAndView = new ModelAndView("userInfoList");
        PagedDTO<UserVo> userVoPagedDTO = userWebService.findUser(userBo);
        modelAndView.addObject("userPage", userVoPagedDTO);
        return modelAndView;
    }

    //add user
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView addUser(UserVo userVo) throws Exception {
        System.out.println("添加用户:" + userVo);
        userWebService.addUser(userVo);
        return getUsers();
    }

    //delete user by uid
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public ModelAndView delUser(@RequestParam String uid) throws Exception {
        System.out.println("删除用户:" + uid);
        userWebService.removeUser(uid);
        return getUsers();
    }

    private ModelAndView getUsers() {
        return getUsers(1, 3, null, null, null, null, null);
    }


}
