package me.yevgnenll.core.pattern.command.impl;

import me.yevgnenll.core.pattern.command.Command;
import me.yevgnenll.core.pattern.command.Light;

public class LightOnCommand implements Command {

  private Light light;

  public LightOnCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
   light.on();
  }
}
