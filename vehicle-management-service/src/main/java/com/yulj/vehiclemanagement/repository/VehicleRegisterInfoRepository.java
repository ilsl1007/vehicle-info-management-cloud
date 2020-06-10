package com.yulj.vehiclemanagement.repository;

import com.yulj.model.vehiclemanagement.VehicleRegisterInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @Classname VehicleRegisterInfoRepository
 * @Description <h1>车辆登记信息数据库访问层</h1>
 * @Author yulj
 * @Date: 2020/6/9 09:05
 */
public interface VehicleRegisterInfoRepository extends JpaRepository<VehicleRegisterInfo, Long> {

    /**
     * <h2>查询车辆到检信息</h2>
     *
     * @param preRemindDays 提前提醒天数
     * @return
     */
    @Query(value = "SELECT a.id,a.agent_user AS agentUser,a.customer_real_name AS customerRealName,a.vehicle_info AS vehicleInfo,a.customer_phone_number AS customerPhoneNumber,a.remarks,365 - DATEDIFF( now(), a.last_inspection_day ) AS days FROM b_vehicle_register_info a WHERE 365 - DATEDIFF( now(), a.last_inspection_day ) <= ?1", nativeQuery = true)
    List<Map<String, Object>> findWillAgentInspectionInfo(Integer preRemindDays);

    /**
     * <h2>查询车辆保险到期信息</h2>
     *
     * @param preRemindDays 提前提醒天数
     * @return
     */
    @Query(value = "SELECT a.id,a.agent_user AS agentUser,a.customer_real_name AS customerRealName,a.vehicle_info AS vehicleInfo,a.customer_phone_number AS customerPhoneNumber,a.remarks,DATEDIFF( a.insurance_expiry_day, now() ) AS days FROM b_vehicle_register_info a WHERE DATEDIFF( a.insurance_expiry_day, now() ) <= ?1", nativeQuery = true)
    List<Map<String, Object>> findWillAgentInsuranceInfo(Integer preRemindDays);

}
