package me.yevgnenll.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.yevgnenll.core.repository.MemberRepository;
import me.yevgnenll.core.repository.MemoryMemberRepository;

public class ApplicationContextFindBeanSame {

  ApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

  @Test
  @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
  void findBeanByTypeDuplicate() {
    assertThrows(NoUniqueBeanDefinitionException.class,
        () -> ac.getBean(MemberRepository.class));
  }

  @Test
  @DisplayName("type 으로 조회시 같은 타입이 둘 이상이면, 빈 이름을 지정한다")
  void findBeansByName() {
    MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
    assertThat(memberRepository).isInstanceOf(MemberRepository.class);
  }

  @Test
  @DisplayName("특정 타입을 모두 조회한다")
  void findAllBeansByType() {
    // autowired 같은 경우 이러한 로직이 필요하다
    Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
    for (String key : beansOfType.keySet()) {
      System.out.println("key= " + key + ", " + "value= " + beansOfType.get(key));
    }
    System.out.println("beansOfType" + beansOfType);
    assertThat(beansOfType.size()).isEqualTo(2);
  }


  @Configuration
  static class SameBeanConfig {

    @Bean
    public MemberRepository memberRepository() {
      return new MemoryMemberRepository();
    }

    @Bean
    public MemberRepository memberRepository2() {
      return new MemoryMemberRepository();
    }
  }

}
