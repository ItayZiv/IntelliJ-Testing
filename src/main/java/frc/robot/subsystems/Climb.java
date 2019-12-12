package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.states.Side;

public class Climb extends Subsystem {

    private final Solenoid m_frontClimb;
    private final Solenoid m_rearClimb;

    public boolean climbEnabled = false;

    public Climb() {
        m_frontClimb = new Solenoid(RobotMap.frontClimb);
        m_rearClimb = new Solenoid(RobotMap.rearClimb);

        addChild(m_frontClimb);
        addChild(m_rearClimb);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void set(Side side, boolean target) {
        if (climbEnabled) {
            switch (side) {
                case Front:
                    m_frontClimb.set(target);
                    break;
                case Back:
                    m_rearClimb.set(target);
                    break;
                default:
                    break;
            }
        }
    }

    public boolean get(Side side) {
        switch (side) {
            case Front:
                return m_frontClimb.get();
            case Back:
                return m_rearClimb.get();
            default:
                return m_frontClimb.get() | m_rearClimb.get();
        }
    }
}
