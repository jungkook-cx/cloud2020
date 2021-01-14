package com.cx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <h3>cloud2020</h3>
 * <p>restTemplate配置类</p>
 *
 * @author : chenxi
 * @date : 2020-12-28 17:22
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced//使用注解，开启负载均衡功能
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
 
