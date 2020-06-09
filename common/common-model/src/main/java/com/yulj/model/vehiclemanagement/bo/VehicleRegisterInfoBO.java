package com.yulj.model.vehiclemanagement.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname VehicleRegisterInfoBO
 * @Description <h1>车辆登记信息业务对象</h1>
 * @Author yulj
 * @Date: 2020/6/9 16:31
 */
@Data
public class VehicleRegisterInfoBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 代理人
     */
    private Long agentUser;

    /**
     * 客户姓名
     */
    private String customerRealName;

    /**
     * 车辆信息
     */
    private String vehicleInfo;

    /**
     * 客户电话
     */
    private String customerPhoneNumber;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 天数
     */
    private Integer days;

}
