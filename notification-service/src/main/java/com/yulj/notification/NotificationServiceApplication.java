package com.yulj.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Classname NotificationServiceApplication
 * @Description <h1>通知服务主启动程序</h1>
 * @Author yulj
 * @Date: 2020/6/8 19:54
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EntityScan(basePackages = "com.yulj.model.notification")
@EnableJpaRepositories(basePackages = "com.yulj.notification.repository")
@EnableJpaAuditing
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

}
