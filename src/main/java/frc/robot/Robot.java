/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.CloseHatch;
import frc.robot.commands.ExtendHatch;
import frc.robot.commands.OpenHatch;
import frc.robot.commands.RetractHatch;
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

  public static OI m_oi;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();

    m_driveTrain = new DriveTrain();
    m_hatch = new Hatch();
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
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
