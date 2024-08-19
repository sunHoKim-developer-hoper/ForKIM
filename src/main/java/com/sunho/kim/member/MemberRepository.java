package com.sunho.kim.member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long MemberID);
}
