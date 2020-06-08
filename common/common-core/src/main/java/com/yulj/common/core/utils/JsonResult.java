package com.yulj.common.core.utils;

import cn.hutool.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname JSONResult
 * @Description: <p>自定义响应数据结构
 * 本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 * 200：表示成功
 * 401：表示无效的token
 * 500：表示发生错误，错误信息在msg字段中
 * 512：表示bean验证错误，不管多少个错误都以map形式返回
 * @Author yulj
 * @Date: 2020/6/5 22:44
 */
@Data
@ApiModel(value = "响应信息主体")
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult {

    public static final Integer BEAN_VALIDATION_ERROR = 512;

    /**
     * 响应业务状态
     */
    @ApiModelProperty(value = "响应业务状态：200:成功，401:无效的token，500:错误，512:bean验证错误")
    private int status;

    /**
     * 响应消息
     */
    @ApiModelProperty(value = "响应消息")
    private String msg;

    /**
     * 响应中的数据
     */
    @ApiModelProperty(value = "响应中的数据")
    private Object data;

    @JsonIgnore
    private String ok;

    public static JsonResult build(int status, String msg, Object data) {
        return new JsonResult(status, msg, data);
    }

    public static JsonResult build(int status, String msg, Object data, String ok) {
        return new JsonResult(status, msg, data, ok);
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return new JsonResult(null);
    }

    public static JsonResult errorMsg(String msg) {
        return new JsonResult(HttpStatus.HTTP_INTERNAL_ERROR, msg, null);
    }

    public static JsonResult errorTokenMsg(String msg) {
        return new JsonResult(HttpStatus.HTTP_UNAUTHORIZED, msg, null);
    }

    public static JsonResult errorMap(Object data) {
        return new JsonResult(BEAN_VALIDATION_ERROR, "bean validation error", data);
    }

    public JsonResult(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.status = HttpStatus.HTTP_OK;
        this.msg = "OK";
        this.data = data;
    }

}
