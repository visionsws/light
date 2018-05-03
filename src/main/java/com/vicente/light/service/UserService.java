package com.vicente.light.service;


import com.vicente.light.entity.User;

import java.util.List;

/**
 * @author shiweisen
 * @since 2018-01-23
 */
public interface UserService {

    int saveUser(User user);

    int delUser(String id);

    User getUser(String id);

    List<User> listUser();
}
