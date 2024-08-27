package com.sunho.kim.purchase.member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long MemberID);
}
