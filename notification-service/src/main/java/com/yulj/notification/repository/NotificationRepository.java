package com.yulj.notification.repository;

import com.yulj.model.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname NotificationRepository
 * @Description <h1>通知信息数据库访问层</h1>
 * @Author yulj
 * @Date: 2020/6/9 11:23
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
