package com.duguanjun.controller;

import com.duguanjun.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/testGet")
    public String get(String name){

        System.out.println(name);

        return "OK:" + name;
    }

    /**
     * application/json
     * json参数的核心是:header  COntent-Type="application/json;charset=utf-8";
     * @param user
     * @return
     */
    @PostMapping("/testPost")
    public String post(@RequestBody User user){
        System.out.println(user);

        return "OK:json" + user;
    }

    /**
     * 接受表单参数
     * 表单参数核心:Content-Type="x-www-form-urlencoded"
     */
    @PostMapping("/testPost2")
    public String post2(User user){
        System.out.println(user);

        return "OK:form" + user;
    }
}
