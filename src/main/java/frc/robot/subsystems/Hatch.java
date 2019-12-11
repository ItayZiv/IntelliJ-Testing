package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Global;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.states.RunState;

public class Hatch extends Subsystem {

    public final Solenoid hatchExtender1;
    public final Solenoid hatchExtender2;
    public final Solenoid hatchGrabber;

    public Hatch() {
        hatchExtender1 = new Solenoid(RobotMap.hatchExtender1);
        hatchExtender2 = new Solenoid(RobotMap.hatchExtender2);
        hatchGrabber = new Solenoid(RobotMap.hatchGrabber);

        addChild(hatchExtender1);
        addChild(hatchExtender2);
        addChild(hatchGrabber);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void setHatchExtensionState (boolean target) {
        if (!(Global.runState == RunState.SafeMode)) {
            hatchExtender1.set(target);
            hatchExtender1.set(target);
        }
    }

    public void setHatchState (boolean target) {
        if (!(Global.runState == RunState.SafeMode)) {
            hatchGrabber.set(target);
        }
    }
}
