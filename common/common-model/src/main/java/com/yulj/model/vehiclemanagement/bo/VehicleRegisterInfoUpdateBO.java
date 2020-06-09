package com.yulj.model.vehiclemanagement.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Classname VehicleRegisterInfoUpdateBO
 * @Description <h1>车辆登记信息更新业务对象</h1>
 * @Author yulj
 * @Date: 2020/6/9 09:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleRegisterInfoUpdateBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @NotNull(message = "车辆登记信息id不能为空")
    private Long id;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerRealName;

    /**
     * 车辆信息
     */
    @ApiModelProperty(value = "车辆信息")
    private String vehicleInfo;

    /**
     * 客户电话
     */
    @ApiModelProperty(value = "客户电话")
    private String customerPhoneNumber;

    /**
     * 上次车检时间
     */
    @ApiModelProperty(value = "上次车检时间")
    private String lastInspectionDay;

    /**
     * 车险到期时间
     */
    @ApiModelProperty(value = "车险到期时间")
    private String insuranceExpiryDay;

    /**
     * 代理人
     */
    @ApiModelProperty(value = "代理人")
    private Long agentUser;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

}
