package com.cloud.guigu.controller;

import com.cloud.guigu.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/account/update")
    public void update(Long userId,Integer count){
        this.accountService.update(userId, count);
    }
}
