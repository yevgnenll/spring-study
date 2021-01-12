package me.yevgnenll.core.pattern.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GarageDoor {

  private final String name;

  public void on() {
    System.out.println(name + " garage door ");
  }


}
