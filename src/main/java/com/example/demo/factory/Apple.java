package com.example.demo.factory;

import org.springframework.stereotype.Service;

/**
 * @author YeeDer
 * @since 2023/3/27 下午 08:41
 **/
@Service
public class Apple implements FruitService{

    final String APPLE = "APPLE";

    @Override
    public String getServiceName() {
        return this.APPLE;
    }
}
