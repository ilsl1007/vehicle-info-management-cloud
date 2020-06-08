package com.yulj.vehiclemanagement;

import com.yulj.common.swagger.annotation.EnableSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname VehicleManagementServiceApplication
 * @Description <h1>车辆信息管理服务主启动程序</h1>
 * @Author yulj
 * @Date: 2020/6/8 19:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableSwagger2
public class VehicleManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleManagementServiceApplication.class, args);
    }

}