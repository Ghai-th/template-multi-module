package com.hai.controller;

import com.hai.common.AjaxResponse;
import com.hai.modle.Template;
import com.hai.service.TemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ghai-th
 * @date 2022/8/5 11:47
 */
@Log4j2
@RestController
@Api(tags = "模板接口")
@AllArgsConstructor
public class TemplateController {

    TemplateService templateService;

    @GetMapping
    @ApiOperation("查询全部的模板对象")
    public AjaxResponse selectAllTemplate(){
        List<Template> templates = templateService.selectAll();
        return AjaxResponse.success(templates);
    }

    @PostMapping
    @ApiOperation("查询全部的模板对象 通过 id")
    public AjaxResponse selectTemplateById(){
        Template template = templateService.selectByPrimaryKey(1L);
        return AjaxResponse.success(template);
    }


}
