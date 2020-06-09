package com.yulj.vehiclemanagement.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.yulj.vehiclemanagement.service.IVehicleRegisterInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @Classname VehicleInfoJob
 * @Description <h1>车辆登记信息相关任务</h1>
 * @Author yulj
 * @Date: 2020/6/9 17:26
 */
@Slf4j
@Component
public class VehicleInfoJob {

    @Autowired
    private IVehicleRegisterInfoService vehicleRegisterInfoService;

    @XxlJob("vehicleInfoJobHandler")
    public ReturnT<String> vehicleInfoJobHandler(String str) {
        Integer result = this.vehicleRegisterInfoService.doVehicleJob();
        log.info("任务执行完成，发送通知条数：{}", result);
        return SUCCESS;
    }

}
