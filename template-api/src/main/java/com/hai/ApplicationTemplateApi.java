package com.hai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ghai-th
 * @date ${DATE} ${TIME}
 */
@SpringBootApplication
@MapperScan("com.hai.mapper")
public class ApplicationTemplateApi {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationTemplateApi.class,args);
    }
}
