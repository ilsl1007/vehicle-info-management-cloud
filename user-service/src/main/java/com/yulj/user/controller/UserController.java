package com.yulj.user.controller;

import com.yulj.common.core.utils.BindingResultUtil;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.user.User;
import com.yulj.model.user.bo.UserAddBO;
import com.yulj.model.user.bo.UserUpdateBO;
import com.yulj.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @Classname UserController
 * @Description <h1>用户信息控制器</h1>
 * @Author yulj
 * @Date: 2020/6/8 23:47
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户信息相关接口", tags = "用户信息")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "分页查询用户", notes = "分页查询用户")
    @GetMapping("/list")
    public PagedGridResult list(User user) {
        return this.userService.getPageList(user);
    }

    @ApiOperation(value = "新增用户", notes = "新增用户", response = JsonResult.class)
    @PostMapping("/add")
    public JsonResult add(@Valid @RequestBody UserAddBO userAddBO, @ApiIgnore BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = BindingResultUtil.getErrors(bindingResult);
            return JsonResult.errorMap(errorMap);
        }
        return this.userService.add(userAddBO);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户", response = JsonResult.class)
    @PostMapping("/update")
    public JsonResult update(@Valid @RequestBody UserUpdateBO userUpdateBO, @ApiIgnore BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = BindingResultUtil.getErrors(bindingResult);
            return JsonResult.errorMap(errorMap);
        }
        return this.userService.update(userUpdateBO);
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户", response = JsonResult.class)
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @PostMapping("/delete")
    public JsonResult delete(@RequestParam @NotNull(message = "用户id不能为空") Long id) {
        return this.userService.delete(id);
    }

}
