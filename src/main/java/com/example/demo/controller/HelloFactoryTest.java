package com.example.demo.controller;

import com.example.demo.factory.FactoryTest;
import com.example.demo.factory.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * 水果工廠
 *
 * @author YeeDer
 * @since 2023/3/27 下午 08:14
 **/
@RestController
public class HelloFactoryTest {

    @Autowired
    FactoryTest factoryTest;

    @Autowired
    FruitService apple;

    @Autowired
    FruitService banana;

    @GetMapping("/fruit/{fruitName}")
    public void getFruitFactory(@PathVariable String fruitName){
        FruitService fruitService = factoryTest.createFruitService(fruitName);
        System.out.println("FruitService name is = " + fruitService.getServiceName());
    }

    @GetMapping("/fruit/get")
    public void getFruitService(){
        System.out.println("FruitService name is = " + apple.getServiceName());
        System.out.println("FruitService name is = " + banana.getServiceName());
    }
}
