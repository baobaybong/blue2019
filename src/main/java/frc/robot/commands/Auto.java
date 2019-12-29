/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup {
  public Auto() {
    addSequential(new Straight(0.5,5));
    // addSequential(new Turn(0.3,2));
    // addSequential(new Straight(0.5,2));
  }
}
