package frc.robot;

import frc.robot.states.RunState;

public class Global {

    //TODO: Get rid of global!!!!!

    public final static double robotMaxSpeed = 1;

    public static double driveSpeed = 1;
    public static boolean climbSolenoidEnabled = false;

    public static RunState runState = RunState.Normal;
}
