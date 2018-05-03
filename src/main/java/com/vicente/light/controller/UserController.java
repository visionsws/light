package com.vicente.light.controller;

import com.vicente.light.dto.ResponseDto;
import com.vicente.light.dto.UserDto;
import com.vicente.light.entity.User;
import com.vicente.light.myconfig.MyCustomer;
import com.vicente.light.service.UserService;
import com.vicente.light.util.ResultUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @author shiweisen
 * @since 2018-01-23
 */
@RestController
@RequestMapping(value = "/user")
@Api(description = "userController相关api")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService aaadlfjdl;

    @Autowired
    private MyCustomer myCustomer;

    @Value("${my.customer.password}")
    private String password;

    @Value("${my.customer.phone}")
    private String phone;

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String")
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public ResponseDto getUser(String id){
        return ResultUtil.success(aaadlfjdl.getUser(id));
    }

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    public ResponseDto listUser(){
        String id = myCustomer.getId();
        String name = myCustomer.getName();
        logger.info("id:{},name:{},password:{},phone:{}",id,name,password,phone);
        return ResultUtil.success(aaadlfjdl.listUser());
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @PostMapping(value = "/saveUser")
    public ResponseDto saveUser(@RequestBody @Validated UserDto userDto){
        User user =new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        System.out.println(userDto.getIsFlag());
        aaadlfjdl.saveUser(user);
        return ResultUtil.success("save success");
    }

    @ApiOperation(value="获取列表", notes="获取列表")
    @RequestMapping(value = "/getRebu",method = RequestMethod.GET)
    public ResponseDto getRebu(){
        return ResultUtil.success("rebu kkkkkkk");
    }
}
