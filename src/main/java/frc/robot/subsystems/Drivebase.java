/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Const;
import frc.robot.RobotMap;
import frc.robot.commands.DriveByStick;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Drivebase extends Subsystem {
  public WPI_VictorSPX leftMotor = new WPI_VictorSPX(RobotMap.LEFT_PORT);
  public WPI_VictorSPX leftSlave = new WPI_VictorSPX(RobotMap.LEFT_SLAVE_PORT);
  public WPI_TalonSRX rightMotor = new WPI_TalonSRX(RobotMap.RIGHT_PORT);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE_PORT);
  public DifferentialDrive mDrive = new DifferentialDrive(leftMotor,rightMotor);
  public Drivebase(){
    leftSlave.follow(leftMotor);
    rightSlave.follow(rightMotor);
    rightMotor.setInverted(true);
    rightSlave.setInverted(true);
    leftMotor.setNeutralMode(NeutralMode.Brake);
    leftSlave.setNeutralMode(NeutralMode.Brake);
    rightMotor.setNeutralMode(NeutralMode.Brake);
    rightSlave.setNeutralMode(NeutralMode.Brake);
  }
  public void straight(double speed){
    leftMotor.set(speed);rightMotor.set(speed * Const.autoSP);
  }
  public void turn(){
    leftMotor.set(0.3);rightMotor.set(-0.3);
  }
  public void stop(){
    straight(0);
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveByStick());
  }
}