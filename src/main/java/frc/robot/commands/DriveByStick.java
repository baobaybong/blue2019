/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Const;
import frc.robot.Robot;

public class DriveByStick extends Command {
  public DriveByStick() {
    requires(Robot.drive);
  }

  @Override
  protected void initialize() {
  }
  double offset;
  @Override
  protected void execute() {
    if ((Robot.oi.stick.getRawAxis(1) == 0)||(Robot.oi.stick.getRawAxis(4)!=0)) offset = 0;
    else offset = (Robot.oi.stick.getRawAxis(1) > 0) ? -0.22 : 0.22;
    Robot.drive.mDrive.arcadeDrive
    (Robot.oi.stick.getRawAxis(4) * Const.teleRT + offset,
    -Robot.oi.stick.getRawAxis(1) * Const.teleSP);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override 
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
