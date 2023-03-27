package com.example.demo.download;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/20 上午 10:05
 **/
@Service
public class Task {

    @Async("taskExecutor")
    public void message1() throws InterruptedException {
        System.out.println("message1 GO");
        Thread.sleep(9000);
        System.out.println("message1 END");

    }

    @Async("taskExecutor")
    public void message2(){
        System.out.println("message2 GO");
        System.out.println("message2 END");
    }
}
