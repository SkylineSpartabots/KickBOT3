package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.DefinePotentiometer;
import org.usfirst.frc.team2976.robot.subsystems.snowBlower;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnDrive extends Command {
public static snowBlower snowblower= new snowBlower();
public static DefinePotentiometer pot = new DefinePotentiometer();
    public TurnDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(snowblower);
 //   	requires(pot);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
// 700-800
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double reading = 750;//pot.m_analog.get();
    	double in = OI.RightJoyStick.getX();
    	if(reading==700 && in<=0){
    		snowblower.turndrive.set(0);
    	}
    	else if (reading ==800 && in>=0){
    		snowblower.turndrive.set(0);
    	}
    	else{
    	snowblower.turndrive.set(in/3);
    	}
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
    }
}
