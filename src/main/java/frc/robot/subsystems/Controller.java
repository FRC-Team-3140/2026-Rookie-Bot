package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.math.MathUtil;

public class Controller extends SubsystemBase {

    private final XboxController controller;

    private static final double DEADBAND = 0.05;

    public Controller(int port) {
        controller = new XboxController(port);
    }

    public double getDriveForward() {
        return MathUtil.applyDeadband(-controller.getLeftY(), DEADBAND);
    }

    public double getDriveTurn() {
        return MathUtil.applyDeadband(-controller.getRightX(), DEADBAND);
    }

    public double getShooterSpeed() {
        double speed = controller.getRightTriggerAxis();

        return MathUtil.applyDeadband(speed, DEADBAND);
    }
}
