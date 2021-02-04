package com.cloud.guigu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/update")
    void update(@RequestParam("userId") Long userId, @RequestParam("count")Integer count);
}
