package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.states.ShifterState;

public class DriveTrain extends Subsystem {

    private final WPI_TalonSRX m_leftMasterCIM;
    private final WPI_TalonSRX m_leftSlaveCIM;
    private final WPI_TalonSRX m_rightMasterCIM;
    private final WPI_TalonSRX m_rightSlaveCIM;
    private final Solenoid m_leftShifter;
    private final Solenoid m_rightShifter;

    public double driveSpeed = 1;

    public DriveTrain() {
        m_leftMasterCIM = new WPI_TalonSRX(RobotMap.frontLeftTalonSRX);
        m_leftSlaveCIM = new WPI_TalonSRX(RobotMap.rearLeftTalonSRX);
        m_rightMasterCIM = new WPI_TalonSRX(RobotMap.frontRightTalonSRX);
        m_rightSlaveCIM = new WPI_TalonSRX(RobotMap.rearRightTalonSRX);

        m_leftShifter = new Solenoid(RobotMap.leftShifter);
        m_rightShifter = new Solenoid(RobotMap.rightShifter);

        m_leftMasterCIM.configFactoryDefault();
        m_rightMasterCIM.configFactoryDefault();
        m_rightMasterCIM.setInverted(true);
        configSlave(m_leftSlaveCIM, m_leftMasterCIM);
        configSlave(m_leftSlaveCIM, m_leftMasterCIM);

        addChild(m_leftMasterCIM);
        addChild(m_leftSlaveCIM);
        addChild(m_rightMasterCIM);
        addChild(m_rightSlaveCIM);
        addChild(m_leftShifter);
        addChild(m_rightShifter);
    }

    public void configSlave(WPI_TalonSRX slave, WPI_TalonSRX master) {
        slave.configFactoryDefault();
        slave.follow(master);
        slave.setInverted(InvertType.FollowMaster);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }

    public void tankDrive(double Power) {
        tankDrive(Power, Power);
    }

    public void tankDrive(double leftPower, double rightPower) {
        m_leftMasterCIM.set(leftPower * Robot.robotMaxSpeed);
        m_rightMasterCIM.set(rightPower * Robot.robotMaxSpeed);
    }

    public void stop() {
        m_leftMasterCIM.set(0);
        m_rightMasterCIM.set(0);
    }

    public void setShifterState(ShifterState targetState) {
        switch (targetState) {
            case High:
                m_leftShifter.set(false);
                m_rightShifter.set(false);
                break;
            case Low:
                m_leftShifter.set(true);
                m_rightShifter.set(true);
                break;
            default:
                m_rightShifter.set(m_leftShifter.get());
        }
    }

    public void toggleShifterState() {
        m_leftShifter.set(!m_leftShifter.get());
        m_rightShifter.set(!m_rightShifter.get());
    }
}
