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
@Data
@ToString
public class User {
    public User(Integer age, Integer high, Double weight) {
        this.age = age;
        this.high = high;
        this.weight = weight;
    }

    private Integer age;

    private Integer high;

    private Double weight;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
