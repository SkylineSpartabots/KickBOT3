package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.SteeringPotentiometer;
import org.usfirst.frc.team2976.robot.subsystems.snowBlower;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnDrive extends Command {
	public static snowBlower snowblower= new snowBlower();
	public SteeringPotentiometer steeringpot = new SteeringPotentiometer();
	
	public TurnDrive() {
    	requires(snowblower);
    	requires(steeringpot);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
// 700-800
    // Called repeatedly when this Command is scheduled to run
    	 protected void execute() {
    	    	double steeringPosition = steeringpot.m_analog.get();
    	    	
    	    	if(steeringPosition<=800 && OI.LeftJoyStick.getX()<=0){
    	    		snowblower.turndrive.set(0);
    	    	}
    	    	else if (steeringPosition >=920 && OI.LeftJoyStick.getX()>=0){
    	    		snowblower.turndrive.set(0);
    	    	}
    	    	else{
    	    		snowblower.turndrive.set(OI.LeftJoyStick.getX()/2);
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
