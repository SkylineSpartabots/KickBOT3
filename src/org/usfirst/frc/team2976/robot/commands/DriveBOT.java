package org.usfirst.frc.team2976.robot.commands;
import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBOT extends Command {
	public static DriveTrain drivetrain = new DriveTrain();

    public DriveBOT() {
        // Use requires() here to declare subsystem dependencies, eg. requires(chassis);
    	requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.m_drive.setTurnWheelSpeed(.1); //half of difference between wheel speed during turn
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {   	
    	drivetrain.m_drive.tankDrive(OI.LeftJoyStick, OI.LeftJoyStick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
