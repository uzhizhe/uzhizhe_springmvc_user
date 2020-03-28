package com.uzhizhe.service.impl;

import com.uzhizhe.beans.User;
import com.uzhizhe.dao.UserRepository;
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
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    /**
     * find user by uid
     *
     * @param uid
     * @return
     */
    @Override
    public User findUser(String uid) {
        User user = userRepository.findFirstByUid(uid);
        return user;
    }

    /**
     * add user
     *
     * @param user
     * @return
     */
    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

}
