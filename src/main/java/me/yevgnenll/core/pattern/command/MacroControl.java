package me.yevgnenll.core.pattern.command;

import me.yevgnenll.core.pattern.command.impl.NoCommand;

public class MacroControl {

  private Command[] onCommands;
  private Command[] offCommands;

  public MacroControl() {
    onCommands = new Command[7];
    offCommands = new Command[7];
    Command noCommand = new NoCommand();
    for (int i = 0; i < onCommands.length; i ++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }
  }

  public void setCommand(int slot, Command onCommand, Command offCommand) {
    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onButtonWasPushed(int slot) {
    onCommands[slot].execute();
  }

  public void offButtonWasPushed(int slot) {
    offCommands[slot].execute();
  }

}
