package com.hai.aspect.login;

import com.alibaba.fastjson.JSONObject;
import com.hai.common.AjaxResponse;
import com.hai.utils.JWTUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Ghai-th
 * @date 2022/8/5 17:39
 */
@Component
@Aspect
public class JWTAspect {

    @Value("#{'${jwt.exclude}'.split(',')}")
    String[] excludeController;

    @Pointcut("execution(* com.hai.controller.*.* (..))")
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint joinPoint){
        Object proceed;
        /* 排除部分控制器 */
        for (String exclude : excludeController) {
            if (joinPoint.getSignature().toString().contains(exclude)){
                try {
                    return joinPoint.proceed();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
        /* 解析token中的数据 */
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        assert  requestAttributes != null;
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        assert request != null;
        String token = request.getHeader(JWTUtils.USER_TOKEN);
        if (token == null || "".equals(token)){
            return AjaxResponse.failed("未登录状态");
        }
        JSONObject tokenParam;
        try {
            tokenParam = JSONObject.parseObject(JWTUtils.validateToken(token));
            if (tokenParam == null || tokenParam.size() == 0){
                return AjaxResponse.failed("错误的token");
            }
        } catch (Exception e){
            return AjaxResponse.failed("登录状态过期");
        }
        /* 通过参数名称 注入 参数值 */
        Object[] args = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            String paraName = paramNames[i];
            if (tokenParam.containsKey(paraName)){
                args[i] = tokenParam.get(paraName);
            }
        }
        try {
            proceed = joinPoint.proceed(args);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return proceed;
    }



}
