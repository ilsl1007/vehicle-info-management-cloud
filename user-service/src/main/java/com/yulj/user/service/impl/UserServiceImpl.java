package com.yulj.user.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.yulj.common.core.config.JwtOperator;
import com.yulj.common.core.utils.HttpServletUtil;
import com.yulj.common.core.utils.JsonResult;
import com.yulj.common.core.utils.PageSort;
import com.yulj.common.core.utils.PagedGridResult;
import com.yulj.model.user.User;
import com.yulj.model.user.bo.UserAddBO;
import com.yulj.model.user.bo.UserLoginBO;
import com.yulj.model.user.bo.UserUpdateBO;
import com.yulj.user.repository.UserRepository;
import com.yulj.user.service.IUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @Classname UserServiceImpl
 * @Description <h1>用户表业务逻辑层实现</h1>
 * @Author yulj
 * @Date: 2020/6/8 21:57
 */
@Service
public class UserServiceImpl implements IUserService {

    /**
     * 用户初始密码
     */
    public static final String USER_DEFAULT_PASSWORD = "P@ssw0rd";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtOperator jwtOperator;

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
        user.setPassword(SecureUtil.md5(USER_DEFAULT_PASSWORD));
        Claims claims = getClaims();
        Object account = claims.get("account");
        if (Objects.nonNull(account)) {
            user.setCreatedBy(String.valueOf(account));
        }
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
        } else {
            Optional<User> sourceUser = this.userRepository.findById(user.getId());
            if (sourceUser.isPresent()) {
                user.setPassword(sourceUser.get().getPassword());
            }
        }
        Claims claims = getClaims();
        Object account = claims.get("account");
        if (Objects.nonNull(account)) {
            user.setUpdatedBy(String.valueOf(account));
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

    @Override
    public JsonResult login(UserLoginBO userLoginBO) {
        User user = this.userRepository.findFirstByAccount(userLoginBO.getAccount());
        if (Objects.nonNull(user)) {
            if (Objects.equals(SecureUtil.md5(userLoginBO.getPassword()), user.getPassword())) {
                Map<String, Object> userInfo = new HashMap<>(3);
                userInfo.put("id", user.getId());
                userInfo.put("account", user.getAccount());
                userInfo.put("realName", user.getRealName());
                Map<String, Object> tokenInfo = new HashMap<>(2);
                String token = jwtOperator.generateToken(userInfo);
                tokenInfo.put("access_token", token);
                tokenInfo.put("expires_in", jwtOperator.getExpirationDateFromToken(token).getTime() / 1000);
                return JsonResult.ok(tokenInfo);
            }
        }
        return JsonResult.errorMsg("用户名密码错误");
    }

    @Override
    public JsonResult current() {
        User user = new User();
        Claims claims = getClaims();
        if (Objects.nonNull(claims)) {
            Integer id = (Integer) claims.get("id");
            Optional<User> userOptional = this.userRepository.findById(id.longValue());
            if (userOptional.isPresent()) {
                user = userOptional.get();
                // 清空密码
                user.setPassword("");
            }
        }
        return JsonResult.ok(user);
    }

    /**
     * <h2>从JWT token中获取用户信息</h2>
     *
     * @return
     */
    private Claims getClaims() {
        HttpServletRequest request = HttpServletUtil.getRequest();
        String token = request.getHeader("X-Token");
        if (!StringUtils.isEmpty(token)) {
            return jwtOperator.getClaimsFromToken(token);
        }
        return null;
    }

}
