package me.yevgnenll.core.pattern.command;

import me.yevgnenll.core.pattern.command.impl.LightOnCommand;
import org.junit.jupiter.api.Test;

class SimpleRemoteControlTest {

  @Test
  void remoteControlTest() {
    SimpleRemoteControl remote = new SimpleRemoteControl();
    Light light = new Light("light");
    // command 객체
    LightOnCommand lightOn = new LightOnCommand(light);

    remote.setSlot(lightOn);
    remote.buttonWasPressed();
  }

}