package me.yevgnenll.core;

import me.yevgnenll.core.member.Grade;
import me.yevgnenll.core.member.Member;
import me.yevgnenll.core.service.MemberService;

public class MemberApp {

  public static void main(String[] args) {
    AppConfig config = new AppConfig();
    MemberService memberService = config.memberService();

    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member.getName());
    System.out.println("find member = " + findMember.getName());
  }
}
