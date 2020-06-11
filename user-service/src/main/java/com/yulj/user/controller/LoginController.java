package com.yulj.user.controller;

import com.yulj.common.core.utils.BindingResultUtil;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.model.user.bo.UserLoginBO;
import com.yulj.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Classname LoginController
 * @Description <h1>用户认证相关接口</h1>
 * @Author yulj
 * @Date: 2020/6/10 00:56
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户认证相关接口", tags = "用户认证")
public class LoginController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取当前登录用户信息", notes = "获取当前登录用户信息")
    @GetMapping("/current")
    public JsonResult current() {
        return this.userService.current();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/login")
    public JsonResult login(@Valid @RequestBody UserLoginBO userLoginBO, @ApiIgnore BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = BindingResultUtil.getErrors(bindingResult);
            return JsonResult.errorMap(errorMap);
        }
        return this.userService.login(userLoginBO);
    }

}
