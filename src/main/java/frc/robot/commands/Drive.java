package frc.robot.commands;

//import static frc.robot.Constants.OperatorConstants.*;
//import java.util.spi.CalendarDataProvider;
//lowk dunno what these are for but i dont know what happens if we take them out

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drivetrain;

public class Drive extends Command{
    Drivetrain driveSubsystem;
    CommandXboxController bigController;

    public Drive (Drivetrain drivesub, CommandXboxController smallbigcontroller){
        addRequirements(drivesub);
        driveSubsystem = drivesub;
        bigController = smallbigcontroller;

    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        driveSubsystem.arcadeDrive(-bigController.getLeftY(), -bigController.getRightX());
    }

    @Override
    public void end(boolean interrupted){
        driveSubsystem.arcadeDrive(0, 0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
