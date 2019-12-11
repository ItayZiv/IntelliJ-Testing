package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Global;
import frc.robot.RobotMap;
import frc.robot.states.Side;

public class Climb extends Subsystem {

    private final Solenoid m_frontLeftClimb;
    private final Solenoid m_frontRightClimb;
    private final Solenoid m_rearLeftClimb;
    private final Solenoid m_rearRightClimb;

    public Climb() {
        m_frontLeftClimb = new Solenoid(RobotMap.frontLeftClimb);
        m_frontRightClimb = new Solenoid(RobotMap.frontRightClimb);
        m_rearLeftClimb = new Solenoid(RobotMap.rearLeftClimb);
        m_rearRightClimb = new Solenoid(RobotMap.rearRightClimb);

        addChild(m_frontLeftClimb);
        addChild(m_frontRightClimb);
        addChild(m_rearLeftClimb);
        addChild(m_rearRightClimb);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void set(Side side, boolean target) {
        if (Global.climbSolenoidEnabled) {
            switch (side) {
                case Front:
                    m_frontLeftClimb.set(target);
                    m_frontRightClimb.set(target);
                    break;
                case Back:
                    m_rearLeftClimb.set(target);
                    m_rearRightClimb.set(target);
                    break;
                default:
                    break;
            }
        }
        else {
            m_frontLeftClimb.set(false);
            m_frontRightClimb.set(false);
            m_rearLeftClimb.set(false);
            m_rearRightClimb.set(false);
        }
    }

    public boolean get(Side side) {
        switch (side) {
            case Front:
                return m_frontLeftClimb.get() | m_frontRightClimb.get();
            case Back:
                return m_rearLeftClimb.get() | m_rearRightClimb.get();
            default:
                return m_frontLeftClimb.get() | m_frontRightClimb.get() | m_rearLeftClimb.get() | m_rearRightClimb.get();
        }
    }
}
