package hello.core.member;

public class MemberServiceImpl implements MemberService {
    
    //구현체에 의존하고 있다!! DIP 위배
    private final MemberRepository memberRepository; //= new MemoryMemberRepository();


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
