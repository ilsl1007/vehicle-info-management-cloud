package com.yulj.user.repository;

import com.yulj.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname UserRepository
 * @Description <h1>用户表数据库访问层</h1>
 * @Author yulj
 * @Date: 2020/6/8 21:46
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
