package com.yulj.vehiclemanagement;

import com.yulj.job.annotation.EnableXxlJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Classname VehicleManagementServiceApplication
 * @Description <h1>车辆信息管理服务主启动程序</h1>
 * @Author yulj
 * @Date: 2020/6/8 19:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EntityScan(basePackages = "com.yulj.model.vehiclemanagement")
@EnableJpaRepositories(basePackages = "com.yulj.vehiclemanagement.repository")
@EnableJpaAuditing
@EnableXxlJob
@EnableFeignClients
public class VehicleManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleManagementServiceApplication.class, args);
    }

}
