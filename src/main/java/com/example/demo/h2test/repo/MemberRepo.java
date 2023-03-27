package com.example.demo.h2test.repo;

import com.example.demo.h2test.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/25 上午 11:56
 **/
public interface MemberRepo extends JpaRepository<Member,Integer> {
}
