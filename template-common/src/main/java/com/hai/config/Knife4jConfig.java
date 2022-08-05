package com.hai.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cn.hutool.core.collection.CollectionUtil;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ghai-th
 * @date 2022/8/5 10:53
 */
@EnableOpenApi
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class Knife4jConfig {
    private final OpenApiExtensionResolver openApiExtensionResolver;

    public Knife4jConfig(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean(value = "template-api")
    public Docket defaultApi1() {
        //List<SecurityScheme> securitySchemes=Arrays.asList(new ApiKey("Authorization", "Authorization", "header"));
        List<SecurityScheme> securitySchemes=new ArrayList<>();

//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;

        List<SecurityContext> securityContexts= Collections.singletonList(SecurityContext.builder()
//                .securityReferences(CollectionUtil.newArrayList(new SecurityReference("Authorization", authorizationScopes)))
                .forPaths(PathSelectors.regex("/.*"))
                .build());
//        HttpAuthenticationScheme httpAuthenticationScheme = HttpAuthenticationScheme.JWT_BEARER_BUILDER
//                .name(HttpHeaders.AUTHORIZATION)
//                .description("Bearer Token")
//                .build();
//        securitySchemes.add(httpAuthenticationScheme);

        //默认全局参数
//        List<RequestParameter> requestParameters=new ArrayList<>();
//        requestParameters.add(new RequestParameterBuilder().name("test").description("测试").in(ParameterType.QUERY).required(true).build());
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("template")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hai.controller"))
                .paths(PathSelectors.any())
                .build()
//                .globalRequestParameters(requestParameters)
                //.extensions(openApiExtensionResolver.buildExtensions("1.2.x"))
                //.extensions(openApiExtensionResolver.buildSettingExtensions())
                .securityContexts(securityContexts).securitySchemes(securitySchemes);
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("模板多模块项目")
                .description("Template RESTful APIs")
                .termsOfServiceUrl("127.0.0.1:8080")
                .contact(new Contact("@Ghai-th","https://github.com/Ghai-th","cancallmexiaohai@gmail.com"))
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }


    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollectionUtil.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

}
