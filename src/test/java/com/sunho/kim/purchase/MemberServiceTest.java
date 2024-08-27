package com.sunho.kim.purchase;

import com.sunho.kim.purchase.config.PurchaseConfig;
import com.sunho.kim.purchase.member.Grade;
import com.sunho.kim.purchase.member.Member;
import com.sunho.kim.purchase.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        PurchaseConfig purchaseConfig = new PurchaseConfig();
        memberService = purchaseConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "MemberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        assertThat(member, is(equalTo(findMember)));
    }
}
