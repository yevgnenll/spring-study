package me.yevgnenll.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
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
  @DisplayName("이름 없이 구체 type 으로 조회")
  void findBeanByTypeImpl() {
    // 이건 좋은 방법이 아니다 추상에만 의존해야 하는데 이건 구현에 의존한다
    // 하지만 이러한 테스트를 해볼 필요가 있다
    MemberService memberService = ac.getBean(MemberServiceImpl.class);
    assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
  }

  @Test()
  @DisplayName("빈 이름으로 조회시 결과가 없을때")
  void findByBeanNameX() {
    assertThrows(NoSuchBeanDefinitionException.class,
        () -> ac.getBean("xxx", MemberService.class));
  }

}
