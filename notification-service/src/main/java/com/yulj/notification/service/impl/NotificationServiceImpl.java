package com.yulj.notification.service.impl;

import com.yulj.common.core.utils.PageSort;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.notification.Notification;
import com.yulj.model.notification.bo.NotificationAddBO;
import com.yulj.notification.repository.NotificationRepository;
import com.yulj.notification.service.INotificationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname NotificationServiceImpl
 * @Description <h1>通知信息业务逻辑层实现</h1>
 * @Author yulj
 * @Date: 2020/6/9 11:28
 */
@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PagedGridResult getPageList(Notification notification) {
        // 创建匹配器，进行动态查询匹配
        ExampleMatcher matcher = ExampleMatcher.matching();

        // 获取车辆注册信息列表
        Example<Notification> example = Example.of(notification, matcher);
        PageRequest page = PageSort.pageRequest(Sort.Direction.ASC);
        Page<Notification> notificationPage = this.notificationRepository.findAll(example, page);

        return new PagedGridResult<>(notificationPage);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer batchInsert(List<NotificationAddBO> notificationAddBOList) {
        List<Notification> notificationList = new ArrayList<>();
        notificationAddBOList.forEach(notificationAddBO -> {
            Notification notification = new Notification();
            BeanUtils.copyProperties(notificationAddBO, notification);
            // 由于源请求未传递 Token，所以无法获取当前登录用户，执行任务创建通知信息的创建人设置为 admin。
            notification.setCreatedBy("admin");
            notificationList.add(notification);
        });
        if (CollectionUtils.isEmpty(notificationList)) {
            return 0;
        }
        return this.notificationRepository.saveAll(notificationList).size();
    }

}
