package com.yulj.job.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname XxlJobProperties
 * @Description <h1>xxl-job主配置</h1>
 * @Author yulj
 * @Date: 2020/6/9 15:27
 */
@Data
@Component
@ConfigurationProperties(prefix = "xxl.job")
public class XxlJobProperties {

    private XxlAdminProperties admin = new XxlAdminProperties();

    private XxlExecutorProperties executor = new XxlExecutorProperties();

}
