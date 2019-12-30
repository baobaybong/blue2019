/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Cannon extends Subsystem {
  public Spark shoot1 = new Spark(RobotMap.SHOOT1_PORT);
  public Spark shoot2 = new Spark(RobotMap.SHOOT2_PORT);
  public SpeedControllerGroup shoot = new SpeedControllerGroup(shoot1,shoot2);
  public Spark load = new Spark(RobotMap.LOAD_PORT);
  public Cannon(){
    shoot2.setInverted(true);
    load.setInverted(true);
  }
  public void shoot(){
    shoot.set(0.95);
    Timer.delay(1);
    load.set(0.6);
  }
  public void shootRev(){
    shoot.set(-0.7);
    load.set(-0.3);
  }
  public void stop(){
    shoot.set(0);
    load.set(0);
  }
  @Override
  public void initDefaultCommand() {
  }
}