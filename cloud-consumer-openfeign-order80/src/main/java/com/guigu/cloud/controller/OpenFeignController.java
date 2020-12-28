package com.guigu.cloud.controller;

import com.guigu.cloud.entity.ResultData;
import com.guigu.cloud.service.OpenFignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignController {

    @Autowired
    private OpenFignService openFignService;

    @GetMapping("/feignClient/{id}")
    public ResultData selectById(@PathVariable("id")String id){
        return openFignService.selectById(id);
    }
}
