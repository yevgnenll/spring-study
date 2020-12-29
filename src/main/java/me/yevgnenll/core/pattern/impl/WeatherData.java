package me.yevgnenll.core.pattern.impl;

import java.util.ArrayList;
import java.util.List;

import me.yevgnenll.core.pattern.Observer;
import me.yevgnenll.core.pattern.Subject;

public class WeatherData implements Subject {

  public WeatherData() {
    observers = new ArrayList<>();
  }

  private List<Observer> observers;
  private float temperature;
  private float humidity;
  private float pressure;

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    int index = observers.indexOf(o);
    if (index >= 0) {
      observers.remove(o);
    }
  }

  /**
   * 상태를 모든 observer 들에게 알려주는 역할을 한다.
   */
  @Override
  public void notifyObservers() {
    observers.stream()
        .forEach(observer -> observer.update(temperature, humidity, pressure));
  }

  public void measurementsChanged() {
    notifyObservers();
  }

  /**
   * 데이터를 받는곳, 데이터를 받으면 상태를 변경하고 모든 observer 에게 알려준다
   * @param temp
   * @param humidity
   * @param pressure
   */
  public void setMeasurements(float temp, float humidity, float pressure) {
    this.temperature = temp;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

}
