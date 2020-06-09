package com.yulj.model.notification.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Classname NotificationAddBO
 * @Description <h1>通知信息新增业务实体</h1>
 * @Author yulj
 * @Date: 2020/6/9 11:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "通知新增业务实体")
public class NotificationAddBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 通知内容
     */
    @ApiModelProperty(value = "通知内容")
    @NotBlank(message = "通知内容不能为空")
    private String content;

    /**
     * 接收人
     */
    @ApiModelProperty(value = "接收人")
    @NotNull(message = "接收人不能为空")
    private Long belongToUser;

    /**
     * 状态 0未读,1已读
     */
    @ApiModelProperty(value = "状态 0未读,1已读")
    @NotNull(message = "状态不能为空")
    private Boolean readStatus;

}
