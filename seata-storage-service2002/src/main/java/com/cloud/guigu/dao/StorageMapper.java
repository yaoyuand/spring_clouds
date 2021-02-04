package com.cloud.guigu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {

    void update(@Param("productId") Long productId, @Param("count") Integer count);
}
