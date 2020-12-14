package me.yevgnenll.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.yevgnenll.core.AppConfig;

public class ApplicationContextTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("모든 빈 출력하기")
  void findAllBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      Object bean = ac.getBean(beanDefinitionName);
      System.out.println("bean= " + beanDefinitionName + " Object = " + bean);
    }
  }

  @Test
  @DisplayName("application 빈 출력하기")
  void findApplicationBean() {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

      // ROLE_APPLICATION: 내가 등록한 bean
      // ROLE_INFRASTRUCTURE: spring 내부에서 사용하는 bean
      if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
        Object bean = ac.getBean(beanDefinitionName);
        System.out.println("name = " + beanDefinitionName + ", object = " + bean);
      }
    }
  }

}
