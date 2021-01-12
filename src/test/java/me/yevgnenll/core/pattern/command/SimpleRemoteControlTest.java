package me.yevgnenll.core.pattern.command;

import me.yevgnenll.core.pattern.command.impl.LightCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRemoteControlTest {

  @Test
  void remoteControlTest() {
    SimpleRemoteControl remote = new SimpleRemoteControl();
    Light light = new Light();
    // command 객체
    LightCommand lightOn = new LightCommand(light);

    remote.setSlot(lightOn);
    remote.buttonWasPressed();
  }

}