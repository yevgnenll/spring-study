package me.yevgnenll.core.weather;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.yevgnenll.core.pattern.impl.CurrentConditionDisplay;
import me.yevgnenll.core.pattern.impl.StatisticsDisplay;
import me.yevgnenll.core.pattern.impl.WeatherData;

public class WeatherTest {

  @Test
  @DisplayName("만들어둔 subject, observer 의 디스플레이 장치가 잘 동작하는지 확인해보자")
  void printWeatherData() {
    WeatherData weatherData = new WeatherData();

    CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
    StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
  }
}
