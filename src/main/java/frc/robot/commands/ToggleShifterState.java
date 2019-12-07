package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleShifterState extends Command {

    public ToggleShifterState() {
        requires(Robot.m_driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.m_driveTrain.toggleShifterState();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
