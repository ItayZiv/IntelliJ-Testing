package frc.robot.custom.classes;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;

public class commandXboxController extends XboxController {

    private enum Button {
        kBumperLeft(5),
        kBumperRight(6),
        kStickLeft(9),
        kStickRight(10),
        kA(1),
        kB(2),
        kX(3),
        kY(4),
        kBack(7),
        kStart(8);

        @SuppressWarnings({"MemberName", "PMD.SingularField"})
        private final int value;

        Button(int value) {
            this.value = value;
        }
    }

    public JoystickButton A;
    public JoystickButton B;
    public JoystickButton X;
    public JoystickButton Y;
    public JoystickButton leftBumper;
    public JoystickButton rightBumper;
    public JoystickButton Back;
    public JoystickButton Start;
    public JoystickButton leftStick;
    public JoystickButton rightStick;
    public POVButton dpad_up;
    public POVButton dpad_right;
    public POVButton dpad_down;
    public POVButton dpad_left;

    public commandXboxController(final int port) {
        super(port);

        A = new JoystickButton(this, Button.kA.value);
        B = new JoystickButton(this, Button.kB.value);
        X = new JoystickButton(this, Button.kX.value);
        Y = new JoystickButton(this, Button.kY.value);
        leftBumper = new JoystickButton(this, Button.kBumperLeft.value);
        rightBumper = new JoystickButton(this, Button.kBumperRight.value);
        Back = new JoystickButton(this, Button.kBack.value);
        Start = new JoystickButton(this, Button.kStart.value);
        leftStick = new JoystickButton(this, Button.kStickLeft.value);
        rightStick = new JoystickButton(this, Button.kStickRight.value);
        dpad_up = new POVButton(this, 0);
        dpad_right = new POVButton(this, 90);
        dpad_down = new POVButton(this, 180);
        dpad_left = new POVButton(this, 270);
    }
}
