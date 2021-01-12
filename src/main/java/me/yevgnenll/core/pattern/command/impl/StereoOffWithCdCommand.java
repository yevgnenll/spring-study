package me.yevgnenll.core.pattern.command.impl;

import lombok.RequiredArgsConstructor;
import me.yevgnenll.core.pattern.command.Command;
import me.yevgnenll.core.pattern.command.Stereo;

@RequiredArgsConstructor
public class StereoOffWithCdCommand implements Command {

  private final Stereo stereo;

  @Override
  public void execute() {
    stereo.off();
  }

  @Override
  public void undo() {
    stereo.on();
    stereo.setCd();
    stereo.setVolume(11);
  }
}
