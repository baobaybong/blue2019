/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class Auto extends CommandGroup {
  public Auto() {
    addParallel(new In(),10);
    addSequential(new Straight(0.5),3.1);
    addSequential(new Turn(90, 0),5);
    addSequential(new Straight(0.5),4.3);
    addSequential(new Turn(-90,90),5);
    addSequential(new Straight(0.6),4);
  }
}