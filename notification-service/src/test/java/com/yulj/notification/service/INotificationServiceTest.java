package com.yulj.notification.service;

import cn.hutool.http.HttpStatus;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.notification.Notification;
import com.yulj.model.notification.bo.NotificationAddBO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Classname INotificationServiceTest
 * @Description <h1>通知信息业务逻辑层测试</h1>
 * @Author yulj
 * @Date: 2020/6/9 11:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class INotificationServiceTest {

    @Autowired
    private INotificationService notificationService;

    @Test
    public void getPageList() {
        PagedGridResult pageList = this.notificationService.getPageList(new Notification());
        pageList.getData().forEach(notification -> {
            log.info(notification.toString());
        });
    }

}