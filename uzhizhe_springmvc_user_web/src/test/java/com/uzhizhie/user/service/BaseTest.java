package com.uzhizhie.user.service;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:dispatcher-servlet.xml"})
public class BaseTest {

    @Before
    public void before() {
        System.out.println(" ==>> 测试开始 <<==");
        System.out.println(" ==>> 测试开始 <<==");
        System.out.println(" ==>> 测试开始 <<==");
    }

    @After
    public void after() {
        System.out.println(" ==>> 测试结束 <<==");
        System.out.println(" ==>> 测试结束 <<==");
        System.out.println(" ==>> 测试结束 <<==");
    }
}
