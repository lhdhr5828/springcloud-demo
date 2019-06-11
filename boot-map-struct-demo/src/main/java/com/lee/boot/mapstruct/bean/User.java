package com.lee.boot.mapstruct.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author heng.li
 * @Date 2019/6/3 12
 * @Description:
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
    private Integer age;

    private Integer high;

    private Double weight;
}
