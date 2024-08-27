package com.sunho.kim.purchase.core;

import com.sunho.kim.purchase.config.PurchaseConfig;
import com.sunho.kim.purchase.member.Grade;
import com.sunho.kim.purchase.member.Member;
import com.sunho.kim.purchase.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        PurchaseConfig config = new PurchaseConfig();
//        MemberService memberService = config.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PurchaseConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println(findMember);
    }
}
