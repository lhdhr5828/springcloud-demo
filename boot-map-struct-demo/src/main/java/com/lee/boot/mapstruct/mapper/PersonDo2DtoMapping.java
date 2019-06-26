package com.lee.boot.mapstruct.mapper;

import com.lee.boot.mapstruct.bean.PersonDo;

import com.lee.boot.mapstruct.bean.User;
import com.lee.boot.mapstruct.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

/**
 * @Author heng.li
 * @Date 2019/6/3 13
 * @Description:
 **/
@Mapper(uses = PersonTransRule.class, componentModel = "spring")
public interface PersonDo2DtoMapping {
    /**
     * 定义一个常量给调用者使用
     */
    PersonDo2DtoMapping INSTANCE = Mappers.getMapper(PersonDo2DtoMapping.class);

    /**
     * dateformat 在Date对象转为字符串时指定格式
     *
     * @param personDo
     * @return
     */
    @Mapping(source = "birthday", target = "birth", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "user.age", target = "age")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "user.age", target = "adult")
    PersonDto do2dto(PersonDo personDo);

    /**
     * 会使用domain2dto方法进行对象list转换
     *
     * @param people
     * @return
     */
    List<PersonDto> listToList(List<PersonDo> people);

    @Mapping(source = "personDo.name", target = "firstName")
    @Mapping(source = "personDo.email", target = "email")
    @Mapping(source = "user.age", target = "age")
    @Mapping(source = "user.high", target = "high")
    @Mapping(source = "user.weight", target = "weight")
    PersonDto twoPar2dto(PersonDo personDo, User user);

//    PersonDo reserveDto(PersonDto dto);

    /**
     * 用作各个类型集合之间的转换
     */
    List<String> intToString(List<Integer> ints);

    Set<String> intToString(Set<Integer> ints);


}
