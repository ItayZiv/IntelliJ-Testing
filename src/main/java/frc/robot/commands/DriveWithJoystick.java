package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Global;
import frc.robot.Robot;

public class DriveWithJoystick extends Command {

    public DriveWithJoystick() {
        requires(Robot.m_driveTrain);
    }

    @Override
    protected void execute() {
        Robot.m_driveTrain.tankDrive(Robot.m_oi.leftStick.getY() * Global.driveSpeed, Robot.m_oi.rightStick.getY() * Global.driveSpeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.m_driveTrain.stop();
    }
}
