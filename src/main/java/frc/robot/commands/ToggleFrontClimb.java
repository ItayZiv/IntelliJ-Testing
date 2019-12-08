package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.states.Side;
import frc.robot.subsystems.Climb;

public class ToggleFrontClimb extends Command {

    public ToggleFrontClimb() {
        requires(Robot.m_climb);
    }

    @Override
    protected void initialize() {
        Robot.m_climb.set(Side.Front, !Robot.m_climb.get(Side.Front));
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
