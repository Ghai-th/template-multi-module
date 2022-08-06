package com.hai.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSONObject;
import com.hai.common.AjaxResponse;
import com.hai.modle.UserBase;
import com.hai.service.UserBaseService;
import com.hai.utils.DateTimeUtils;
import com.hai.utils.JWTUtils;
import com.hai.utils.SnowFlakeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author Ghai-th
 * @date 2022/8/5 18:19
 */
@Log4j2
@RestController
@Api(tags = "登录接口")
@AllArgsConstructor
public class LoginController {

    UserBaseService userBaseService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public AjaxResponse login(String code,String password){
        if(code == null || password == null){
            return AjaxResponse.failed("参数不完整");
        }
        UserBase userBase = userBaseService.selectByCode(code);
        if (userBase == null){
            return AjaxResponse.failed("未注册的用户");
        }
        String md5Code = DigestUtil.md5Hex(password + userBase.getSalt());
        if (md5Code.equals(userBase.getPassword())){
            return AjaxResponse.success("登录成功").add(JWTUtils.USER_TOKEN,getUserToken(userBase));
        }
        return AjaxResponse.failed("账号或密码错误");
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public AjaxResponse register(String userName, String password, String code){
        UserBase userBase = userBaseService.selectByCode(code);
        if (userBase != null){
            return AjaxResponse.failed("账号已被占用");
        }
        String salt = IdUtil.simpleUUID();
        Integer time = DateTimeUtils.getInt11Time();
        UserBase registerUser = new UserBase() {{
            setId(SnowFlakeUtils.nextId());
            setCode(code);
            setDeleteFlag(0);
            setSalt(salt);
            setUserName(userName);
            setPassword(DigestUtil.md5Hex(password + salt ));
            setCreateTime(time);
            setUpdateTime(time);
        }};
        userBaseService.insert(registerUser);
        return AjaxResponse.success().add(JWTUtils.USER_TOKEN,getUserToken(registerUser));
    }


    private String getUserToken(UserBase userBase){
        return JWTUtils.createToken(new JSONObject(){{
            put("uid",userBase.getId());
            put("userName",userBase.getUserName());
            put("code",userBase.getCode());
        }}.toJSONString());
    }




}
