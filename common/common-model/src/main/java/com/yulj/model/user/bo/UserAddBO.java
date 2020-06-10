package com.yulj.model.user.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Classname UserAddBO
 * @Description <h1>用户新增业务对象</h1>
 * @Author yulj
 * @Date: 2020/6/8 21:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户新增业务对象")
public class UserAddBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    @NotBlank(message = "账号不能为空")
    @Length(min = 1, max = 32, message = "账号的长度需在1到32之间")
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
    @NotBlank(message = "姓名不能为空")
    @Length(min = 1, max = 32, message = "姓名的长度需在1到32之间")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    @Length(min = 11, max = 11, message = "手机号的长度必须是11位")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phoneNumber;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱不符合规则")
    private String email;

}
