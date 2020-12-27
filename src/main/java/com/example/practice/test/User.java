package com.example.practice.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class User {
    private Integer age;

    public Integer getAge() {
        return age;
    }
    public static void remove(List<User> userList){
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getAge() > 20) {
                iterator.remove();
            }
        }
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAge(18);
        list.add(user);
        user = new User();
        user.setAge(20);
        list.add(user);
        user = new User();
        user.setAge(21);
        list.add(user);
        System.out.println(list);
        remove(list);
        System.out.println(list);
    }
}
