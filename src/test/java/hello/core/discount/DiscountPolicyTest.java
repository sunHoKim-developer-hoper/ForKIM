package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class DiscountPolicyTest {
    
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){
        //given
        Member kim = new Member(1L, "Kim", Grade.VIP);
        //when
        int discountPrice =  discountPolicy.discount(kim, 10000);
        //then  
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되면 안 된다")
    void vip_x(){
        //given
        Member lee = new Member(1L, "Lee", Grade.BASIC);
        //when
        int discountPrice =  discountPolicy.discount(lee, 10000);
        //then  
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }
}
