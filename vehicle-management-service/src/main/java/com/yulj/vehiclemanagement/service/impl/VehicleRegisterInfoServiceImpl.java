package com.yulj.vehiclemanagement.service.impl;

import cn.hutool.core.date.DateUtil;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PageSort;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.vehiclemanagement.VehicleRegisterInfo;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoAddBO;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoUpdateBO;
import com.yulj.vehiclemanagement.repository.VehicleRegisterInfoRepository;
import com.yulj.vehiclemanagement.service.IVehicleRegisterInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @Classname VehicleRegisterInfoServiceImpl
 * @Description <h1>车辆注册信息表业务逻辑层实现</h1>
 * @Author yulj
 * @Date: 2020/6/9 09:31
 */
@Service
public class VehicleRegisterInfoServiceImpl implements IVehicleRegisterInfoService {

    @Autowired
    private VehicleRegisterInfoRepository vehicleRegisterInfoRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PagedGridResult getPageList(VehicleRegisterInfo vehicleRegisterInfo) {
        // 创建匹配器，进行动态查询匹配
        ExampleMatcher matcher = ExampleMatcher.matching();

        // 获取车辆注册信息列表
        Example<VehicleRegisterInfo> example = Example.of(vehicleRegisterInfo, matcher);
        PageRequest page = PageSort.pageRequest(Sort.Direction.ASC);
        Page<VehicleRegisterInfo> vehicleRegisterInfoPage = this.vehicleRegisterInfoRepository.findAll(example, page);

        return new PagedGridResult<>(vehicleRegisterInfoPage);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public JsonResult add(VehicleRegisterInfoAddBO vehicleRegisterInfoAddBO) {
        VehicleRegisterInfo vehicleRegisterInfo = new VehicleRegisterInfo();
        BeanUtils.copyProperties(vehicleRegisterInfoAddBO, vehicleRegisterInfo);
        // 车险到期时间转换
        if (!StringUtils.isEmpty(vehicleRegisterInfoAddBO.getInsuranceExpiryDay())) {
            vehicleRegisterInfo.setInsuranceExpiryDay(DateUtil.parseDate(vehicleRegisterInfoAddBO.getInsuranceExpiryDay()));
        }
        // 上次车检时间转换
        if (!StringUtils.isEmpty(vehicleRegisterInfoAddBO.getLastInspectionDay())) {
            vehicleRegisterInfo.setLastInspectionDay(DateUtil.parseDate(vehicleRegisterInfoAddBO.getLastInspectionDay()));
        }
        VehicleRegisterInfo saveResult = this.vehicleRegisterInfoRepository.save(vehicleRegisterInfo);
        return JsonResult.ok(saveResult);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public JsonResult update(VehicleRegisterInfoUpdateBO vehicleRegisterInfoUpdateBO) {
        VehicleRegisterInfo vehicleRegisterInfo = new VehicleRegisterInfo();
        BeanUtils.copyProperties(vehicleRegisterInfoUpdateBO, vehicleRegisterInfo);
        // 车险到期时间转换
        if (!StringUtils.isEmpty(vehicleRegisterInfoUpdateBO.getInsuranceExpiryDay())) {
            vehicleRegisterInfo.setInsuranceExpiryDay(DateUtil.parseDate(vehicleRegisterInfoUpdateBO.getInsuranceExpiryDay()));
        }
        // 上次车检时间转换
        if (!StringUtils.isEmpty(vehicleRegisterInfoUpdateBO.getLastInspectionDay())) {
            vehicleRegisterInfo.setLastInspectionDay(DateUtil.parseDate(vehicleRegisterInfoUpdateBO.getLastInspectionDay()));
        }
        VehicleRegisterInfo saveResult = this.vehicleRegisterInfoRepository.save(vehicleRegisterInfo);
        return JsonResult.ok(saveResult);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public JsonResult delete(Long id) {
        this.vehicleRegisterInfoRepository.deleteById(id);
        return JsonResult.ok();
    }

}
