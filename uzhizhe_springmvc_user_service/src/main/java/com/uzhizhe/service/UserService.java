package com.uzhizhe.service;

import com.uzhizhe.beans.User;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
public interface UserService {

    /**
     * find user by uid
     * @param uid
     * @return
     */
    User findUser(String uid);

    /**
     * add user
     * @param user
     * @return
     */
    User add(User user);
}
