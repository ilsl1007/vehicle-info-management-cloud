package com.yulj.job.annotation;

import com.yulj.job.XxlJobAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Classname EnableXxlJob
 * @Description <h1>开启支持XXL-Job</h1>
 * @Author yulj
 * @Date: 2020/6/9 15:22
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({XxlJobAutoConfiguration.class})
public @interface EnableXxlJob {

}
