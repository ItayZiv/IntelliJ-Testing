package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CargoJoystickControl extends Command {

    public CargoJoystickControl() {
        requires(Robot.m_cargo);
    }

    @Override
    protected void execute() {
        Robot.m_cargo.moveArm(Robot.m_oi.F310Gamepad.getY(GenericHID.Hand.kRight));
        Robot.m_cargo.controlIntake(Robot.m_oi.F310Gamepad.getY(GenericHID.Hand.kLeft));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.m_cargo.stop();
    }
}
