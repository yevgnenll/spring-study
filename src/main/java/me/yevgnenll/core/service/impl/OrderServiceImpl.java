package me.yevgnenll.core.service.impl;

import me.yevgnenll.core.discount.DiscountPolicy;
import me.yevgnenll.core.member.Member;
import me.yevgnenll.core.order.Order;
import me.yevgnenll.core.repository.MemberRepository;
import me.yevgnenll.core.service.OrderService;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    // 단일책임 원칙 SRP(single responsibility principle)
    int discountPrice = discountPolicy.discount(member, itemPrice);
    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
