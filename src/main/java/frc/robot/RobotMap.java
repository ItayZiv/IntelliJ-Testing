/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // OI
   public static int leftJoystick = 0;
   public static int rightJoystick = 1;
   public static int rightJoystickShifterButton = 0;
  // CAN Devices
    //Drivetrain
   public static int frontLeftTalonSRX = 1;
   public static int frontRightTalonSRX = 2;
   public static int rearLeftTalonSRX = 3;
   public static int rearRightTalonSRX = 4;

   //PCM
   public static int leftShifter = 0;
   public static int rightShifter = 1;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
