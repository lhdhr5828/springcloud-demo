package com.lee.boot.shiro.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

@Data
@TableName(value = "permission")
public class Permission implements Serializable {
     @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "permission")
    private String permission;

    @TableField(value = "role_id")
    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public static final String COL_PERMISSION = "permission";

    public static final String COL_ROLE_ID = "role_id";
}