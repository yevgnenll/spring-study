package me.yevgnenll.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.yevgnenll.core.AppConfig;
import me.yevgnenll.core.repository.MemberRepository;
import me.yevgnenll.core.service.impl.MemberServiceImpl;
import me.yevgnenll.core.service.impl.OrderServiceImpl;

public class ConfigurationSingletonTest {

  @Test
  void configurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    MemberRepository memberRepository1 = memberService.getMemberRepository();
    MemberRepository memberRepository2 = orderService.getMemberRepository();

    assertThat(memberRepository).isEqualTo(memberRepository1);
    assertThat(memberRepository1).isEqualTo(memberRepository2);
    assertThat(memberRepository2).isEqualTo(memberRepository);
  }
}
