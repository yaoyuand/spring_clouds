package com.cloud.guigu.controller;

import com.cloud.guigu.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StorageController {

    @Autowired
    private StorageService storageService;
    @RequestMapping("/storage/update")
    public void update(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.update(productId, count);
    }
}
