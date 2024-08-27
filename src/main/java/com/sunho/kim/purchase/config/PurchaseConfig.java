package com.sunho.kim.purchase.config;

import com.sunho.kim.purchase.discount.DiscountPolicy;
import com.sunho.kim.purchase.discount.RateDiscountPolicy;
import com.sunho.kim.purchase.member.MemberService;
import com.sunho.kim.purchase.member.MemberServiceImpl;
import com.sunho.kim.purchase.member.MemoryMemberRepository;
import com.sunho.kim.purchase.order.OrderService;
import com.sunho.kim.purchase.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PurchaseConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(getMemoryMemberRepository());
    }

    @Bean
    public MemoryMemberRepository getMemoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(getMemoryMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
        // return new FixDiscountPolicy();
    }
}
