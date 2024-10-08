package com.sunho.kim.beanfind.xml;

import com.sunho.kim.purchase.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XmlAppContextTest {

    @Test
    void xmlAppContext(){
        ApplicationContext ac = new GenericXmlApplicationContext("purchaseConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
