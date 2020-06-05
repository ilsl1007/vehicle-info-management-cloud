package com.yulj.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Classname RegisterCenterApplication
 * @Description <h1>注册中心主启动程序</h1>
 * @Author yulj
 * @Date: 2020/6/5 21:10
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterCenterApplication.class, args);
    }

}
