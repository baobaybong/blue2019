/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Auto;
import frc.robot.subsystems.Cannon;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shuffle;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Drivebase drive = new Drivebase();
  public static Intake intake = new Intake();
  public static Cannon cannon = new Cannon();
  public static Shuffle shuffle = new Shuffle();
  public static OI oi;
  public static Command autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  public static double x=0;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    oi = new OI();
    autonomousCommand = new Auto();
    drive.ahrs.zeroYaw();
    // m_chooser.setDefaultOption("Default Auto", new Auto());
    // chooser.addOption("My Auto", new MyAutoCommand());
    // SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    x = drive.ahrs.getYaw();
    SmartDashboard.putNumber("yaw", x);
  }
  
  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    drive.setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    drive.setNeutralMode(NeutralMode.Brake);
    drive.ahrs.zeroYaw();
    // autonomousCommand = m_chooser.getSelected();
    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }

  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }
  boolean wasHeld,held;
  @Override
  public void teleopInit() {
    wasHeld = false;
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    drive.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void teleopPeriodic() {
    held = oi.functions.getRawButton(4);
    if(!wasHeld && held){
      Const.teleSP = 1.2-Const.teleSP;
      Const.teleRT = 0.9-Const.teleRT;
    }
    wasHeld = held;
    // if(oi.functions.getTrigger())
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
