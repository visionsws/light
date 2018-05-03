package com.vicente.light.mapper;

import com.vicente.light.entity.LightEventLog;
import com.vicente.light.entity.LightEventLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LightEventLogMapper {
    long countByExample(LightEventLogExample example);

    int deleteByExample(LightEventLogExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(LightEventLog record);

    int insertSelective(LightEventLog record);

    List<LightEventLog> selectByExample(LightEventLogExample example);

    LightEventLog selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") LightEventLog record, @Param("example") LightEventLogExample example);

    int updateByExample(@Param("record") LightEventLog record, @Param("example") LightEventLogExample example);

    int updateByPrimaryKeySelective(LightEventLog record);

    int updateByPrimaryKey(LightEventLog record);
}