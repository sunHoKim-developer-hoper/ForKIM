package com.sunho.kim.purchase.discount;

import com.sunho.kim.purchase.member.Grade;
import com.sunho.kim.purchase.member.Member;

public class FixDiscountPolicy implements  DiscountPolicy{

    // 고정으로 1,000원 할인
    private int discountFixAmount = 1000;
    

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
