package com.uzhizhe.service.impl;

import com.uzhizhe.beans.User;
import com.uzhizhe.beans.bo.UserBo;
import com.uzhizhe.beans.dto.PagedDTO;
import com.uzhizhe.dao.UserRepository;
import com.uzhizhe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
     * find user list
     *
     * @param userBo
     * @return
     */
    @Override
    public PagedDTO<User> findUser(UserBo userBo) {
        int page = userBo.getPage();
        int pageSize = userBo.getPageSize();
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = new PageRequest(page - 1, pageSize, sort);

        User user = new User();
        user.setUserName(userBo.getUserName());

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<User> example = Example.of(user, exampleMatcher);
        Page<User> userPage = userRepository.findAll(example, pageRequest);
        PagedDTO<User> pagedDTO = new PagedDTO<>();
        pagedDTO.setPage(page);
        pagedDTO.setPageSize(pageSize);
        pagedDTO.setTotalSize((int) userPage.getTotalElements());
        pagedDTO.setList(userPage.getContent());

        return pagedDTO;
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

    /**
     * remove
     *
     * @param uid
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void remove(String uid) {
        userRepository.removeByUid(uid);
    }

    /**
     * user
     *
     * @param user
     * @return
     */
    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    /**
     * query all user
     *
     * @return
     */
    @Override
    public List<User> queryAllUser() {
        return userRepository.findAll();
    }
}
