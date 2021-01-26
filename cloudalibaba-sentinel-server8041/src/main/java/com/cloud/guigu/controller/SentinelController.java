package com.cloud.guigu.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.guigu.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * SentinelResource中fallback和blockHandler
 * fallback和blockHandler作用相似，但是fallback拦截的是java运行时异常
 * blockHandler执行的是sentines限流时所配置的限流规则
 * */
@RestController
@RequestMapping("/sentinel")
@Slf4j
public class SentinelController {

    @GetMapping("/testA")
    public String testA(){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            log.error("线程出错:"+e.getMessage(),e);
        }
        return "---- testA";
    }

    @GetMapping("/testB")
    public String testB(){
        int i=10/0;
        return "---- testB";
    }

    @GetMapping("/testC")
    @SentinelResource(value = "testC",blockHandler = "handel")
    public String testC(@RequestParam(value = "p1",required = false) String p1, @RequestParam(value = "p2",required = false)String p2){
        log.info("进入数据信息");
        return "---- testC";
    }

    public String handel(String p1, String p2, BlockException e){
        log.info("进入热点拦截");
        return "QPS超出限制";
    }

    /**
     * 统一资源处理，不需要一个一个添加
     * */
    @GetMapping("/testD")
    @SentinelResource(value = "testD",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException")
    public String testD(){
        log.info("进入数据信息");
        return "---- testD";
    }
}
