package com.yulj.vehiclemanagement.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.yulj.common.core.config.JwtOperator;
import com.yulj.common.core.utils.*;
import com.yulj.model.notification.bo.NotificationAddBO;
import com.yulj.model.vehiclemanagement.VehicleRegisterInfo;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoAddBO;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoBO;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoUpdateBO;
import com.yulj.vehiclemanagement.feign.NotificationServiceFeignClient;
import com.yulj.vehiclemanagement.repository.VehicleRegisterInfoRepository;
import com.yulj.vehiclemanagement.service.IVehicleRegisterInfoService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Classname VehicleRegisterInfoServiceImpl
 * @Description <h1>车辆注册信息表业务逻辑层实现</h1>
 * @Author yulj
 * @Date: 2020/6/9 09:31
 */
@Service
@Slf4j
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
        Claims claims = getClaims();
        Object account = claims.get("account");
        if (Objects.nonNull(account)) {
            vehicleRegisterInfo.setCreatedBy(String.valueOf(account));
            vehicleRegisterInfo.setAgentUser(String.valueOf(account));
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

        Claims claims = getClaims();
        Object account = claims.get("account");
        if (Objects.nonNull(account)) {
            vehicleRegisterInfo.setUpdatedBy(String.valueOf(account));
            vehicleRegisterInfo.setAgentUser(String.valueOf(account));
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

    /**
     * 提前提醒天数，默认值为7
     */
    @Value("${pre.remind.days:7}")
    private Integer preRemindDays;

    @Autowired
    private NotificationServiceFeignClient notificationServiceFeignClient;

    @Override
    public Integer doVehicleJob() throws Exception {
        // 1. 查询车辆到检信息
        Map<Long, VehicleRegisterInfoBO> willAgentInspectionInfoMap = new HashMap<>();
        Collection<Long> willAgentInspectionInfoIds = new ArrayList<>();
        List<Map<String, Object>> willAgentInspectionObjects = this.vehicleRegisterInfoRepository.findWillAgentInspectionInfo(preRemindDays);
        for (Map<String, Object> object : willAgentInspectionObjects) {
            VehicleRegisterInfoBO vehicleRegisterInfoBO = MapUtil.mapToBean(object, VehicleRegisterInfoBO.class);
            willAgentInspectionInfoMap.put(vehicleRegisterInfoBO.getId(), vehicleRegisterInfoBO);
            willAgentInspectionInfoIds.add(vehicleRegisterInfoBO.getId());
        }
        log.info("车辆到检数量：{}", willAgentInspectionInfoMap.size());

        // 2. 查询车辆保险到期信息
        Map<Long, VehicleRegisterInfoBO> willAgentInsuranceInfoMap = new HashMap<>();
        Collection<Long> willAgentInsuranceInfoIds = new ArrayList<>();
        List<Map<String, Object>> willAgentInsuranceInfoObjects = this.vehicleRegisterInfoRepository.findWillAgentInsuranceInfo(preRemindDays);
        for (Map<String, Object> object : willAgentInsuranceInfoObjects) {
            VehicleRegisterInfoBO vehicleRegisterInfoBO = MapUtil.mapToBean(object, VehicleRegisterInfoBO.class);
            willAgentInsuranceInfoMap.put(vehicleRegisterInfoBO.getId(), vehicleRegisterInfoBO);
            willAgentInsuranceInfoIds.add(vehicleRegisterInfoBO.getId());
        }
        log.info("车辆保险到期数量：{}", willAgentInsuranceInfoMap.size());

        // 3. 信息合并处理
        // 车辆到检信息id与车辆保险到期信息id求交集，需同时提醒车辆到检和车辆保险到期
        Collection<Long> intersection = CollectionUtil.intersection(willAgentInspectionInfoIds, willAgentInsuranceInfoIds);
        // 车辆到检信息id与交集信息求差集
        willAgentInspectionInfoIds = CollectionUtil.disjunction(willAgentInspectionInfoIds, intersection);
        // 车辆保险到期信息id与交集信息求差集
        willAgentInsuranceInfoIds = CollectionUtil.disjunction(willAgentInsuranceInfoIds, intersection);

        // 4. 构建待插入的通知信息
        List<NotificationAddBO> notifications = new ArrayList<>();
        intersection.stream().forEach(
                id -> {
                    VehicleRegisterInfoBO willAgentInspectionInfo = willAgentInspectionInfoMap.get(id);
                    VehicleRegisterInfoBO willAgentInsuranceInfo = willAgentInsuranceInfoMap.get(id);
                    notifications.add(
                            NotificationAddBO.builder()
                                    .belongToUser(willAgentInspectionInfo.getAgentUser())
                                    .content(StrUtil.format("待办通知：客户姓名：{}，车型：{}，类型：车检到期、车险到期，" +
                                                    "距离车检到期天数：{}，距离车险到期天数：{}，联系电话：{}。",
                                            willAgentInspectionInfo.getCustomerRealName(), willAgentInspectionInfo.getVehicleInfo(),
                                            willAgentInspectionInfo.getDays(), willAgentInsuranceInfo.getDays(),
                                            willAgentInspectionInfo.getCustomerPhoneNumber()))
                                    .readStatus(Boolean.FALSE)
                                    .build());
                }
        );
        willAgentInspectionInfoIds.stream().forEach(
                id -> {
                    VehicleRegisterInfoBO info = willAgentInspectionInfoMap.get(id);
                    notifications.add(
                            NotificationAddBO.builder()
                                    .belongToUser(info.getAgentUser())
                                    .content(StrUtil.format("待办通知：客户姓名：{}，车型：{}，类型：车检到期，" +
                                                    "距离车检到期天数：{}，联系电话：{}。",
                                            info.getCustomerRealName(), info.getVehicleInfo(), info.getDays(),
                                            info.getCustomerPhoneNumber()))
                                    .readStatus(Boolean.FALSE)
                                    .build());
                }
        );
        willAgentInsuranceInfoIds.stream().forEach(
                id -> {
                    VehicleRegisterInfoBO info = willAgentInsuranceInfoMap.get(id);
                    notifications.add(
                            NotificationAddBO.builder()
                                    .belongToUser(info.getAgentUser())
                                    .content(StrUtil.format("待办通知：客户姓名：{}，车型：{}，类型：车险到期，" +
                                                    "距离车险到期天数：{}，联系电话：{}。",
                                            info.getCustomerRealName(), info.getVehicleInfo(), info.getDays(),
                                            info.getCustomerPhoneNumber()))
                                    .readStatus(Boolean.FALSE)
                                    .build());
                }
        );

        // 5. 调用通知服务，批量插入通知信息
        // TODO 服务间调用涉及分布式事务问题，可选择 TCC 或 两阶段提交等方案解决
        return this.notificationServiceFeignClient.batchInsert(notifications);
    }

    @Autowired
    private JwtOperator jwtOperator;

    /**
     * <h2>从JWT token中获取用户信息</h2>
     *
     * @return
     */
    private Claims getClaims() {
        HttpServletRequest request = HttpServletUtil.getRequest();
        String token = request.getHeader("X-Token");
        if (!StringUtils.isEmpty(token)) {
            return jwtOperator.getClaimsFromToken(token);
        }
        return null;
    }

}
