package com.example.ant.practice.controller;


import com.example.ant.practice.entity.User;
import com.example.ant.practice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-11-14
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getById")
    public User getById(String id){
        List<User> userList = userService.list();
        User user = userService.getById(id);
        return user;
    }

}

















