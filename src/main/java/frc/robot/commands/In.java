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

public class In extends Command {
  public In() {
    requires(Robot.intake);
    setTimeout(1000000);
  }

  public In(double time) {
    requires(Robot.intake);
    setTimeout(time);
  }

  @Override
  protected void initialize() {
  }

  double speed=0.2,dif=Const.intakeSP-speed;
  @Override
  protected void execute() {
    Robot.intake.intake(speed);
    speed=Math.min(speed+dif/50,Const.intakeSP);
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    Robot.intake.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
