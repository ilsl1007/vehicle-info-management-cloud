package com.yulj.notification.service;

import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.notification.Notification;
import com.yulj.model.notification.bo.NotificationAddBO;
import com.yulj.model.notification.bo.NotificationUpdateBO;

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
     * <h2>新增通知信息</h2>
     *
     * @param notificationAddBO 通知信息新增业务对象
     * @return
     */
    JsonResult add(NotificationAddBO notificationAddBO);

    /**
     * <h2>更新通知信息</h2>
     *
     * @param notificationUpdateBO 通知信息更新业务对象
     * @return
     */
    JsonResult update(NotificationUpdateBO notificationUpdateBO);

    /**
     * <h2>删除通知信息</h2>
     *
     * @param id 通知信息id
     * @return
     */
    JsonResult delete(Long id);

}
