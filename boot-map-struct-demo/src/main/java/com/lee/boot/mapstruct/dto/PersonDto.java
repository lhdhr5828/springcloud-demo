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
@AllArgsConstructor
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
}
