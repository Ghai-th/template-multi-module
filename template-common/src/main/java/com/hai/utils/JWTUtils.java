package com.hai.utils;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: xiang
 * @Date: 2021/5/11 21:11
 * <p>
 */

@Component
public class JWTUtils {

    //定义token返回头部
    public static String header = "Authorization";

    //token前缀
    public static String tokenPrefix = "";

    //签名密钥
    public static String secret = "Ww112233!@#";

    //有效期
    public static long expireTime  = 1 ;

    //存进客户端的token的key名
    public static final String USER_TOKEN = "USER_TOKEN";


    /**
     * 创建TOKEN
     * @param sub
     * @return
     */
    public static String createToken(String sub){
        return tokenPrefix + JWT.create()
                .withSubject(sub)
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + expireTime* 60 * 1000L ))
                .sign(Algorithm.HMAC512(secret));
    }


    /**
     * 验证token
     * @param token
     */
    public static String validateToken(String token){
        try {
            return JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getSubject();
        } catch (TokenExpiredException e){
            e.printStackTrace();
            throw new RuntimeException("token已经过期");
        } catch (Exception e){
            throw new RuntimeException("token验证失败");
        }
    }

    /**
     * 检查token是否需要更新
     * @param token
     * @return
     */
    public static boolean isNeedUpdate(String token){
        //获取token过期时间
        Date expiresAt = null;
        try {
            expiresAt = JWT.require(Algorithm.HMAC512(secret))
                    .build()
                    .verify(token.replace(tokenPrefix, ""))
                    .getExpiresAt();
        } catch (TokenExpiredException e){
            return true;
        } catch (Exception e){
            throw new RuntimeException("token验证失败");
        }
        //如果剩余过期时间少于过期时常的一般时 需要更新
        return (expiresAt.getTime()-System.currentTimeMillis()) < (expireTime>>1);
    }

    public static void main(String[] args) {

        System.out.println(JWT.create()
                .withSubject(new JSONObject() {{
                    put("uid", 1123456L);
                    put("userName", "admin");
                    put("code", "admin");
                }}.toJSONString())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + expireTime * 30L * 24 * 60 * 1000L))
                .sign(Algorithm.HMAC512(secret)));
    }

}

