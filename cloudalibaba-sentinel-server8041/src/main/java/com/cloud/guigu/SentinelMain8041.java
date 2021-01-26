package com.cloud.guigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * sentinel持久化配置
 * 1.pom中添加jar
 * 2.yml添加nacos数据源配置
 * 3.在nacos中添加配置管理
 * [{
 *     "resource":"/sentinel/testA",
 *     "limitApp":"default",
 *     "grade":1,
 *     "count":1,
 *     "strategy":0,
 *     "controlBehavior":0,
 *     "clusterMode":false
 * }]
 * resource:资源名称;
 * limitApp:来源应用;
 * grade:阈值类型，0表示线程数，1表示QPS
 * count:单机阈值
 * strategy:流控模式,0表示直接,1表示关联,2表示链路;
 * controlBehavior:流控结果,0表示快速失败,1表示Warm Up,2表示排队等待;
 * clusterMode:是否集群
 * */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8041 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8041.class,args);
    }
}
