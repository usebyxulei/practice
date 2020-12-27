package com.example.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController2 {

    @GetMapping("getUser/{name}/{age}")
    public String getUser(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        System.out.println(name+":"+age);
        return "hello " + name + "：" +age;
    }
}
