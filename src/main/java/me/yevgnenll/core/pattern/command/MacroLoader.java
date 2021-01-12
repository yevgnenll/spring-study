package me.yevgnenll.core.pattern.command;

import me.yevgnenll.core.pattern.command.impl.*;

/**
 * Macro client
 */
public class MacroLoader {

  public static void main(String[] args) {
    MacroControl macroControl = new MacroControl();

    Light livingRoom = new Light("livingRoom");
    Light kitchenLight = new Light("kitchen");
    CeilingFan ceilingFan = new CeilingFan("Living Room");
    Stereo stereo = new Stereo("Living Room");

    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoom);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoom);

    LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
    LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

    CeilingFanOn ceilingFanOn = new CeilingFanOn(ceilingFan);
    CeilingFanOff ceilingFanOff = new CeilingFanOff(ceilingFan);

    StereoOnWithCdCommand stereoOnWithCdCommand = new StereoOnWithCdCommand(stereo);
    StereoOffWithCdCommand stereoOffWithCdCommand = new StereoOffWithCdCommand(stereo);

    Command[] partyOn = { livingRoomLightOn, kitchenLightOn, ceilingFanOn, stereoOnWithCdCommand};
    Command[] partyOff = { livingRoomLightOff, kitchenLightOff, ceilingFanOff, stereoOffWithCdCommand};

    MacroCommand partyOnMacro = new MacroCommand(partyOn);
    MacroCommand partyOffMacro = new MacroCommand(partyOff);

    macroControl.setCommand(0, partyOnMacro, partyOffMacro);

  }
}
