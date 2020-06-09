package com.yulj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname GatewayServiceApplication
 * @Description <h1>网关服务只启动程序</h1>
 * @Author yulj
 * @Date: 2020/6/9 17:03
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

}
