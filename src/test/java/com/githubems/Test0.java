package com.githubems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

/**
 * Created by 康得辉 on 2019/12/7.
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class Test0 {
    @Test
    public void test(){
        String s = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(s);
        String ss = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(ss);
    }


}
