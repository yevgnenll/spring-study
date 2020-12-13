package me.yevgnenll.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.yevgnenll.core.member.Grade;
import me.yevgnenll.core.member.Member;
import me.yevgnenll.core.service.MemberService;

public class MemberApp {

  public static void main(String[] args) {

    // spring container
    // annotation 기반으로 정의한다
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    // config 에서 memberService() 를 가져와야 한다
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

    Member member = new Member(1L, "memberA", Grade.VIP);
    memberService.join(member);

    Member findMember = memberService.findMember(1L);
    System.out.println("new member = " + member.getName());
    System.out.println("find member = " + findMember.getName());
  }
}
