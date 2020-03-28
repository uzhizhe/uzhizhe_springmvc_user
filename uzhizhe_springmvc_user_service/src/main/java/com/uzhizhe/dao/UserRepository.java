package com.uzhizhe.dao;

import com.uzhizhe.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findFirstByUid(String uid);

}
