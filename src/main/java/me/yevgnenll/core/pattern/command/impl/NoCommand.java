package me.yevgnenll.core.pattern.command.impl;

import me.yevgnenll.core.pattern.command.Command;

public class NoCommand implements Command {

  @Override
  public void execute() {
    System.out.println("no command!");
  }

}
