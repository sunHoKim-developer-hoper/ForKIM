package com.sunho.kim.purchase;

import com.sunho.kim.purchase.discount.RateDiscountPolicy;
import com.sunho.kim.purchase.member.Grade;
import com.sunho.kim.purchase.member.Member;
import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "kim", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount, Is.is(CoreMatchers.equalTo(1000)));
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되면 안 된다.")
    void vip_x(){
        //given
        Member member = new Member(2L, "kang", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount, Is.is(CoreMatchers.equalTo(1000)));
    }
}