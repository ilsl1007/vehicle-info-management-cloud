package com.yulj.model.user;

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
 * @Classname User
 * @Description <h1>系统用户表数据库实体</h1>
 * @Author yulj
 * @Date: 2020/6/8 21:12
 */
@ApiModel(value = "系统用户表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

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
    private Date createTime;

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