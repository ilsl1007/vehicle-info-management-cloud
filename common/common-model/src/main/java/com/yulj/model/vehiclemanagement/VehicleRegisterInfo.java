package com.yulj.model.vehiclemanagement;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Classname VehicleRegisterInfo
 * @Description <h1>车辆信息登记表数据库实体</h1>
 * @Author yulj
 * @Date: 2020/6/8 21:12
 */
@ApiModel(value = "车辆信息登记表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "b_vehicle_register_info")
@EntityListeners(AuditingEntityListener.class)
public class VehicleRegisterInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastInspectionDay;

    /**
     * 车险到期时间
     */
    @ApiModelProperty(value = "车险到期时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date insuranceExpiryDay;

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

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createdBy;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Date createdTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updatedBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @LastModifiedDate
    private Date updatedTime;

}