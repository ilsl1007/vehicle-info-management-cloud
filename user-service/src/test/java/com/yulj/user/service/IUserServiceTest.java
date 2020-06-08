package com.yulj.user.service;

import cn.hutool.http.HttpStatus;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.user.User;
import com.yulj.model.user.bo.UserAddBO;
import com.yulj.model.user.bo.UserUpdateBO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Classname IUserServiceTest
 * @Description <h1>用户表业务逻辑层测试</h1>
 * @Author yulj
 * @Date: 2020/6/8 22:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void getPageList() {
        PagedGridResult pageList = userService.getPageList(new User());
        log.info("pageList={}", pageList);
    }

    @Test
    public void add() {
        UserAddBO userAddBO = UserAddBO.builder()
                .account("test")
                .email("test@xxx.com")
                .password("123456")
                .phoneNumber("15557654321")
                .realName("测试")
                .build();
        JsonResult jsonResult = this.userService.add(userAddBO);
        Assert.assertEquals(HttpStatus.HTTP_OK, jsonResult.getStatus());
    }

    @Test
    public void update() {
        UserUpdateBO userUpdateBO = UserUpdateBO.builder()
                .id(1L)
                .account("test1")
                .email("test1@xxx.com")
                .password("123456")
                .phoneNumber("15557654321")
                .realName("测试")
                .build();
        JsonResult jsonResult = this.userService.update(userUpdateBO);
        Assert.assertEquals(HttpStatus.HTTP_OK, jsonResult.getStatus());
    }

    @Test
    public void delete() {
        JsonResult jsonResult = this.userService.delete(1L);
        Assert.assertEquals(HttpStatus.HTTP_OK, jsonResult.getStatus());
    }

}