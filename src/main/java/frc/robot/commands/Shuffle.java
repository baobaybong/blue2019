/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Shuffle extends Command {
  public Shuffle() {
    requires(Robot.shuffle);
    setTimeout(1000000);
  }

  public Shuffle(double time) {
    requires(Robot.shuffle);
    setTimeout(time);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.shuffle.shuffle();
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    Robot.shuffle.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
