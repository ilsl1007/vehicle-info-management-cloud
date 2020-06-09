package com.yulj.vehiclemanagement.repository;

import com.yulj.model.vehiclemanagement.VehicleRegisterInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname VehicleRegisterInfoRepository
 * @Description <h1>车辆登记信息数据库访问层</h1>
 * @Author yulj
 * @Date: 2020/6/9 09:05
 */
public interface VehicleRegisterInfoRepository extends JpaRepository<VehicleRegisterInfo, Long> {

}
