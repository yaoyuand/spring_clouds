package com.cloud.guigu.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {
    public static String handlerException(BlockException exception){
        return "限流被执行。。。。。";
    }
}
