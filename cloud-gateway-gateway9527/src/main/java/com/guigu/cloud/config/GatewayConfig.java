package com.guigu.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 以java方式配置gateway
 * */
@Configuration
public class GatewayConfig {

    /**
     * 简单路由配置
     * */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes=builder.routes();
        routes.route("gatewy_config",r->r.path("/payment/**").uri("http://localhost:8001/payment")).build();
        return routes.build();
    }
}
