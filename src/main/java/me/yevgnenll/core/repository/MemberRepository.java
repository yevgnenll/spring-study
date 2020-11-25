package me.yevgnenll.core.repository;

import me.yevgnenll.core.member.Member;

public interface MemberRepository {

  void save(Member member);

  Member findById(Long memberId);

}
