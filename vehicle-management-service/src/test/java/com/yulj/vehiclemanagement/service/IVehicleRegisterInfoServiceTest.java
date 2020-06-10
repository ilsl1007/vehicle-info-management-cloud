package com.yulj.vehiclemanagement.service;

import cn.hutool.http.HttpStatus;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.vehiclemanagement.VehicleRegisterInfo;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoAddBO;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoUpdateBO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Classname IVehicleRegisterInfoServiceTest
 * @Description <h1>车辆注册信息表业务逻辑层实现测试</h1>
 * @Author yulj
 * @Date: 2020/6/9 10:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IVehicleRegisterInfoServiceTest {

    @Autowired
    private IVehicleRegisterInfoService vehicleRegisterInfoService;

    @Test
    public void getPageList() {
        PagedGridResult pageList = this.vehicleRegisterInfoService.getPageList(new VehicleRegisterInfo());
        pageList.getData().forEach(vehicleRegisterInfo -> {
            log.info(vehicleRegisterInfo.toString());
        });
    }

    @Test
    public void add() {
        VehicleRegisterInfoAddBO vehicleRegisterInfoAddBO = VehicleRegisterInfoAddBO.builder()
                .vehicleInfo("Audi A4L")
                .customerRealName("张三")
                .customerPhoneNumber("1554567678")
                .insuranceExpiryDay("2021-06-09")
                .lastInspectionDay("2020-06-09")
                .remarks("test remarks...")
                .build();
        JsonResult jsonResult = this.vehicleRegisterInfoService.add(vehicleRegisterInfoAddBO);
        Assert.assertEquals(HttpStatus.HTTP_OK, jsonResult.getStatus());
    }

    @Test
    public void update() {
        VehicleRegisterInfoUpdateBO vehicleRegisterInfoUpdateBO = VehicleRegisterInfoUpdateBO.builder()
                .id(1L)
                .vehicleInfo("Audi A6L")
                .customerRealName("张三")
                .customerPhoneNumber("1554567678")
                .insuranceExpiryDay("2021-06-09")
                .lastInspectionDay("2020-06-09")
                .remarks("test remarks...")
                .build();
        JsonResult jsonResult = this.vehicleRegisterInfoService.update(vehicleRegisterInfoUpdateBO);
        Assert.assertEquals(HttpStatus.HTTP_OK, jsonResult.getStatus());
    }

    @Test
    public void delete() {
        JsonResult jsonResult = this.vehicleRegisterInfoService.delete(1L);
        Assert.assertEquals(HttpStatus.HTTP_OK, jsonResult.getStatus());
    }

}