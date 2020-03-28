package com.uzhizhe.beans;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
@Entity
@Table(name = "t_user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "varchar(128) comment 'UID'")
    private String uid;

    @Column(nullable = false, columnDefinition = "varchar(128) comment '用户名'")
    private String userName;

    @Column(nullable = false, columnDefinition = "varchar(128) comment '密码'")
    private String password;

    @Column(nullable = false, columnDefinition = "int(4) comment '性别 1:男 2:女 3:未知'")
    private Integer gender;

    @Column(nullable = false, columnDefinition = "int(11) comment '年龄'")
    private Integer age;

    @Column(nullable = false, columnDefinition = "varchar(256) comment '地址'")
    private String address;

    @Column(nullable = false, name = "create_time", columnDefinition = "datetime comment '创建时间'")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date createTime;

    @Column(nullable = false, name = "update_time", columnDefinition = "datetime comment '更新时间'")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateTime;
}







