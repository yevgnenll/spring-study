package me.yevgnenll.core.service;

import me.yevgnenll.core.member.Member;

public interface MemberService {

  void join(Member member);

  Member findMember(Long memberId);

}
