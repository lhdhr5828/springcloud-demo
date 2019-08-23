package com.lee.springboot.demo.controller;

import com.lee.springboot.demo.bean.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author heng.li
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "get")
    @ResponseBody
    public User getUser(Integer id) {
        System.out.println(id);
        return new User();
    }

    @RequestMapping("/update")
    @ResponseBody
    public User updateUser(@RequestParam(name = "user_id") Integer id,
                           @RequestParam(name = "user_name") String name,
                           @RequestParam(name = "user_age") Integer age,
                           @RequestParam(name = "user_address") String address) {
        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setName(name);
        user.setAddress(address);
        return user;
    }

    @RequestMapping("/array")
    @ResponseBody
    public Map<String, Integer[]> receiveArray(Integer[] ints) {
        HashMap<String, Integer[]> map = new HashMap<>(16);
        map.put("ints", ints);
        return map;
    }

    @RequestMapping("/json")
    @ResponseBody
    public User receiveJson(@RequestBody User user) {
        return user;
    }

    //    @RequestMapping("/${id}")
    @RequestMapping("/{id}")
    @ResponseBody
    public User receiveJson(@PathVariable Integer id) {
        return new User();
    }

    @RequestMapping("/date")
    @ResponseBody
    public Map receiveFormat(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                             @NumberFormat(pattern = "##,###,###.##") Boolean money) {
        HashMap<String, Integer> map = new HashMap<>(16);
        return map;
    }

    @RequestMapping("/convert")
    @ResponseBody
    public User convertRequest(User user) {
        System.out.println(user.toString());
        return user;
    }

    @RequestMapping("/convertList")
    @ResponseBody
    public void convertList(List<User> users) {
        users.forEach(o -> System.out.println(o.toString()));
    }

}
