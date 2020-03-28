package com.uzhizhe.user.web.webservice;

import com.uzhizhe.beans.User;
import com.uzhizhe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
@Service
public class UserWebService {

    @Autowired
    private UserService userService;

    public User findUser(String uid){
        return userService.findUser(uid);
    }
}
