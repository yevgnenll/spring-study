package me.yevgnenll.core.pattern.command.impl;

import lombok.RequiredArgsConstructor;
import me.yevgnenll.core.pattern.command.CeilingFan;
import me.yevgnenll.core.pattern.command.Command;

@RequiredArgsConstructor
public class CeilingFanOn implements Command {

  private final CeilingFan ceilingFan;

  @Override
  public void execute() {
    ceilingFan.on();
  }

  @Override
  public void undo() {
    ceilingFan.off();
  }
}
