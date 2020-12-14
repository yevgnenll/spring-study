package me.yevgnenll.core.beanfind;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.yevgnenll.core.AppConfig;
import me.yevgnenll.core.service.MemberService;
import me.yevgnenll.core.service.impl.MemberServiceImpl;

public class ApplicationTextBasicFindText {

  ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("빈 이름으로 조회")
  void findBeanByName() {
    MemberService memberService = ac.getBean("memberService", MemberService.class);
    System.out.println("memberService= " + memberService);
    System.out.println("memberSErvice.getClass()= " + memberService.getClass());

    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("이름 없이 bean type 으로 조회")
  void findBeanByType() {
    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test
  @DisplayName("구체 type 으로 조회")
  void findBeanByTypeImpl() {
    MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

}
