package com.uzhizhe.beans.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBo implements Serializable {
    private static final long serialVersionUID = 2103519898304386485L;
    private Integer page = 1;
    private Integer pageSize = 10;
    private String userName;
    private String uid;
    private Integer age;
    private Integer gender;

}
