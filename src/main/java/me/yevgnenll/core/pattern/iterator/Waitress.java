package me.yevgnenll.core.pattern.iterator;

import lombok.AllArgsConstructor;

import java.util.Iterator;

@AllArgsConstructor
public class Waitress {

    private Menu pancakeHouseMenu;
    private Menu dinerMenu;
    private Menu caffeMenu;

    public void printMenu() {

      Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
      Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
      Iterator<MenuItem> dinnerIterator = caffeMenu.createIterator();

      System.out.println("MENU\n----\nBREAKFAST");
      printMenu(pancakeIterator);
      System.out.println("\nLUNCH");
      printMenu(dinerIterator);
      System.out.println("\nDinner");
      printMenu(dinnerIterator);
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
