package me.yevgnenll.core.pattern.command;

import me.yevgnenll.core.pattern.command.impl.NoCommand;

public class RemoteControlWithUndo extends RemoteControl {

  private Command undoCommand;

  public RemoteControlWithUndo() {
    super();
    undoCommand = new NoCommand();
  }

  @Override
  public void onButtonWasPushed(int slot) {
    super.onButtonWasPushed(slot);
    undoCommand = onCommands[slot];
  }

  @Override
  public void offButtonWasPushed(int slot) {
    super.offButtonWasPushed(slot);
    undoCommand = offCommands[slot];
  }

  public void undoButtonWasPushed() {
    undoCommand.undo();
  }
}
