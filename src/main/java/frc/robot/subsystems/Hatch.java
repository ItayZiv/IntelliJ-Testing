package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Hatch extends Subsystem {

    public final Solenoid hatchExtender;
    public final Solenoid hatchGrabber;

    public boolean hatchEnabled = true;

    public Hatch() {
        hatchExtender = new Solenoid(RobotMap.hatchExtender);
        hatchGrabber = new Solenoid(RobotMap.hatchGrabber);

        addChild(hatchExtender);
        addChild(hatchGrabber);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void setHatchExtensionState (boolean target) {
//        if (hatchEnabled) {
            hatchExtender.set(target);
//        }
    }

    public void setHatchState (boolean target) {
//        if (hatchEnabled) {
            hatchGrabber.set(target);
//        }
    }
}
