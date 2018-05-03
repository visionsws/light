package com.vicente.light.mapper;

import com.vicente.light.entity.SysPermission;
import com.vicente.light.entity.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper {
    long countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("example") SysPermissionExample example);
}