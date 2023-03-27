package com.example.demo.h2test.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/25 上午 11:55
 **/
@Entity
@Data
public class Member {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String lowerCase;
}
