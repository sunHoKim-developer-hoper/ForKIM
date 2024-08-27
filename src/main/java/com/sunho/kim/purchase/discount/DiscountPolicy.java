package com.sunho.kim.purchase.discount;

import com.sunho.kim.purchase.member.Member;

public interface DiscountPolicy {
    /**
     *
     * @return 할인 대상 금액
     *
     */
    int discount(Member member, int price);

}
