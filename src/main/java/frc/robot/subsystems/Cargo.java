package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CargoJoystickControl;

public class Cargo extends Subsystem {

    private final WPI_TalonSRX m_Arm775Pro;
    private final WPI_TalonSRX m_Intake775Pro;

    public Cargo() {
        m_Arm775Pro = new WPI_TalonSRX(RobotMap.armTalonSRX);
        m_Intake775Pro = new WPI_TalonSRX(RobotMap.intakeTalonSRX);

        m_Arm775Pro.configFactoryDefault();
        m_Intake775Pro.configFactoryDefault();

        addChild(m_Arm775Pro);
        addChild(m_Intake775Pro);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new CargoJoystickControl());
    }

    public void moveArm(double speed) {
        m_Arm775Pro.set(speed);
    }

    public void controlIntake(double speed) {
        m_Intake775Pro.set(speed);
    }

    public void stop() {
        m_Arm775Pro.set(0);
        m_Intake775Pro.set(0);
    }
}
