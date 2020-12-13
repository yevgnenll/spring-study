package me.yevgnenll.core;

import me.yevgnenll.core.member.Grade;
import me.yevgnenll.core.member.Member;
import me.yevgnenll.core.order.Order;
import me.yevgnenll.core.service.MemberService;
import me.yevgnenll.core.service.OrderService;

public class OrderApp {
  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 20_000);

    System.out.println(order);
  }
}
