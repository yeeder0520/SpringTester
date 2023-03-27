package com.example.demo.controller;

import com.example.demo.h2test.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/11/7 下午 05:21
 **/
@RestController
public class HelloMember {

    private final MemberService memberService;

    public HelloMember(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("getMemberInformation")
    public void getMemberInformation()  {
        System.out.println("getMemberInformation");
        memberService.find();
    }
}
