package com.vicente.light.service.impl;


import com.vicente.light.entity.User;
import com.vicente.light.entity.UserExample;
import com.vicente.light.mapper.UserMapper;
import com.vicente.light.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiweisen
 * @since 2018-01-23
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    @Override
    public int saveUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delUser(String id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getUser(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null){
            throw new NullPointerException("Service NullPointerException.");
        }
        return user;
    }

    @Override
    public List<User> listUser() {
        UserExample example = new UserExample();
        return userMapper.selectByExample(example);
    }
}
