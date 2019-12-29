/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.In;
import frc.robot.commands.Shoot_and_shuffle;
public class OI {
  public Joystick stick = new Joystick(0);
  Button b5 = new JoystickButton(stick,5);
  Button b6 = new JoystickButton(stick,6);
  Button b4 = new JoystickButton(stick,4);
  
  public OI(){
    b5.whileHeld(new In());
    b6.whileHeld(new Shoot_and_shuffle());
  }
}
