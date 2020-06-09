package com.yulj.model.vehiclemanagement.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Classname VehicleRegisterInfoAddBO
 * @Description <h1>车辆登记信息新增业务对象</h1>
 * @Author yulj
 * @Date: 2020/6/9 09:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleRegisterInfoAddBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    @NotBlank(message = "客户姓名不能为空")
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
    @NotBlank(message = "客户电话不能为空")
    @Length(min = 11, max = 11, message = "客户电话的长度必须是11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "客户电话格式有误")
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
