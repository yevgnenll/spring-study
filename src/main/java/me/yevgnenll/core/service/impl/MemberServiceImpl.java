package me.yevgnenll.core.service.impl;

import me.yevgnenll.core.member.Member;
import me.yevgnenll.core.repository.MemberRepository;
import me.yevgnenll.core.service.MemberService;

public class MemberServiceImpl implements MemberService {

  // 마치 배우가 섭외까지 하는것 -> 밖에서 생성해서 넣어줘야 한다.
  private final MemberRepository memberRepository;

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

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
