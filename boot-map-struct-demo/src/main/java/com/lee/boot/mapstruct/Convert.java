package com.lee.boot.mapstruct;

import com.lee.boot.mapstruct.bean.PersonDo;
import com.lee.boot.mapstruct.bean.User;
import com.lee.boot.mapstruct.dto.PersonDto;
import com.lee.boot.mapstruct.mapper.PersonDo2DtoMapping;

import java.util.*;

/**
 * @Author heng.li
 * @Date 2019/6/3 13
 * @Description:
 **/
public class Convert {
    public static void main(String[] args) {
        PersonDo2DtoMapping instance = PersonDo2DtoMapping.INSTANCE;
        PersonDo personDo =
                new PersonDo(1L, "zhige", "zhige.me@gmail.com", new Date(), new User(12, 185, 65.5));
        PersonDto personDTO = instance.do2dto(personDo);
        System.out.println(personDTO.toString());
//        PersonDo person1 = instance.reserveDto(personDTO);
//        System.out.println(person1);
//        String format = DateFormatUtils.format(personDTO.getBirth(), "yyyy-MM-dd HH:mm:ss");
//        List<PersonDo> peoples = new ArrayList<>();
//        peoples.add(personDo);
//        List<PersonDto> personDTOs = instance.domain2dto(peoples);
//        System.out.println(Arrays.toString(personDTOs.toArray()));

    }

}
