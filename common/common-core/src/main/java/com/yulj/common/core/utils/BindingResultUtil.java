package com.yulj.common.core.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Classname BindingResultUtil
 * @Description <h1>BEAN业务对象校验工具类</h1>
 * @Author yulj
 * @Date: 2020/6/5 22:39
 */
public class BindingResultUtil {

    public static Map<String, String> getErrors(BindingResult result) {
        return result.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
    }

}
