/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.custom.enums.RunState;
import frc.robot.custom.enums.Side;
import frc.robot.subsystems.Cargo;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hatch;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static DriveTrain m_driveTrain;
  public static Hatch m_hatch;
  public static Cargo m_cargo;
  public static Climb m_climb;

  public static OI m_oi;

  public SendableChooser<RunState> m_runStateChooser;
  public SendableChooser<Side> test;

  public static double robotMaxSpeed = 1;
  public static RunState runState = RunState.Normal;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_driveTrain = new DriveTrain();
    m_hatch = new Hatch();
    m_cargo = new Cargo();
    m_climb = new Climb();

    SmartDashboard.putData(m_driveTrain);
    SmartDashboard.putData(m_hatch);
    SmartDashboard.putData(m_cargo);
    SmartDashboard.putData(m_climb);

    m_oi = new OI();

    m_runStateChooser = new SendableChooser<RunState>();
    m_runStateChooser.setDefaultOption("Normal", RunState.Normal);
    m_runStateChooser.addOption("Safe Mode", RunState.SafeMode);
    m_runStateChooser.addOption("Guest Mode", RunState.GuestMode);
    SmartDashboard.putData("Run mode", m_runStateChooser);
    Robot.runState = m_runStateChooser.getSelected();
    setRunVariables();

    test = new SendableChooser<Side>();
    test.setDefaultOption("a", Side.Front);
    test.addOption("b", Side.Back);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public void setRunVariables() {
    setRunVariables(Robot.runState);
  }

  public void setRunVariables(RunState runState) {
    switch (runState) {
      case Normal:
        m_driveTrain.driveSpeed = 1;
        m_climb.climbEnabled = true;
        m_hatch.hatchEnabled = true;
        break;
      case SafeMode:
        m_driveTrain.driveSpeed = 0.8;
        m_climb.climbEnabled = false;
        m_hatch.hatchEnabled = false;
        break;
      case GuestMode:
        m_driveTrain.driveSpeed = 0.4;
        m_climb.climbEnabled = false;
        m_hatch.hatchEnabled = true;
        break;
      default:
        m_driveTrain.driveSpeed = 0.1;
        m_climb.climbEnabled = false;
        m_hatch.hatchEnabled = false;
    }
  }
}
