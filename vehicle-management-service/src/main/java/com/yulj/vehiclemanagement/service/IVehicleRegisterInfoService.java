package com.yulj.vehiclemanagement.service;

import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.vehiclemanagement.VehicleRegisterInfo;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoAddBO;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoUpdateBO;

/**
 * @Classname IVehicleRegisterInfoService
 * @Description <h1>车辆注册信息表业务逻辑层</h1>
 * @Author yulj
 * @Date: 2020/6/9 09:09
 */
public interface IVehicleRegisterInfoService {

    /**
     * <h2>获取分页列表数据</h2>
     *
     * @param vehicleRegisterInfo 车辆注册信息表查询对象
     * @return
     */
    PagedGridResult getPageList(VehicleRegisterInfo vehicleRegisterInfo);

    /**
     * <h2>新增用户</h2>
     *
     * @param vehicleRegisterInfoAddBO 车辆注册信息新增业务对象
     * @return
     */
    JsonResult add(VehicleRegisterInfoAddBO vehicleRegisterInfoAddBO);

    /**
     * <h2>更新用户</h2>
     *
     * @param vehicleRegisterInfoUpdateBO 车辆注册信息更新业务对象
     * @return
     */
    JsonResult update(VehicleRegisterInfoUpdateBO vehicleRegisterInfoUpdateBO);

    /**
     * <h2>删除车辆注册信息</h2>
     *
     * @param id 车辆注册信息id
     * @return
     */
    JsonResult delete(Long id);

    /**
     * <h2>执行车辆信息相关任务</h2>
     *
     * @return
     */
    Integer doVehicleJob();

}
