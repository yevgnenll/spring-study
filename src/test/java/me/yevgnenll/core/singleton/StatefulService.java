package me.yevgnenll.core.singleton;

public class StatefulService {

  private int price; // 상태를 유지하는 field

  public void order(String name, int price) {
    System.out.println("name= " + name + ", price= " + price);
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

}
