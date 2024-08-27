package com.sunho.kim.purchase;

import com.sunho.kim.purchase.config.PurchaseConfig;
import com.sunho.kim.purchase.member.Grade;
import com.sunho.kim.purchase.member.Member;
import com.sunho.kim.purchase.member.MemberService;
import com.sunho.kim.purchase.order.Order;
import com.sunho.kim.purchase.order.OrderService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        PurchaseConfig purchaseConfig = new PurchaseConfig();
        memberService = purchaseConfig.memberService();
        orderService = purchaseConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "kim", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        MatcherAssert.assertThat(order.getDiscountPrice(), Is.is(CoreMatchers.equalTo(1000)));
    }
}
