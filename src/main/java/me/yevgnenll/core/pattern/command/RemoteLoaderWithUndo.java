package me.yevgnenll.core.pattern.command;

import me.yevgnenll.core.pattern.command.impl.LightOffCommand;
import me.yevgnenll.core.pattern.command.impl.LightOnCommand;

public class RemoteLoaderWithUndo {

  public static void main(String[] args) {
    RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

    Light livingRoom = new Light("livingRoom");
    Light kitchenLight = new Light("kitchen");

    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoom);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoom);

    LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
    LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();

    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();
  }
}
