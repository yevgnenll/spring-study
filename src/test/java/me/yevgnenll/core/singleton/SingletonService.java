package me.yevgnenll.core.singleton;

public class SingletonService {

  private SingletonService() {
  }

  // class level 에 올라가 딱 하나만 생섣된다.
  private static final SingletonService instance = new SingletonService();

  public static SingletonService getInstance() {
    return instance;
  }

  public void logic() {
    System.out.println("singleton 객체 로직 호출");
  }

}
