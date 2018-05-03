package com.vicente.light.service;

import com.vicente.light.entity.SysPermission;
import com.vicente.light.entity.SysRole;
import com.vicente.light.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    /**通过username查找用户信息;*/
    UserInfo findByUsername(String username);

    List<SysRole> findByUserId(String uid);

    List<SysPermission> findByRoleId(Integer roleId);

}