// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.CanIDs.LeftMaster);
  WPI_TalonSRX leftRear = new WPI_TalonSRX(Constants.CanIDs.LeftSlave);
  WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.CanIDs.RightMaster);
  WPI_TalonSRX rightRear = new WPI_TalonSRX(Constants.CanIDs.RightSlave);

  DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);
  
  public Drivetrain() {
      leftRear.follow(leftFront);
      rightRear.follow(rightFront);
  
      rightFront.setInverted(true);
  
      drive = new DifferentialDrive(leftFront, rightFront);
}
  /** Arcade drive control */
  public void arcadeDrive(double forward, double rotation) {
    drive.arcadeDrive(forward, rotation);
  }

  /** Tank drive control */
  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  /**
   * 
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
