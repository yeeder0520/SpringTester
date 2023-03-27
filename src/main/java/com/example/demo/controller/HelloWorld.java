package com.example.demo.controller;

import com.example.demo.myannotation.MyAnnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/25 上午 10:23
 **/
@RestController
public class HelloWorld {

    @GetMapping("helloworld")
    public void helloworld(
            @RequestParam String arg1,
            @RequestParam String arg2) throws InterruptedException {
        System.out.println("helloworld");
    }

    @GetMapping("helloworld2")
    @MyAnnotation(describe = "大番薯")
    public String helloworld2(
            @RequestParam String arg1,
            @RequestParam String arg2) throws InterruptedException {
        System.out.println("helloworld2");
        return "helloworld2";
    }
}
