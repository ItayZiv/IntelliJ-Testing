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
   public static int F310Gamepad = 2;

  // CAN Devices
    //Drivetrain
   public static int frontLeftTalonSRX = 1;
   public static int frontRightTalonSRX = 2;
   public static int rearLeftTalonSRX = 3;
   public static int rearRightTalonSRX = 4;

   public static int armTalonSRX = 5;
   public static int intakeTalonSRX = 6;

   //PCM
   public static int leftShifter = 0;
   public static int rightShifter = 1;
   public static int hatchExtender1 = 2;
   public static int hatchExtender2 = 3;
   public static int hatchGrabber = 4;
}
