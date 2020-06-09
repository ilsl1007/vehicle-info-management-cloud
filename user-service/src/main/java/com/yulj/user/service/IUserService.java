package com.yulj.user.service;

import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.user.User;
import com.yulj.model.user.bo.UserAddBO;
import com.yulj.model.user.bo.UserUpdateBO;

/**
 * @Classname IUserService
 * @Description <h1>用户表业务逻辑层</h1>
 * @Author yulj
 * @Date: 2020/6/8 21:53
 */
public interface IUserService {

    /**
     * <h2>获取分页列表数据</h2>
     *
     * @param user 用户表查询对象
     * @return
     */
    PagedGridResult getPageList(User user);

    /**
     * <h2>新增用户</h2>
     *
     * @param userAddBO 用户新增业务对象
     * @return
     */
    JsonResult add(UserAddBO userAddBO);

    /**
     * <h2>更新用户</h2>
     *
     * @param userUpdateBO 用户更新业务对象
     * @return
     */
    JsonResult update(UserUpdateBO userUpdateBO);

    /**
     * <h2>删除用户信息</h2>
     *
     * @param id 用户id
     * @return
     */
    JsonResult delete(Long id);

}
