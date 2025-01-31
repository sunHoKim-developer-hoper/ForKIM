package hello.core.config;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    // 클라이언트 코드 수정이 아닌 config 파일만 바꿔주면 된다.
    public DiscountPolicy discountPolicy(){
        //return new FixedDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
