package com.githubems.service;

import com.githubems.dao.DepartDao;
import com.githubems.dao.UserDao;
import com.githubems.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        User one = userDao.selectOne(user);
        //判断用户是否存在
        if(!one.getUsername().equals(user.getUsername())) throw new RuntimeException("用户不存在！");
        if(!one.getPassword().equals(user.getPassword())) throw new RuntimeException("密码输入错误！");
        return one;
    }

    @Override
    public void regist(User user) {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        user.setId(s);
        userDao.insert(user);
    }
}
