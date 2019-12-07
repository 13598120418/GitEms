package com.githubems.service;

import com.githubems.entity.User;

/**
 * Created by 康得辉 on 2019/12/7.
 */
public interface UserService {
    //登录
    User Login(User user);
    //添加
    void  regist(User user);
}
