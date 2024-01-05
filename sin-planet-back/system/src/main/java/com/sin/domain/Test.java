package com.sin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName test
 */
@Schema(name = "test", description = "test类")
@TableName(value ="test")
@Data
public class Test implements Serializable {
    /**
     * 
     */
    @TableId(value = "uid", type = IdType.AUTO)
    @Schema(description = "主键")
    private Long uid;

    /**
     * 
     */
    @TableField(value = "username")
    @Schema(description = "用户名")
    private String username;

    /**
     * 
     */
    @TableField(value = "password")
    @Schema(description = "密码")
    private String password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}