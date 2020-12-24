package com.guigu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个类必须要写在不被 @ComponentScan 扫描的路径下面，不然所有的调用都会采用该配置
 *
 * 采用二种方法实现此功能:
 * 1.将该类不同添加springbootApplication注解的类放在同一个目录路径下面
 * 2.将该类放在添加springbootApplication注解类目录下面，但是添加一个注解，
 * 然后配置componentScan使添加该注解的类不被扫描到
 * */
@Configuration
public class MyRule {
    @Bean
    public IRule rule(){
        System.out.println("myRule被调用");
        return new RandomRule();
    }
}
