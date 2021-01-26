package me.yevgnenll.core.pattern.iterator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MenuItem {
    private final String name;
    private final String description;
    private final boolean vegetarian;
    private final double price;

    @Override
    public String toString() {
        return (name + ", $" + price + "\n   " + description);
    }
}
