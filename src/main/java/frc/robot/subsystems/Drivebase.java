/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
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
  }
  public void straight(double speed,int time){
    leftMotor.set(speed);rightMotor.set(speed);
    try{Thread.sleep(time);}catch(InterruptedException e){}
    leftMotor.set(0);rightMotor.set(0);
  }
  public void set(double speed){
    leftMotor.set(speed);rightMotor.set(speed);
  }
  /** 
  Tham số âm -> quay trái; tham số dương -> quay phải
  */
  public void turn(double grad){
    double speed=0.004*grad;
    leftMotor.set(speed);rightMotor.set(-speed);
    try{Thread.sleep(500);}catch(InterruptedException e){}
    leftMotor.set(0);rightMotor.set(0);
    try{Thread.sleep(500);}catch(InterruptedException e){}
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}


// Test trên robot đội đỏ

// import edu.wpi.first.wpilibj.VictorSP;
// public class ExampleSubsystem extends Subsystem {
//   public VictorSP leftMotor = new VictorSP(RobotMap.LEFT_PORT);
//   public VictorSP leftSlave = new VictorSP(RobotMap.LEFT_SLAVE_PORT);
//   public VictorSP rightMotor = new VictorSP(RobotMap.RIGHT_PORT);
//   public VictorSP rightSlave = new VictorSP(RobotMap.RIGHT_SLAVE_PORT);
//   public VictorSP intake = new VictorSP(RobotMap.INTAKE_PORT);

//   public void straight(double speed,int time){
//     leftMotor.set(speed);leftSlave.set(speed);
//     rightMotor.set(speed*0.8);rightSlave.set(speed*0.8);
//     try{Thread.sleep(time*1000);}catch(InterruptedException e){}
//     leftMotor.set(0);leftSlave.set(0);
//     rightMotor.set(0);rightSlave.set(0);
//   }
// }
