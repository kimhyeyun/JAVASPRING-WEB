package com.example.hello.hellospring;

import com.example.hello.hellospring.repository.*;
import com.example.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/*
* 자바 코드로 직접 스프링 빈 등록하기
* */



@Configuration
public class SpringConfig {

   /* private final DataSource dataSource;
    private final EntityManager em;*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

/*    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }*/

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

/*    @Bean
    public MemberRepository memberRepository(){
        return new
    }*/
}

