package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.custom.enums.Side;

public class ToggleRearClimb extends Command {

    public ToggleRearClimb() {
        requires(Robot.m_climb);
    }

    @Override
    protected void initialize() {
        Robot.m_climb.set(Side.Back, !Robot.m_climb.get(Side.Back));
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}
