package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RetractHatch extends Command {

    public RetractHatch() {
        requires(Robot.m_hatch);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.m_hatch.setHatchExtensionState(false);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
