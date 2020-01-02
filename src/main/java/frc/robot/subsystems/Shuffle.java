/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

// import edu.wpi.first.wpilibj.Spark;
// import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Const;
import frc.robot.RobotMap;

public class Shuffle extends Subsystem {
  public WPI_TalonSRX shuffle = new WPI_TalonSRX(RobotMap.SHUFFLE_PORT);
  public void shuffle(){
    shuffle.set(Const.shuffleSP);
  }
  public void stop(){
    shuffle.set(0);
  }
  @Override
  public void initDefaultCommand() {
  }
}