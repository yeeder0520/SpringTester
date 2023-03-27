package com.example.demo.controller;

import com.example.demo.download.Task;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/20 上午 09:48
 **/
@RestController
public class HelloAsnyc {

    private final Task task;

    public HelloAsnyc(Task task) {
        this.task = task;
    }

    @GetMapping("helloAsync")
    public void helloAsync() throws InterruptedException {
        System.out.println("GO");
        task.message1();
        task.message2();
    }

}
