package me.yevgnenll.core.pattern.iterator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WaitressTest {

  @Test
  @DisplayName("메뉴를 프린팅해본다")
  void printMenu() {

    PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
    DinerMenu dinerMenu = new DinerMenu();
    CafeMenu cafeMenu = new CafeMenu();

    Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);

    waitress.printMenu();
  }

}
