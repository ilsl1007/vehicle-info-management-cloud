package com.yulj.vehiclemanagement.feign;

import com.yulj.model.notification.bo.NotificationAddBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Classname NotificationServiceFeignClient
 * @Description <h1>通知服务 FeignClient </h1>
 * @Author yulj
 * @Date: 2020/6/9 21:43
 */
@FeignClient(value = "notification-service", name = "notification-service", fallback = NotificationServiceFeignClientHystrix.class)
public interface NotificationServiceFeignClient {

    /**
     * <h2>批量插入通知信息</h2>
     *
     * @param notificationAddBOList 通知信息新增业务对象集合
     * @return
     */
    @PostMapping("/notification/batchInsert")
    Integer batchInsert(@RequestBody List<NotificationAddBO> notificationAddBOList);

}
