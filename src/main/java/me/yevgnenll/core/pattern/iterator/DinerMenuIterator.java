package me.yevgnenll.core.pattern.iterator;

import java.util.Iterator;

/**
 * 책에서 나온 코드는 generic 을 사용하지 않지만 그건 effective java 에 위배되어
 * generic 을 사용해 compile 시점에 type check를 한다
 * @param <T>
 */
public class DinerMenuIterator<T extends MenuItem> implements Iterator<T> {

    private T[] items;
    private int position = 0;

    public DinerMenuIterator(T[] items) {
        this.items = items;
    }

    @Override
    public T next() {
        T menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}
