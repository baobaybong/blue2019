/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Straight extends Command {
  double speed,time;
  public Straight(double speed,double time) {
    this.speed=speed;
    this.time=time;
    requires(Robot.drive);
  }

  @Override
  protected void initialize() {
    setTimeout(time);
  }

  @Override
  protected void execute() {
    Robot.drive.straight(speed);
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    Robot.drive.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
