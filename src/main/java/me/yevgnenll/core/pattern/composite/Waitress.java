package me.yevgnenll.core.pattern.composite;

public class Waitress {

  public Waitress(MenuComponent menuComponent) {
    this.allMenu= menuComponent;
  }

  private MenuComponent allMenu;

  public void printMenu() {
    allMenu.print();
  }

}
