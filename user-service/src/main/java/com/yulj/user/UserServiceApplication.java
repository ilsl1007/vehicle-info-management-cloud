package com.yulj.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Classname UserCenterApplication
 * @Description <h1>用户中心主启动程序</h1>
 * @Author yulj
 * @Date: 2020/6/5 22:55
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EntityScan(basePackages = "com.yulj.model.user")
@EnableJpaRepositories(basePackages = "com.yulj.user.repository")
@EnableJpaAuditing
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
