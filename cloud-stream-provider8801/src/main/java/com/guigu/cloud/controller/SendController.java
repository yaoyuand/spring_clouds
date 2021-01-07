package com.guigu.cloud.controller;

import com.guigu.cloud.service.ISendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {
    @Autowired
    private ISendService sendService;

    @GetMapping("/send")
    public String send(){
        return this.sendService.send();
    }
}
