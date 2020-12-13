package me.yevgnenll.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.yevgnenll.core.discount.DiscountPolicy;
import me.yevgnenll.core.discount.FixDiscountPolicy;
import me.yevgnenll.core.repository.MemoryMemberRepository;
import me.yevgnenll.core.service.MemberService;
import me.yevgnenll.core.service.OrderService;
import me.yevgnenll.core.service.impl.MemberServiceImpl;
import me.yevgnenll.core.service.impl.OrderServiceImpl;


@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemoryMemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new FixDiscountPolicy();
  }

}
