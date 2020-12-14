package me.yevgnenll.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.yevgnenll.core.discount.DiscountPolicy;
import me.yevgnenll.core.discount.FixDiscountPolicy;
import me.yevgnenll.core.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

  @Test
  @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 중복 오류가 발생한다")
  void findBeanByParentTypeDuplicate() {
    assertThrows(NoUniqueBeanDefinitionException.class,
        () -> ac.getBean(DiscountPolicy.class));
  }

  @Test
  @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 이름으로 조회한다")
  void findBeanByParentTypeBeanName() {
    DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
    assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
  }

  @Test
  @DisplayName("특정 하위 타입으로 조회")
  void findBeansBySubType() {
    FixDiscountPolicy fixDiscountPolicy = ac.getBean(FixDiscountPolicy.class);
    assertThat(fixDiscountPolicy).isInstanceOf(FixDiscountPolicy.class);
  }

  @Test
  @DisplayName("부모 타입으로 모든 bean 을 조회하기")
  void findAllBeansByParent() {
    Map<String, DiscountPolicy> discountPolicies = ac.getBeansOfType(DiscountPolicy.class);
    for (String key : discountPolicies.keySet()) {
      System.out.println("key= " + key + ", value= " + discountPolicies.get(key));
    }
    // 여기서 DiscountPolicy 가 없는 이유는 DiscountPolicy 가 interface 임.
    assertThat(discountPolicies.size()).isEqualTo(2);
  }

  @Test
  @DisplayName("부모 타입으로 모두 조회 하기 - Object")
  void findAllBeansByObject() {
    // 궁굼하니까 한번 보자
    Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
    for (String key : beansOfType.keySet()) {
      System.out.println("key= " + key + ", value= " + beansOfType.get(key));
    }
  }

  @Configuration
  static class TestConfig {
    @Bean
    public DiscountPolicy rateDiscountPolicy() {
      return new RateDiscountPolicy();
    }

    @Bean
    public DiscountPolicy fixDiscountPolicy() {
      return new FixDiscountPolicy();
    }
  }
}
