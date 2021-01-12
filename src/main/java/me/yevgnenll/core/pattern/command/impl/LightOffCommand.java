package me.yevgnenll.core.pattern.command.impl;

import lombok.RequiredArgsConstructor;
import me.yevgnenll.core.pattern.command.Command;
import me.yevgnenll.core.pattern.command.Light;

@RequiredArgsConstructor
public class LightOffCommand implements Command {

  private final Light light;

  public void execute() {
    light.off();;
  }

  @Override
  public void undo() {
    light.on();
  }
}
