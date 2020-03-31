package com.uzhizhe.user.web.webservice;

import com.uzhizhe.beans.User;
import com.uzhizhe.beans.bo.UserBo;
import com.uzhizhe.beans.dto.PagedDTO;
import com.uzhizhe.service.UserService;
import com.uzhizhe.user.web.vo.UserVo;
import com.uzhizhe.utils.CollectionUtil;
import com.uzhizhe.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

    /**
     * find user by uid
     *
     * @param uid
     * @return
     * @throws Exception
     */
    public UserVo findUser(String uid) throws Exception {
        User user = userService.findUser(uid);
        if (user == null) {
            throw new RuntimeException("该用户不存在");
        }

        UserVo userVo = new UserVo();
        /*userVo.setUid(user.getUid());
        userVo.setUserName(user.getUserName());
        userVo.setAddress(user.getAddress());
        userVo.setAge(user.getAge());
        userVo.setGender(user.getGender());
        userVo.setCreateTime(user.getCreateTime());
        userVo.setUpdateTime(user.getUpdateTime());*/
        BeanUtils.copyProperties(user, userVo);
        userVo.setPassword(null);

        return userVo;
    }

    public PagedDTO<UserVo> findUser(UserBo userBo) {
        PagedDTO<UserVo> userVoPagedDTO = new PagedDTO<>();
        List<UserVo> userVoList = new ArrayList<>();
        PagedDTO<User> userPagedDTO = userService.findUser(userBo);
        List<User> list = userPagedDTO.getList();
        if (CollectionUtil.notBlank(list)) {
            list.forEach(user -> {
                UserVo userVo = new UserVo();
                BeanUtils.copyProperties(user, userVo);
                userVoList.add(userVo);
            });
        }
        userVoPagedDTO.setTotalSize(userPagedDTO.getTotalSize());
        userVoPagedDTO.setPage(userPagedDTO.getPage());
        userVoPagedDTO.setPageSize(userPagedDTO.getPageSize());
        userVoPagedDTO.setList(userVoList);
        return userVoPagedDTO;
    }

    /**
     * add user
     *
     * @param userVo
     * @throws Exception
     */
    public void addUser(UserVo userVo) throws Exception {
        Date date = new Date();
        User user = new User();
        Random random = new Random();
        String uid = String.valueOf(random.nextInt(100) + 100) + (random.nextInt(100) + 100) + String.format("%02d", random.nextInt(100));
        System.out.println("UID:" + uid);
        user.setUid(uid);
        user.setUserName(userVo.getUserName());
        user.setAge(userVo.getAge());
        user.setPassword(userVo.getPassword());
        user.setGender(userVo.getGender());
        user.setAddress(userVo.getAddress());
        user.setUpdateTime(date);
        user.setCreateTime(date);

        userService.add(user);
    }

    /**
     * remove user by uid
     *
     * @param uid
     */
    public void removeUser(String uid) {
        userService.remove(uid);
    }

    /**
     * modify user
     *
     * @param userVo
     * @throws Exception
     */
    public void modifyUser(UserVo userVo) throws Exception {
        String uid = userVo.getUid();
        if (StringUtil.isBlank(uid)) {
            throw new RuntimeException("Uid 不能为空");
        }

        User user = userService.findUser(uid);
        BeanUtils.copyProperties(userVo, user);
        user.setUpdateTime(new Date());

        userService.update(user);
    }

    /**
     * query all user
     *
     * @return
     */
    public List<UserVo> queryAllUser() {
        List<UserVo> result = new ArrayList<>();
        List<User> userList = userService.queryAllUser();
        if (CollectionUtil.notBlank(userList)) {
            userList.forEach(user -> {
                UserVo userVo = new UserVo();
                BeanUtils.copyProperties(user, userVo);
                userVo.setPassword(null);
                result.add(userVo);
            });
        }
        return result;
    }

}
