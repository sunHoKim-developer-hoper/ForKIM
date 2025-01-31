package hello.core.order;

import hello.core.config.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderApp {
    
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        
        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();
        
        Member kim = new Member(1L, "Kim", Grade.VIP);
        memberService.join(kim);
        Order order = orderService.createOrder(kim.getId(), "물건", 30000);
        System.out.println(order.getDiscountPrice());
        //int discountPrice =  discountPolicy.discount(kim, 10000);
        
    }
}
