package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Hatch;

public class ExtendHatch extends Command {

    public ExtendHatch() {
        requires(Robot.m_hatch);
    }

    @Override
    protected void initialize() {
        Robot.m_hatch.setHatchExtensionState(true);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
