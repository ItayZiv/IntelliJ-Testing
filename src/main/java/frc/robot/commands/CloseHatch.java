package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CloseHatch extends Command {

    public CloseHatch() {
        requires(Robot.m_hatch);
    }

    @Override
    protected void initialize() {
        Robot.m_hatch.setHatchState(true);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
