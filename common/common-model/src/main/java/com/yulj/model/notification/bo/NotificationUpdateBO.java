package com.yulj.model.notification.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Classname NotificationUpdateBO
 * @Description <h1>通知更新业务实体</h1>
 * @Author yulj
 * @Date: 2020/6/9 11:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "通知更新业务实体")
public class NotificationUpdateBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    @NotNull(message = "通知id不能为空")
    private Long id;

    /**
     * 通知内容
     */
    @ApiModelProperty(value = "通知内容")
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

}
