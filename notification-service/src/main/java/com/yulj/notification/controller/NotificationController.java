package com.yulj.notification.controller;

import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.notification.Notification;
import com.yulj.model.notification.bo.NotificationAddBO;
import com.yulj.notification.service.INotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname NotificationController
 * @Description <h1>通知信息控制器</h1>
 * @Author yulj
 * @Date: 2020/6/9 13:36
 */
@RestController
@RequestMapping("/notification")
@Api(value = "通知信息相关接口", tags = "通知信息")
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @ApiOperation(value = "分页查询通知信息", notes = "分页查询通知信息")
    @GetMapping("/list")
    public PagedGridResult list(Notification notification) {
        return this.notificationService.getPageList(notification);
    }

    /**
     * <h2>批量插入通知信息</h2>
     *
     * @param notificationAddBOList 通知信息新增业务对象集合
     * @return
     */
    @PostMapping("/batchInsert")
    public Integer batchInsert(@RequestBody List<NotificationAddBO> notificationAddBOList) {
        return this.notificationService.batchInsert(notificationAddBOList);
    }

}
