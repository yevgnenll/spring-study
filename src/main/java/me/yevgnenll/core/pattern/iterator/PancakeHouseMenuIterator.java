package me.yevgnenll.core.pattern.iterator;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenuIterator <T extends MenuItem> implements Iterator<T> {

    private List<T> breakfasts;
    private int position;

    public PancakeHouseMenuIterator(List<T> items) {
      breakfasts = items;
    }

    @Override
    public boolean hasNext() {
      return position < breakfasts.size();
    }

    @Override
    public T next() {
      T object = breakfasts.get(position);
      position = position + 1;
      return object;
    }

  @Override
  public void remove() {
    if (position <= 0)
      throw new IllegalStateException("next를 한번도 하지 않고 실행할 수 없습니다");
    breakfasts.remove(position);
  }
}
