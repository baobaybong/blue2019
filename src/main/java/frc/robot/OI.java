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
import frc.robot.commands.IntakeRev;
import frc.robot.commands.ShootRev;
import frc.robot.commands.Shoot_and_shuffle;
public class OI {
  public Joystick stick = new Joystick(0);
  public Joystick functions = new Joystick(1);

  Button lb = new JoystickButton(functions,5);
  Button rb = new JoystickButton(functions,6);
  Button b4 = new JoystickButton(stick,4);


  Button x = new JoystickButton(functions,3);
  Button b = new JoystickButton(functions,2);
  public OI(){
    b.whileHeld(new ShootRev());
    x.whileHeld(new IntakeRev());
    lb.whileHeld(new In());
    rb.whileHeld(new Shoot_and_shuffle());
  }
}
