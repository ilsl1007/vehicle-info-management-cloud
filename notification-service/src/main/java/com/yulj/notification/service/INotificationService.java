package com.yulj.notification.service;

import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.notification.Notification;
import com.yulj.model.notification.bo.NotificationAddBO;

import java.util.List;

/**
 * @Classname INotificationService
 * @Description <h1>通知信息业务逻辑层</h1>
 * @Author yulj
 * @Date: 2020/6/9 11:25
 */
public interface INotificationService {

    /**
     * <h2>获取分页列表数据</h2>
     *
     * @param notification 通知信息表查询对象
     * @return
     */
    PagedGridResult getPageList(Notification notification);

    /**
     * <h2>批量插入通知信息</h2>
     *
     * @param notificationAddBOList 通知信息新增业务对象集合
     * @return
     */
    Integer batchInsert(List<NotificationAddBO> notificationAddBOList);

}
