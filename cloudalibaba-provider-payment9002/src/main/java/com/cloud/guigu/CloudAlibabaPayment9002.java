package com.cloud.guigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用nacos进行服务注册(服务提供者)
 * 进行集群配置时如果在同一个网段中在填写cluster.conf内容时需要填写hostname -i查询出的ip值
 * 在云服务器上面或者不在同一网段中需要填写外网能够相互访问的ip
 * */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudAlibabaPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaPayment9002.class,args);
    }
}
