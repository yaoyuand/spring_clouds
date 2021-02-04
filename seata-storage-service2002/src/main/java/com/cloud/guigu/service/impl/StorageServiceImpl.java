package com.cloud.guigu.service.impl;

import com.cloud.guigu.dao.StorageMapper;
import com.cloud.guigu.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;
    @Override
    public void update(Long productId, Integer count) {
        this.storageMapper.update(productId, count);
    }
}
