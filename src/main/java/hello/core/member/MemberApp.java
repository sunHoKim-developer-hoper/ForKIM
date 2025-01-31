package hello.core.member;

import hello.core.config.AppConfig;

public class MemberApp {
    
    public static void main(String[] args) {
        
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //추상화에도 의존, 구현체에도 의존
        //MemberService memberService = new MemberServiceImpl();

        Member kim = new Member(1L, "Kim", Grade.VIP);
        Member lee = new Member(2L, "Lee", Grade.BASIC);
        memberService.join(kim);
        memberService.join(lee);
        Member findMember = memberService.findMember(1L);
        System.out.println(findMember.getName());
    }
}
