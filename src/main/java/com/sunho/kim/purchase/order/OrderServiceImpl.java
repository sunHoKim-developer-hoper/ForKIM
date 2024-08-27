package com.sunho.kim.purchase.order;

import com.sunho.kim.purchase.discount.DiscountPolicy;
import com.sunho.kim.purchase.member.Member;
import com.sunho.kim.purchase.member.MemberRepository;

public class OrderServiceImpl implements  OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        Order order = new Order(memberId,itemName,itemPrice,discountPrice);
        return order;
    }
}
