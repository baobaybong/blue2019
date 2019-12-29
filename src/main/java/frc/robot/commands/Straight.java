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
  double left,right;
  public Straight(double left,double right){
    this.left=left;
    this.right=right;
    requires(Robot.drive);
    setTimeout(1000000);
  }
  // public Straight(double speed,double time) {
  //   this.speed=speed;
  //   requires(Robot.drive);
  //   setTimeout(time);
  // }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if(Robot.x > 5){
      Robot.drive.straight(left,right+0.2);
    }
    else if(Robot.x <-5){
      Robot.drive.straight(left+0.2,right);
    }
    else{
      Robot.drive.straight(left,right);
    }
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
