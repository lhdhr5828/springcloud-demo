package com.lee.boot.shiro.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

@Data
@TableName(value = "role")
public class Role implements Serializable {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    @TableField(value = "role_name")
    private String roleName;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    private static final long serialVersionUID = 1L;

    public static final String COL_ROLE_NAME = "role_name";

    public static final String COL_USER_ID = "user_id";
}