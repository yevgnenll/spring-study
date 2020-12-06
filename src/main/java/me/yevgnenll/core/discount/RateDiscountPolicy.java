package me.yevgnenll.core.discount;

import me.yevgnenll.core.member.Grade;
import me.yevgnenll.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

  private int disocuntPercent = 10;

  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return price * disocuntPercent / 100;
    } else {
      return 0;
    }
  }
}
