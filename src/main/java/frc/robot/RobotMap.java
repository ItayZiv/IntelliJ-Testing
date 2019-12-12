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
//   public static int leftJoystick = 0;
   public static int rightJoystick = 1;
   public static int rightJoystickShifterButton = 1;
   public static int F310Gamepad = 2;

  // CAN Devices
    //Drivetrain
   public static int frontLeftTalonSRX = 0;
   public static int frontRightTalonSRX = 1;
   public static int rearLeftTalonSRX = 2;
   public static int rearRightTalonSRX = 3;

   public static int armTalonSRX = 4;
   public static int intakeTalonSRX = 5;

   //PCM
   public static int shifter = 0;
   public static int hatchGrabber = 1;
   public static int hatchExtender = 2;
   public static int frontClimb = 3;
   public static int rearClimb = 4;;
}
