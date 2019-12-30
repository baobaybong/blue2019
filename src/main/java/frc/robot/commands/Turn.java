/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Turn extends Command {
  double deg,speed,targetAngle;
  final double Roffset = 28;
  final double Loffset = -27;
  public Turn(double deg, double originalAngle) {
    this.deg=deg;
    targetAngle = originalAngle + deg;
    requires(Robot.drive);
  }

  @Override
  protected void initialize() {
    speed = deg > 0 ? 0.3:-0.3;
  }

  @Override
  protected void execute() {
    
    Robot.drive.turn(speed);
  }

  @Override
  protected boolean isFinished() {
    if(speed>0)return Robot.drive.ahrs.getAngle()>=(targetAngle - Roffset);
    else return Robot.drive.ahrs.getAngle()<=(targetAngle - Loffset);
  }

  @Override
  protected void end() {
    Robot.drive.stop();
    Timer.delay(1);
  }

  @Override
  protected void interrupted(){
    end();
  }
}
