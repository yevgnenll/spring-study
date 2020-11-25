package me.yevgnenll.core.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import me.yevgnenll.core.member.Grade;
import me.yevgnenll.core.member.Member;
import me.yevgnenll.core.service.MemberService;

class MemberServiceImplTest {

  MemberService memberService = new MemberServiceImpl();

  @Test
  void join() {
    // given
    Member member = new Member(1L, "memberA", Grade.VIP);

    // when
    memberService.join(member);
    Member findMember = memberService.findMember(1L);

    assertThat(member).isEqualTo(findMember);
  }

}
