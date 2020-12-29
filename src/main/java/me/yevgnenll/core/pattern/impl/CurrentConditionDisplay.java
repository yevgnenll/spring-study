package me.yevgnenll.core.pattern.impl;

import me.yevgnenll.core.pattern.DisplayElement;
import me.yevgnenll.core.pattern.Observer;
import me.yevgnenll.core.pattern.Subject;

public class CurrentConditionDisplay implements Observer, DisplayElement {

  private float temperature;
  private float humidity;
  private Subject weatherData;

  public CurrentConditionDisplay(Subject subject) {
    this.weatherData = subject;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    this.temperature = temp;
    this.humidity = humidity;
    display();
  }

  @Override
  public void display() {
    System.out.println("Current condition: " +
        temperature + "F degrees and " + humidity + "% humidity");
  }

}
