package com.yulj.vehiclemanagement.intercepor;

import com.yulj.common.core.utils.HttpServletUtil;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname TokenRelayRequestIntecepor
 * @Description <h1>Feign调用Token传递拦截器</h1>
 * @Author yulj
 * @Date: 2020/6/10 20:35
 */
@Configuration
public class TokenRelayRequestIntercepor {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            // 1. 获取到 Token
            HttpServletRequest request = HttpServletUtil.getRequest();
            String token = request.getHeader("X-Token");

            // 2. 将 Token 传递
            if (!StringUtils.isEmpty(token)) {
                template.header("X-Token", token);
            }
        };
    }

}
