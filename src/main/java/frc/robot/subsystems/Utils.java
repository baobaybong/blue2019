/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Utils extends Subsystem {
  public VictorSP intake = new VictorSP(RobotMap.INTAKE_PORT);
  public Spark shoot1 = new Spark(RobotMap.SHOOT_PORT);
  public Spark shoot2 = new Spark(RobotMap.SHOOT_SLAVE_PORT);
  public SpeedControllerGroup shoot = new SpeedControllerGroup(shoot1,shoot2);
  public Spark load = new Spark(RobotMap.LOAD);
  // Cái SpeedControllerGroup chính là follow thôi
  /**
	 * Điều khiển động cơ theo nút bấm
	 * @param name động cơ nào?
   * @param buttons rawbutton input của các button mình muốn sử dụng
	 */
  public void control(SpeedController name,double speed,boolean... buttons){
    boolean valid=false;
    for(boolean button:buttons)valid=valid||button;
    if(valid)name.set(speed);else name.set(0);
  }
  /**
	 * Điều khiển động cơ theo thời gian(dùng trong auto)
	 */
  public void control(SpeedController name,double speed,int time){
    name.set(speed);
    try{Thread.sleep(time);}catch(InterruptedException e){}
    name.set(0);
  }
  public Utils(){
    shoot2.setInverted(true);
    load.setInverted(true);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}