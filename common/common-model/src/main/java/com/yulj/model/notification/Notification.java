package com.yulj.model.notification;

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
 * @Classname Notification
 * @Description <h1>通知信息表数据库实体</h1>
 * @Author yulj
 * @Date: 2020/6/8 21:12
 */
@ApiModel(value = "通知信息表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "b_notification")
@EntityListeners(AuditingEntityListener.class)
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 通知内容
     */
    @ApiModelProperty(value = "通知内容")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    /**
     * 接收人
     */
    @ApiModelProperty(value = "接收人")
    private Long belongToUser;

    /**
     * 状态 0未读,1已读
     */
    @ApiModelProperty(value = "状态 0未读,1已读")
    private Boolean readStatus;

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