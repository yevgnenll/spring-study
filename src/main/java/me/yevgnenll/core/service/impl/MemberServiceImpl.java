package me.yevgnenll.core.service.impl;

import me.yevgnenll.core.member.Member;
import me.yevgnenll.core.repository.MemberRepository;
import me.yevgnenll.core.repository.MemoryMemberRepository;
import me.yevgnenll.core.service.MemberService;

public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository = new MemoryMemberRepository();

  @Override
  public void join(Member member) {
    // 다형성에 의해 구현한 것이 호출된다
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
