package com.cloud.guigu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    void update(@Param("userId") Long userId, @Param("count") Integer count);
}
