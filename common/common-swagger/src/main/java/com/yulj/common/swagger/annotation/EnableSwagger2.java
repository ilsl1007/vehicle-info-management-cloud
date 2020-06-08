package com.yulj.common.swagger.annotation;

import com.yulj.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Classname EnableSwagger2
 * @Description <h1>开启 Swagger 接口文档</h1>
 * @Author yulj
 * @Date: 2020/6/5 22:12
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableSwagger2 {
}
