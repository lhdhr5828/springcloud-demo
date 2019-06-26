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
//    public PersonDo(Long id, String name, String email, Date birthday, User user) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.birthday = birthday;
//        this.user = user;
//    }

    private Long id;
    private String name;
    private String email;
    private Date birthday;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
