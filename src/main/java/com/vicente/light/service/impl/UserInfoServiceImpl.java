package com.vicente.light.service.impl;

import com.vicente.light.entity.SysPermission;
import com.vicente.light.entity.SysPermissionExample;
import com.vicente.light.entity.SysRole;
import com.vicente.light.entity.SysRoleExample;
import com.vicente.light.entity.SysRolePermission;
import com.vicente.light.entity.SysRolePermissionExample;
import com.vicente.light.entity.SysUserRole;
import com.vicente.light.entity.SysUserRoleExample;
import com.vicente.light.entity.UserInfo;
import com.vicente.light.entity.UserInfoExample;
import com.vicente.light.mapper.SysPermissionMapper;
import com.vicente.light.mapper.SysRoleMapper;
import com.vicente.light.mapper.SysRolePermissionMapper;
import com.vicente.light.mapper.SysUserRoleMapper;
import com.vicente.light.mapper.UserInfoMapper;
import com.vicente.light.service.UserInfoService;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UserInfo> list = userInfoMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<SysRole> findByUserId(String uid) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUidEqualTo(uid);
        List<SysUserRole> list = sysUserRoleMapper.selectByExample(example);
        List<Integer> roleIds = new ArrayList<>();
        for (SysUserRole userRole : list){
            roleIds.add(userRole.getRoleId());
        }
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andIdIn(roleIds);
        return sysRoleMapper.selectByExample(roleExample);
    }

    @Override
    public List<SysPermission> findByRoleId(Integer roleId) {
        SysRolePermissionExample example = new SysRolePermissionExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<SysRolePermission> list = sysRolePermissionMapper.selectByExample(example);
        List<Integer> permIds = new ArrayList<>();
        for (SysRolePermission rolePermission : list){
            permIds.add(rolePermission.getPermissionId());
        }
        SysPermissionExample permExample = new SysPermissionExample();
        permExample.createCriteria().andIdIn(permIds);
        return sysPermissionMapper.selectByExample(permExample);
    }
}