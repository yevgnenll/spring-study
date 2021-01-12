package me.yevgnenll.core.pattern.command;

import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class MacroCommand implements Command {

  private final Command[] commands;

  @Override
  public void execute() {
    Stream.of(commands)
        .forEach(Command::execute);
  }

  @Override
  public void undo() {
    Stream.of(commands)
        .forEach(Command::undo);
  }
}
