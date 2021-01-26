package me.yevgnenll.core.pattern.iterator;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
public class Waitress {

  private List<Menu> menus;

  public void printMenu() {
    Iterator<Menu> menuIter = menus.iterator();

    while(menuIter.hasNext()) {
      Menu menu = menuIter.next();
      printMenu(menu.createIterator());
    }
  }

  private void printMenu(Iterator iterator) {
    while (iterator.hasNext()) {
      MenuItem menuItem = (MenuItem) iterator.next();
      System.out.print(menuItem.getName() + ", ");
      System.out.print(menuItem.getPrice() + " -- ");
      System.out.println(menuItem.getDescription());
    }
  }

}
