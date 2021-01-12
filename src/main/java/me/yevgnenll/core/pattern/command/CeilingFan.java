package me.yevgnenll.core.pattern.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CeilingFan {

  private final String name;

  public void on() {
    System.out.println(name + " celling fan on is high");
  }

  public void off() {
    System.out.println(name + " celling fan off!");
  }

}
