package com.uzhizhe.user.web.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
@Data
public class UserVo implements Serializable {

    private String uid;
    private String userName;
    private String password;
    private Integer gender;
    private Integer age;
    private String address;
    private Date createTime;
    private Date updateTime;

}
