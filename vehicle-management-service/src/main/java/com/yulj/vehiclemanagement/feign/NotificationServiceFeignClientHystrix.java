package com.yulj.vehiclemanagement.feign;

import com.yulj.model.notification.bo.NotificationAddBO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname NotificationServiceFeignClientHystrix
 * @Description <h1>通知服务 FeignClient 熔断降级</h1>
 * @Author yulj
 * @Date: 2020/6/9 21:48
 */
@Component
public class NotificationServiceFeignClientHystrix implements NotificationServiceFeignClient {

    @Override
    public Integer batchInsert(List<NotificationAddBO> notificationAddBOList) {
        return 0;
    }

}
