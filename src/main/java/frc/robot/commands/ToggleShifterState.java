package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ToggleShifterState extends Command {

    public ToggleShifterState() {
        requires(Robot.m_driveTrain);
    }

//    @Override
//    public synchronized void start() {
//        super.start();
//        Robot.m_driveTrain.toggleShifterState();
//    }

//     Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.m_driveTrain.toggleShifterState();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
