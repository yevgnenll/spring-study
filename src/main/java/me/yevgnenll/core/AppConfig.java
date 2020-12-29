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


/**
 * factory methods
 * 외부에서 method 를 호출해서 생성된다.
 */
@Configuration
public class AppConfig {

  @Bean
  public MemberService memberService() {
    System.out.println("call AppConfig.memberService");
    return new MemberServiceImpl(memberRepository());
  }

  @Bean
  public MemoryMemberRepository memberRepository() {
    System.out.println("call AppConfig.memberRepository");
    return new MemoryMemberRepository();
  }

  @Bean
  public OrderService orderService() {
    System.out.println("call AppConfig.orderService");
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  @Bean
  public DiscountPolicy discountPolicy() {
    return new FixDiscountPolicy();
  }

}
