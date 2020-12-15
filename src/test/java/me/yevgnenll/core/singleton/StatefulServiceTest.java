package me.yevgnenll.core.singleton;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

  @Test
  @DisplayName("bean 이 상태를 가지면 어떻게 되는지 보여주지!!")
  void statefulServiceSingleton() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    StatefulService statefulService1 = ac.getBean(StatefulService.class);
    StatefulService statefulService2 = ac.getBean(StatefulService.class);

    // Thread A: A가 10000원 주문
    statefulService1.order("userA", 10_000);

    // Thread B: B가 20000원 주문
    statefulService2.order("userB", 20_000);

    // Thread A: 사용자 A 주문 금액 조회
    int price = statefulService1.getPrice();
    System.out.println("price= " + price);

    assertThat(statefulService1).isSameAs(statefulService2);
    assertThat(statefulService1.getPrice()).isEqualTo(20_000);
  }

  static class TestConfig {

    @Bean
    public StatefulService statefulService() {
      return new StatefulService();
    }

  }

}
