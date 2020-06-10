package com.yulj.vehiclemanagement.controller;

import com.yulj.common.core.utils.BindingResultUtil;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.vehiclemanagement.VehicleRegisterInfo;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoAddBO;
import com.yulj.model.vehiclemanagement.bo.VehicleRegisterInfoUpdateBO;
import com.yulj.vehiclemanagement.service.IVehicleRegisterInfoService;
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
 * @Classname VehicleRegisterInfoController
 * @Description <h1>车辆登记信息控制器</h1>
 * @Author yulj
 * @Date: 2020/6/9 11:03
 */
@RestController
@RequestMapping("/vehicleRegisterInfo")
@Api(value = "车辆信息相关接口", tags = "车辆信息")
public class VehicleRegisterInfoController {

    @Autowired
    private IVehicleRegisterInfoService vehicleRegisterInfoService;

    @ApiOperation(value = "分页查询车辆注册信息", notes = "分页查询车辆注册信息")
    @GetMapping("/list")
    public PagedGridResult list(VehicleRegisterInfo vehicleRegisterInfo) {
        return this.vehicleRegisterInfoService.getPageList(vehicleRegisterInfo);
    }

    @ApiOperation(value = "新增车辆注册信息", notes = "新增车辆注册信息", response = JsonResult.class)
    @PostMapping("/add")
    public JsonResult add(@Valid @RequestBody VehicleRegisterInfoAddBO vehicleRegisterInfoAddBO,
                          @ApiIgnore BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = BindingResultUtil.getErrors(bindingResult);
            return JsonResult.errorMap(errorMap);
        }
        return this.vehicleRegisterInfoService.add(vehicleRegisterInfoAddBO);
    }

    @ApiOperation(value = "更新车辆注册信息", notes = "更新车辆注册信息", response = JsonResult.class)
    @PostMapping("/update")
    public JsonResult update(@Valid @RequestBody VehicleRegisterInfoUpdateBO vehicleRegisterInfoUpdateBO,
                             @ApiIgnore BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = BindingResultUtil.getErrors(bindingResult);
            return JsonResult.errorMap(errorMap);
        }
        return this.vehicleRegisterInfoService.update(vehicleRegisterInfoUpdateBO);
    }

    @ApiOperation(value = "删除车辆注册信息", notes = "根据用户id删除车辆注册信息", response = JsonResult.class)
    @ApiImplicitParam(name = "id", value = "车辆注册信息id", required = true, dataType = "Long")
    @PostMapping("/delete")
    public JsonResult delete(@RequestParam @NotNull(message = "车辆注册信息id不能为空") Long id) {
        return this.vehicleRegisterInfoService.delete(id);
    }

}
