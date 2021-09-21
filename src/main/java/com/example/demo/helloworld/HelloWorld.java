package com.example.demo.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//自动装配
@RestController
public class HelloWorld {
   //接口： http://localhost:8080/hello
    @RequestMapping("/hello")
    public static String hello(){
        //调用业务，接收前端数据
        return "helloworld";
    }
}
