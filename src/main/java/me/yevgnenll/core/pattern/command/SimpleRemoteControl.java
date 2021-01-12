package me.yevgnenll.core.pattern.command;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SimpleRemoteControl {

  private Command slot;

  public void setSlot(Command command) {
    this.slot = command;
  }

  public void buttonWasPressed() {
    slot.execute();
  }

}
