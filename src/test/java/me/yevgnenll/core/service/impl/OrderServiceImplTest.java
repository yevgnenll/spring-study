package me.yevgnenll.core.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.yevgnenll.core.AppConfig;
import me.yevgnenll.core.member.Grade;
import me.yevgnenll.core.member.Member;
import me.yevgnenll.core.order.Order;
import me.yevgnenll.core.service.MemberService;
import me.yevgnenll.core.service.OrderService;

class OrderServiceImplTest {

  private MemberService memberService;
  private OrderService orderService;

  @BeforeEach
  public void beforeEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
  }

  @Test
  void createOrder() {
    Long memberId = 1l;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(member.getId(), "itemA", 10_000);
    assertThat(order.getDiscountPrice()).isEqualTo(1_000);
  }

}
