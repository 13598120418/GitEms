package com.githubems.service;

import com.githubems.dao.DepartDao;
import com.githubems.dao.UserDao;
import com.githubems.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

/**
 * Created by 康得辉 on 2019/12/7.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User Login(User user) {
        //判断用户是否存在
        User one1 = userDao.selectOne(new User().setUsername(user.getUsername()));
        System.out.println(one1);
        //将密码加盐
        String s = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        //
        user.setSalt(s);
        System.out.println(s);
        User one = userDao.selectOne(user);
        System.out.println(one);
        if(one1==null) throw new RuntimeException("用户不存在！");
        if(one==null) throw new RuntimeException("密码输入错误！");
        return one;
    }

    @Override
    @RequestMapping("regist")
    public void regist(User user) {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        user.setId(s);
        userDao.insert(user);
    }
}
