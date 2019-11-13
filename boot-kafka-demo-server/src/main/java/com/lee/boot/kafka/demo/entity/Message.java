package com.lee.boot.kafka.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author heng.li
 * @Date 2019/5/28 14
 * @Description:
 **/
@Data
public class Message {

    private Long id;
    /**
     * 消息
     */
    private String msg;

    /**
     * 时间戳
     */
    private Date sendTime;


}
