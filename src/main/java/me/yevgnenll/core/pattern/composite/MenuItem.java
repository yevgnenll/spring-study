package me.yevgnenll.core.pattern.composite;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MenuItem extends MenuComponent {

    private final String name;
    private final String description;
    private final boolean vegetarian;
    private final double price;

    @Override
    public String toString() {
        return (name + ", $" + price + "\n   " + description);
    }

    public void print() {
      System.out.print("  " + getName());
      if (isVegetarian()) {
        System.out.print("(v)");
      }
      System.out.println(", " + getPrice());
      System.out.println("     -- " + getDescription());
    }
}
