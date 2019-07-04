package com.lee.boot.mapstruct.mapper;

import com.lee.boot.mapstruct.MapStructDemoApplication;
import com.lee.boot.mapstruct.bean.PersonDo;
import com.lee.boot.mapstruct.bean.User;
import com.lee.boot.mapstruct.dto.PersonDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author li.heng
 * @Date 2019/6/14 17
 * @Description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest()
public class PersonDo2DtoMappingTest {
    @Autowired
    private PersonDo2DtoMapping personDo2DtoMapping;

    @Test
    public void do2dtoTest() {
//        PersonDo personDo =
//                new PersonDo(1L, "zhige", "zhige.me@gmail.com", new Date(), new User(12, 185, 65.5));
//        PersonDto personDto1 = new PersonDto();
//        PersonDto personDto = personDo2DtoMapping.do2dto(personDo);
//        System.out.println(personDto);
    }
}