package com.example.two.controller;


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
        return "hello";
    }

    @PostMapping("/hello/post")
    public String helloPost(String name){
        return "hello, " + name;
    }

}

