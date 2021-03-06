package me.yevgnenll.core.pattern.command;

import lombok.RequiredArgsConstructor;

/**
 * Receiver
 */
@RequiredArgsConstructor
public class Light {

  private final String name;

  public void on() {
    System.out.println(name + " turn on light");
  }

  public void off() {
    System.out.println(name + " turn off light");
  }
}
