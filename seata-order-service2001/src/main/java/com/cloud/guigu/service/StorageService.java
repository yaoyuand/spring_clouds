package com.cloud.guigu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/update")
    void update(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
