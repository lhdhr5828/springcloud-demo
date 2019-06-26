package com.lee.boot.mapstruct.dto;

import com.lee.boot.mapstruct.bean.PersonDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author heng.li
 * @Date 2019/6/3 12
 * @Description:
 **/
@NoArgsConstructor
@Data
@ToString
public class PersonDto {
    private String firstName;
    /**
     * 对应 PersonDo.user.age
     */
    private Integer age;
    private String email;
    /**
     * 与 bean 里面的字段名称(birthDay)不一致
     */
    private String birth;

    private Integer high;

    private Double weight;
    private Boolean adult;

    PersonDto do2Dto(PersonDo personDo) {
        PersonDto personDto = new PersonDto();
        personDto.setFirstName(personDo.getName());
        personDto.setEmail(personDo.getEmail());
        Integer age = personDo.getUser().getAge();
        personDto.setAge(age);
        personDto.setAdult(age > 18);
        Date birthday = personDo.getBirthday();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(birthday);
        personDto.setBirth(format);
        return personDto;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
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

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }
}
