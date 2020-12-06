package me.yevgnenll.core.discount;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.yevgnenll.core.member.Grade;
import me.yevgnenll.core.member.Member;

class RateDiscountPolicyTest {

  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("VIP는 10% 할인이 적용된다")
  public void vipDiscount() {
    // given
    Member member = new Member(1L, "VipMember", Grade.VIP);

    // when
    int discount = discountPolicy.discount(member, 10_000);

    // then
    assertThat(discount).isEqualTo(1_000);
  }

  @Test
  @DisplayName("VIP가 아니면 할인은 적용되지 않는다")
  public void notVIP() {
    // given
    Member member = new Member(2L, "BasicMember", Grade.BASIC);

    // when
    int discount = discountPolicy.discount(member, 10_000);

    // then
    assertThat(discount).isEqualTo(0);
  }

}
