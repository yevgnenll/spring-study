package me.yevgnenll.core.discount;

import me.yevgnenll.core.member.Grade;
import me.yevgnenll.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

  private int discountFixAmount = 1_000;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return discountFixAmount;
    }
    return 0;
  }
}
