package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.config.AppConfig;

public class MemberServiceTest {
    
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    //MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {

        // given
        Member kim = new Member(1L, "Kim", Grade.VIP);
        Member lee = new Member(2L, "Lee", Grade.BASIC);

        // when
        memberService.join(kim);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(kim).isEqualTo(findMember);
    }

}
