package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    
    //DIP를 지키고 있다!!
    private final MemberRepository memberRepository; //= new MemoryMemberRepository();
    //private final DiscountPolicy discardPolicy = new FixedDiscountPolicy();
    private final DiscountPolicy discardPolicy; //= new RateDiscountPolicy();
    
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discardPolicy) {
        this.memberRepository = memberRepository;
        this.discardPolicy = discardPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int distcountPrice  = discardPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, distcountPrice);
    }
}
