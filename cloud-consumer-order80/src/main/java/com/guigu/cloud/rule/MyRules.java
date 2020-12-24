package com.guigu.cloud.rule;

import com.guigu.cloud.annotation.ExcludeComponScan;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ExcludeComponScan 不被componentScan注解扫描到
 *
 * 修改默认方式负载均衡
 * */
@Configuration
@ExcludeComponScan
public class MyRules {

    @Bean
    public IRule rules(){
        return new RandomRule();
    }
}
