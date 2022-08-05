package com.hai.aspect.log;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Ghai-th
 * @date 2022/8/5 13:34
 */
@Component
@Aspect
@Log4j2
public class ControllerAspect {

    @Pointcut("execution(* com.hai.controller.*.* (..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取执行方法的类的名称（包名加类名）
        String className = joinPoint.getTarget().getClass().getName();
        // 获取实例和方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();
        // 执行方法获取返回值
        Object proceed = null;
        long startTime = System.currentTimeMillis();
        try {
            proceed = joinPoint.proceed();//执行注解的方法，并获取方法的返回值
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }

        long endTime = System.currentTimeMillis();
        Object finalProceed = proceed;
        log.info(new JSONObject(){{
            put("spend time" , endTime -startTime);
            put("args" , new ArrayList<>(Arrays.stream(args).collect(Collectors.toList())));
            put("method" ,className +  "." + method.getName() );
            put("result", finalProceed.toString());
        }});
        return proceed;

    }
}
