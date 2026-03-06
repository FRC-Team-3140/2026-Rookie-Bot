
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    private TalonSRX feederRoller;
    private TalonSRX intakeLauncherRoller;

    public Shooter(){
        feederRoller = new WPI_TalonSRX(Constants.CanIDs.feederRoller);
        intakeLauncherRoller = new WPI_TalonSRX(Constants.CanIDs.intakeLauncherRoller);

        feederRoller.setNeutralMode(NeutralMode.Brake); 
        intakeLauncherRoller.setNeutralMode(NeutralMode.Brake);
    
        intakeLauncherRoller.setInverted(false                                                              ); // Invert motor to achieve the desired direction
    

    }

    public void setIntakeLauncherRoller(double percent) {
        intakeLauncherRoller.set(ControlMode.PercentOutput, percent);
    }

    public void setFeederRoller(double percent) {
        feederRoller.set(ControlMode.PercentOutput, percent); 
        }

  
    public void stop() {
        feederRoller.set(ControlMode.PercentOutput, 0);
        intakeLauncherRoller.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {
    }
}
    
