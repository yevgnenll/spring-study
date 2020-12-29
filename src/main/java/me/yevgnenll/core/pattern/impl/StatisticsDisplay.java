package me.yevgnenll.core.pattern.impl;

import java.util.ArrayList;
import java.util.List;

import me.yevgnenll.core.pattern.DisplayElement;
import me.yevgnenll.core.pattern.Observer;
import me.yevgnenll.core.pattern.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {

  private List<Float> temperatures;
  private float max = Float.MIN_VALUE;
  private float min = Float.MAX_VALUE;
  private float avg = 0;
  private final Subject weatherData;

  public StatisticsDisplay(Subject weatherData) {
    this.temperatures = new ArrayList<>();
    this.weatherData = weatherData;
    this.weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("Avg/Max/Min: temperature= " + avg + "/" + max + "/" + min);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    temperatures.add(temp);
    max = Math.max(temp, max);
    min = Math.min(temp, min);
    avg = (float) temperatures.stream()
        .mapToDouble(v -> v)
        .average()
        .orElse(0.0f);
    display();
  }

}
