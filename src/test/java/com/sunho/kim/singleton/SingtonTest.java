package com.sunho.kim.singleton;

import com.sunho.kim.purchase.config.PurchaseConfig;
import com.sunho.kim.purchase.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingtonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        PurchaseConfig p = new PurchaseConfig();
        // 1. 조회할 때 마다 객체를 생성
        MemberService memberService1 = p.memberService();
        MemberService memberService2 = p.memberService();

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 확인용 테스트")
    void SingletonContainer() {

        SingletonService s1 = SingletonService.getInstance();
        SingletonService s2 = SingletonService.getInstance();

        Assertions.assertThat(s1).isSameAs(s2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PurchaseConfig.class);
        MemberService m1 = ac.getBean("memberService", MemberService.class);
        MemberService m2 = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(m1).isSameAs(m2);
    }
}
