package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/25 上午 09:59
 **/
@RestController
public class HelloAOP {

    @GetMapping("helloAOP")
    public void helloAOP() {
        System.out.println("helloAOP");
    }
}
