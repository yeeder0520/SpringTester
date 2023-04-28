package com.example.demo.factory;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 水果工廠
 *
 * @author YeeDer
 * @since 2023/3/27 下午 08:14
 **/
@Service
public class FactoryTest {

    private final Map<String, FruitService> fruitServiceMap;

    public FactoryTest(Map<String, FruitService> fruitServiceMap) {
        this.fruitServiceMap = fruitServiceMap;
    }

    /**
     * 動態取得水果工廠
     *
     * @param fruitName fruitName
     * @return FruitService
     */
    public FruitService createFruitService(String fruitName) {
        FruitService fruitService = fruitServiceMap.get(fruitName);
        if (fruitService == null) {
            throw new IllegalArgumentException("沒這個水果工廠 : " + fruitName);
        }
        return fruitService;
    }
}
