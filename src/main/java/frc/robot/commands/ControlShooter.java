package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Shooter;
//import frc.robot.Constants; Might be important. KP

public class ControlShooter extends Command{
    Shooter fuelSubsystem;
    CommandXboxController bigController;
    
    public ControlShooter (Shooter fuelSystem, CommandXboxController smallbigcontroller){
        addRequirements(fuelSystem);
        fuelSubsystem = fuelSystem;
        bigController = smallbigcontroller;
        
    }
    
    @Override
    public void initialize() {
    }
    
    @Override
    public void execute() {
        fuelSubsystem.setIntakeLauncherRoller(bigController.getRightTriggerAxis());
        double feederSpeed = 0.75;
        if(bigController.getLeftTriggerAxis() < 0.67 && !bigController.leftBumper().getAsBoolean()) feederSpeed = 0;
        if(bigController.getLeftTriggerAxis() > 0.67) feederSpeed *= -1; 
        fuelSubsystem.setFeederRoller(feederSpeed);
    }

    @Override
        public void end(boolean interrupted) {
    }

    @Override
        public boolean isFinished() {
        return false;
    }
}

