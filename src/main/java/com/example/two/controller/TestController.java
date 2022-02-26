package com.example.two.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
     @RestController  一般用来返回字符串
     @Controller 返回页面

     RestController相当于Controller+ResponseBody
     ResponseBody一般用来返回字符串或JSON对象（更多）
 */




@RestController
public class TestController {


    // :后边是默认的配置值
    @Value("${test.hello:TEST}")
    private String TestHello;
    /*
         get post put delete
         RequestMapping支持所有的
         如果向指定方法可以
         @GetMapping
         @PostMapping
         @PutMapping
         @DeleteMapping
         或者
         @RequestMapping(value = "/",method = RequestMethod.GET)

     */

    //@RequestMapping("/hello")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello"+TestHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello, " + name;
    }

}

