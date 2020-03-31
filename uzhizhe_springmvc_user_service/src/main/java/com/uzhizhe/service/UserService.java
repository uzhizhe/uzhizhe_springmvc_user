package com.uzhizhe.service;

import com.uzhizhe.beans.User;
import com.uzhizhe.beans.bo.UserBo;
import com.uzhizhe.beans.dto.PagedDTO;

import java.util.List;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
public interface UserService {

    /**
     * find user by uid
     *
     * @param uid
     * @return
     */
    User findUser(String uid);

    /**
     * find user list
     *
     * @param userBo
     * @return
     */
    PagedDTO<User> findUser(UserBo userBo);


    /**
     * add user
     *
     * @param user
     * @return
     */
    User add(User user);

    /**
     * remove
     *
     * @param uid
     * @return
     */
    void remove(String uid);

    /**
     * user
     *
     * @param user
     * @return
     */
    User update(User user);

    /**
     * query all user
     *
     * @return
     */
    List<User> queryAllUser();

}
