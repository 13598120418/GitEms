package com.githubems;

import com.githubems.dao.UserDao;
import com.githubems.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

/**
 * Created by 康得辉 on 2019/12/7.
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class Test0 {
    @Autowired
    private UserDao userDao;
    @Test
    public void test(){
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
        String ss = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(ss);
    }
    @Test
    public void test1(){
        User admin = new User().setUsername("admin1").setPassword("123456");
        String s = DigestUtils.md5DigestAsHex(admin.getPassword().getBytes());
        admin.setPassword(s);
        System.out.println(admin);
        User one = userDao.selectOne(admin);
        System.out.println(one);

    }

}
