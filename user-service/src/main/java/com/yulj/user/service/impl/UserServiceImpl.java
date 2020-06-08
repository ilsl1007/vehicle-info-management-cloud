package com.yulj.user.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PageSort;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.user.User;
import com.yulj.model.user.bo.UserAddBO;
import com.yulj.model.user.bo.UserUpdateBO;
import com.yulj.user.repository.UserRepository;
import com.yulj.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @Classname UserServiceImpl
 * @Description <h1>用户表业务逻辑层实现</h1>
 * @Author yulj
 * @Date: 2020/6/8 21:57
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PagedGridResult getPageList(User user) {
        // 创建匹配器，进行动态查询匹配
        ExampleMatcher matcher = ExampleMatcher.matching();

        // 获取用户列表
        Example<User> example = Example.of(user, matcher);
        PageRequest page = PageSort.pageRequest(Sort.Direction.ASC);
        Page<User> userPage = this.userRepository.findAll(example, page);

        return new PagedGridResult<>(userPage);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public JsonResult add(UserAddBO userAddBO) {
        User user = new User();
        BeanUtils.copyProperties(userAddBO, user);
        user.setPassword(SecureUtil.md5(userAddBO.getPassword()));
        User saveResult = this.userRepository.save(user);
        return JsonResult.ok(saveResult);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public JsonResult update(UserUpdateBO userUpdateBO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateBO, user);
        if (Objects.nonNull(userUpdateBO.getPassword())) {
            user.setPassword(SecureUtil.md5(userUpdateBO.getPassword()));
        }
        User saveResult = this.userRepository.save(user);
        return JsonResult.ok(saveResult);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public JsonResult delete(Long id) {
        this.userRepository.deleteById(id);
        return JsonResult.ok();
    }

}
