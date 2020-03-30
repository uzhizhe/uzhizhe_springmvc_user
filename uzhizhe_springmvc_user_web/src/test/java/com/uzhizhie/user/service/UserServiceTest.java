package com.uzhizhie.user.service;

import com.uzhizhe.beans.User;
import com.uzhizhe.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;


    @Test
    public void test26() throws Exception {
        User user = userService.findUser("123");
        System.out.println("user =:" + user);
    }

    @Test
    public void test33() throws Exception {

        List<String> firstNameList = Arrays.asList("张", "王", "李", "赵", "周", "吴", "郑", "杜", "冯");
        List<String> lastNameList = Arrays.asList("克强", "鹏飞", "超强", "淑芬", "永乐", "远超", "志远", "新波");
        List<String> phoneList = Arrays.asList(
                "18339922767", "15836927277", "13646791280", "18399227867", "13179873432",
                "18339224367", "15836926667", "13646791444", "18399227444", "13179873434",
                "18339345767", "15834557277", "13646791335", "18399227666", "13179873498");

        List<String> cityList = Arrays.asList("洛阳市", "郑州市", "南阳市", "信阳市", "鹤壁市", "周口市", "商丘市");

        Random random = new Random();
        for (int i = 1; i < phoneList.size(); i++) {
            int firstName = new Random().nextInt(firstNameList.size());
            int lastName = new Random().nextInt(lastNameList.size());

            String first = firstNameList.get(firstName);
            String last = lastNameList.get(lastName);

            String userName = first + last;

            Date date = new Date();
            User user = new User();
            user.setUid(1000 + i + "");
            user.setUserName(userName);
            user.setAge(new Random().nextInt(15) + 15);

            user.setAddress("河南省" + cityList.get(random.nextInt(cityList.size())));
            user.setGender(new Random().nextInt(2) + 1);
            user.setPassword("123456");
            user.setCreateTime(date);
            user.setUpdateTime(date);

            User save = userService.add(user);
            System.out.println("Save:" + save);

        }
    }

    @Test
    public void test78() throws Exception {
        userService.remove("1012");
    }

}
