package com.lee.boot.mapstruct.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author heng.li
 * @Date 2019/6/3 12
 * @Description:
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PersonDo {
    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;
}
