package com.sunho.kim.purchase.core;

import com.sunho.kim.purchase.config.PurchaseConfig;
import com.sunho.kim.purchase.member.Grade;
import com.sunho.kim.purchase.member.Member;
import com.sunho.kim.purchase.member.MemberService;
import com.sunho.kim.purchase.order.Order;
import com.sunho.kim.purchase.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        PurchaseConfig config = new PurchaseConfig();
//        MemberService memberService = config.memberService();
//        OrderService orderService = config.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PurchaseConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "kim", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 5000);
        System.out.println(order);
    }
}
