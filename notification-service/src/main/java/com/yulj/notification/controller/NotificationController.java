package com.yulj.notification.controller;

import com.yulj.common.core.utils.BindingResultUtil;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.notification.Notification;
import com.yulj.model.notification.bo.NotificationAddBO;
import com.yulj.model.notification.bo.NotificationUpdateBO;
import com.yulj.notification.service.INotificationService;
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

    @ApiOperation(value = "新增通知信息", notes = "新增通知信息", response = JsonResult.class)
    @PostMapping("/add")
    public JsonResult add(@Valid @RequestBody NotificationAddBO notificationAddBO,
                          @ApiIgnore BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = BindingResultUtil.getErrors(bindingResult);
            return JsonResult.errorMap(errorMap);
        }
        return this.notificationService.add(notificationAddBO);
    }

    @ApiOperation(value = "更新通知信息", notes = "更新通知信息", response = JsonResult.class)
    @PutMapping("/update")
    public JsonResult update(@Valid @RequestBody NotificationUpdateBO notificationUpdateBO,
                             @ApiIgnore BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = BindingResultUtil.getErrors(bindingResult);
            return JsonResult.errorMap(errorMap);
        }
        return this.notificationService.update(notificationUpdateBO);
    }

    @ApiOperation(value = "删除通知信息", notes = "根据通知信息id删除通知信息", response = JsonResult.class)
    @ApiImplicitParam(name = "id", value = "通知信息id", required = true, dataType = "Long")
    @DeleteMapping("/delete")
    public JsonResult delete(@RequestParam @NotNull(message = "通知信息id不能为空") Long id) {
        return this.notificationService.delete(id);
    }

}
