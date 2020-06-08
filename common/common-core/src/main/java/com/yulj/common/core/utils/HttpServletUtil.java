package com.yulj.common.core.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname HttpServletUtil
 * @Description <h1>HttpServlet工具类</h1>
 * @Author yulj
 * @Date: 2020/6/8 22:08
 */
public class HttpServletUtil {

    /**
     * <h2>获取ServletRequestAttributes对象</h2>
     */
    public static ServletRequestAttributes getServletRequest() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * <h2>获取HttpServletRequest对象</h2>
     */
    public static HttpServletRequest getRequest() {
        return getServletRequest().getRequest();
    }

    /**
     * <h2>获取HttpServletResponse对象</h2>
     */
    public static HttpServletResponse getResponse() {
        return getServletRequest().getResponse();
    }

    /**
     * <h2>获取请求参数</h2>
     */
    public static String getParameter(String param) {
        return getRequest().getParameter(param);
    }

    /**
     * <h2>获取请求参数，带默认值</h2>
     */
    public static String getParameter(String param, String defaultValue) {
        String parameter = getRequest().getParameter(param);
        return StringUtils.isEmpty(parameter) ? defaultValue : parameter;
    }

    /**
     * <h1>获取请求参数转换为int类型</h1>
     */
    public static Integer getParameterInt(String param) {
        return Integer.valueOf(getRequest().getParameter(param));
    }

    /**
     * <h1>获取请求参数转换为int类型，带默认值</h1>
     */
    public static Integer getParameterInt(String param, Integer defaultValue) {
        return Integer.valueOf(getParameter(param, String.valueOf(defaultValue)));
    }

}
