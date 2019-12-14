package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.custom.enums.ShifterState;

public class DriveTrain extends Subsystem {

    private final WPI_TalonSRX m_leftMasterCIM;
    private final WPI_TalonSRX m_leftSlaveCIM;
    private final WPI_TalonSRX m_rightMasterCIM;
    private final WPI_TalonSRX m_rightSlaveCIM;
    private final Solenoid m_shifter;

    public double driveSpeed = 1;

    public DriveTrain() {
        m_leftMasterCIM = new WPI_TalonSRX(RobotMap.frontLeftTalonSRX);
        m_leftSlaveCIM = new WPI_TalonSRX(RobotMap.rearLeftTalonSRX);
        m_rightMasterCIM = new WPI_TalonSRX(RobotMap.frontRightTalonSRX);
        m_rightSlaveCIM = new WPI_TalonSRX(RobotMap.rearRightTalonSRX);

        m_shifter = new Solenoid(RobotMap.shifter);

        m_leftMasterCIM.configFactoryDefault();
        m_leftSlaveCIM.configFactoryDefault();
        m_rightMasterCIM.configFactoryDefault();
        m_rightSlaveCIM.configFactoryDefault();
        m_leftMasterCIM.setInverted(true);
        m_leftSlaveCIM.setInverted(true);

        addChild(m_leftMasterCIM);
        addChild(m_leftSlaveCIM);
        addChild(m_rightMasterCIM);
        addChild(m_rightSlaveCIM);
        addChild(m_shifter);
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
        m_leftMasterCIM.set(leftPower);//* Robot.robotMaxSpeed);
        m_leftSlaveCIM.set(leftPower);// * Robot.robotMaxSpeed);
        m_rightMasterCIM.set(rightPower);// * Robot.robotMaxSpeed);
        m_rightSlaveCIM.set(rightPower);// * Robot.robotMaxSpeed);
    }

    public void arcadeDrive(double speed, double rotation) {
        double maxInput = Math.copySign(Math.max(Math.abs(speed), Math.abs(rotation)), speed);
        double leftPow = 0;
        double rightPow = 0;
        if (speed >= 0.0) {
            // First quadrant, else second quadrant
            if (rotation >= 0.0) {
                leftPow = maxInput;
                rightPow = speed - rotation;
            } else {
                leftPow = speed + rotation;
                rightPow = maxInput;
            }
        } else {
            // Third quadrant, else fourth quadrant
            if (rotation >= 0.0) {
                leftPow = speed + rotation;
                rightPow = maxInput;
            } else {
                leftPow = maxInput;
                rightPow = speed - rotation;
            }
        }
        m_leftMasterCIM.set(leftPow);
        m_leftSlaveCIM.set(leftPow);
        m_rightMasterCIM.set(rightPow);
        m_rightSlaveCIM.set(rightPow);
    }

    public void stop() {
        m_leftMasterCIM.set(0);
        m_leftSlaveCIM.set(0);
        m_rightMasterCIM.set(0);
        m_rightSlaveCIM.set(0);
    }

    public void setShifterState(ShifterState targetState) {
        switch (targetState) {
            case High:
                m_shifter.set(false);
                break;
            case Low:
                m_shifter.set(true);
                break;
            default:
//                m_shifter.set(m_shifter.get());
                break;
        }
    }

    public void toggleShifterState() {
        m_shifter.set(!m_shifter.get());
    }
}
