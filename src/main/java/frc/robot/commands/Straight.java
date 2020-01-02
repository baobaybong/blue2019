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
  double speed,targetAngle,difAngle;
  final int threshold = 2;
  public Straight(double speed){
    this.speed=speed;
    requires(Robot.drive);
  }

  @Override
  protected void initialize() {
    targetAngle=Robot.drive.ahrs.getAngle();
  }

  @Override
  protected void execute() {
    difAngle=Robot.drive.ahrs.getAngle()-targetAngle;
    if(difAngle>threshold){
      Robot.drive.straight(speed,speed+0.1);
    }else if(difAngle<-threshold){
      Robot.drive.straight(speed+0.1,speed);
    }else
      Robot.drive.straight(speed,speed);
  }

  @Override
  protected boolean isFinished() {
    return false;
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
