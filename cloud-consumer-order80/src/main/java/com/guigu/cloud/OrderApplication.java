package com.guigu.cloud;

import com.guigu.cloud.annotation.ExcludeComponScan;
import com.guigu.cloud.rule.MyRules;
import com.guigu.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * RibbonClient 注解的作用
 * name 配置 在eureka上面注册的服务名称
 * configuration 配置 自定义负载均衡类
 *
 * ComponentScan 注解配置有ExcludeComponScan注解的类不被加载也满足不被componentScan加载要求
 * */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
//@ComponentScan(excludeFilters={@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeComponScan.class)})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
