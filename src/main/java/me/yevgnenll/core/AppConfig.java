package me.yevgnenll.core;

import me.yevgnenll.core.discount.DiscountPolicy;
import me.yevgnenll.core.discount.FixDiscountPolicy;
import me.yevgnenll.core.repository.MemoryMemberRepository;
import me.yevgnenll.core.service.MemberService;
import me.yevgnenll.core.service.OrderService;
import me.yevgnenll.core.service.impl.MemberServiceImpl;
import me.yevgnenll.core.service.impl.OrderServiceImpl;

public class AppConfig {

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }

  private MemoryMemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }

  public OrderService orderService() {
    return new OrderServiceImpl(memberRepository(), discountPolicy());
  }

  public DiscountPolicy discountPolicy() {
    return new FixDiscountPolicy();
  }

}
