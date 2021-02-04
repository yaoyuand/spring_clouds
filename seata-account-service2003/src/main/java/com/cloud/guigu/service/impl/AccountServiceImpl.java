package com.cloud.guigu.service.impl;

import com.cloud.guigu.dao.AccountMapper;
import com.cloud.guigu.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Override
    public void update(Long userId, Integer count) {
        int num=10/0;
        this.accountMapper.update(userId,count);
    }
}
