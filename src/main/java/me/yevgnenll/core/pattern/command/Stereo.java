package me.yevgnenll.core.pattern.command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Stereo {

  private final String name;

  private int volume;

  public void on() {
    System.out.println(name + ": stereo on!");
  }

  public void setCd() {
    System.out.println(name + ": set and play CD");
  }

  public void setVolume(int volume) {
    this.volume = volume;
    System.out.println(name + ": volume is " + volume);
  }

  public void off() {
    volume = 0;
    System.out.println(name + " stereo volume is " + volume + " and off!");
  }
}
