/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.states.RunState;
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
    Global.runState = m_runStateChooser.getSelected();
    setRunVariables();
  }


  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    if (m_oi.F310Gamepad.getPOV() == 0)
      new ExtendHatch();
    else if (m_oi.F310Gamepad.getPOV() == 180)
      new RetractHatch();

    if (m_oi.F310Gamepad.getBumper(GenericHID.Hand.kRight))
      new OpenHatch();
    else if (m_oi.F310Gamepad.getBumper(GenericHID.Hand.kLeft))
      new CloseHatch();

    if (m_oi.F310Gamepad.getStartButton()) {
      if (m_oi.F310Gamepad.getYButtonPressed())
        new ToggleFrontClimb();
      else if (m_oi.F310Gamepad.getBButtonPressed())
        new ToggleRearClimb();
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public void setRunVariables() {
    setRunVariables(Global.runState);
  }

  public void setRunVariables(RunState runState) {
    switch (runState) {
      case Normal:
        Global.driveSpeed = 1;
        Global.climbSolenoidEnabled = true;
        break;
      case SafeMode:
        Global.driveSpeed = 0.8;
        Global.climbSolenoidEnabled = false;
        break;
      case GuestMode:
        Global.driveSpeed = 0.4;
        Global.climbSolenoidEnabled = false;
        break;
      default:
        Global.driveSpeed = 0.1;
        Global.climbSolenoidEnabled = false;
    }
  }
}
