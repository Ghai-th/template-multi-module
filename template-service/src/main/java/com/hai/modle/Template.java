package com.hai.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Ghai-th
 * @date 2022/8/6 9:31
 */

@ApiModel(value = "`template`")
@Schema
@Data
public class Template {
    @ApiModelProperty(value = "")
    @Schema(description = "")
    private Long id;

    @ApiModelProperty(value = "")
    @Schema(description = "")
    private String name;

    @ApiModelProperty(value = "")
    @Schema(description = "")
    private Integer createTime;

    @ApiModelProperty(value = "")
    @Schema(description = "")
    private Integer updateTime;

    @ApiModelProperty(value = "")
    @Schema(description = "")
    private Integer deleteFlag;
}