package com.vicente.light.service;

import com.vicente.light.LightApplication;
import com.vicente.light.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author shiweisen
 * @since 2018-01-23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { LightApplication.class })
public class UserServiceImplTest {

    @Autowired
    private UserService userServiceImpl;

    @Test
    public void saveUser() throws Exception {
    }

    @Test
    public void delUser() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
        String id = "1231";
        User user = userServiceImpl.getUser(id);
        System.out.println(user);
    }

    @Test
    public void listUser() throws Exception {
    }

}