package me.yevgnenll.core.pattern.command;

import me.yevgnenll.core.pattern.command.impl.*;

/**
 * client
 */
public class RemoteLoader {

  public static void main(String[] args) {
    RemoteControl remoteControl = new RemoteControl();

    Light livingRoom = new Light("livingRoom");
    Light kitchenLight = new Light("kitchen");
    CeilingFan ceilingFan = new CeilingFan("Living Room");
    GarageDoor garageDoor = new GarageDoor("");
    Stereo stereo = new Stereo("Living Room");

    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoom);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoom);

    LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
    LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

    CeilingFanOn ceilingFanOn = new CeilingFanOn(ceilingFan);
    CeilingFanOff ceilingFanOff = new CeilingFanOff(ceilingFan);

    StereoOnWithCdCommand stereoOnWithCdCommand = new StereoOnWithCdCommand(stereo);
    StereoOffWithCdCommand stereoOffWithCdCommand = new StereoOffWithCdCommand(stereo);

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
    remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
    remoteControl.setCommand(3, stereoOnWithCdCommand, stereoOffWithCdCommand);

    System.out.println(remoteControl.toString());

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(1);
    remoteControl.offButtonWasPushed(1);
    remoteControl.onButtonWasPushed(2);
    remoteControl.offButtonWasPushed(2);
    remoteControl.onButtonWasPushed(3);
    remoteControl.offButtonWasPushed(3);

  }
}
