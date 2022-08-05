package com.hai.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author Ghai-th
 * @date 2022/8/5 17:24
 */

@ApiModel(value="user_base")
@Schema
@Data
public class UserBase {
    /**
    * 用户id
    */
    @ApiModelProperty(value="用户id")
    @Schema(description="用户id")
    private Long id;

    /**
    * 用户名称
    */
    @ApiModelProperty(value="用户名称")
    @Schema(description="用户名称")
    private String userName;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    @Schema(description="密码")
    private String password;

    /**
    * 盐值
    */
    @ApiModelProperty(value="盐值")
    @Schema(description="盐值")
    private String salt;

    /**
    * 用户的唯一标识
    */
    @ApiModelProperty(value="用户的唯一标识")
    @Schema(description="用户的唯一标识")
    private String code;

    @ApiModelProperty(value="")
    @Schema(description="")
    private Integer createTime;

    @ApiModelProperty(value="")
    @Schema(description="")
    private Integer updateTime;

    @ApiModelProperty(value="")
    @Schema(description="")
    private Integer deleteFlag;
}