package com.example.demo.h2test.service;

import com.example.demo.h2test.entity.Member;
import com.example.demo.h2test.repo.MemberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/25 下午 12:12
 **/
@Service
public class MemberService {

    private final MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public void saveOrUpdate(Member member) {
        System.out.println("寫");
        memberRepo.save(member);
        member = new Member();
        member.setName("大雞雞");
        memberRepo.save(member);
    }

    public void find(){
        System.out.println("找");
        List<Member> all = memberRepo.findAll();
        for (Member member : all) {
            System.out.println("member = " + member);
        }
    }
}
