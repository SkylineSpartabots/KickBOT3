package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.SteeringPotentiometer;
import org.usfirst.frc.team2976.robot.subsystems.snowBlower;
import org.usfirst.frc.team2976.robot.subsystems.LeftSwitch;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnDrive extends Command {
	public static snowBlower snowblower = new snowBlower();
	public SteeringPotentiometer steeringpot = new SteeringPotentiometer();
	public LeftSwitch leftswitch = new LeftSwitch();

	public TurnDrive() {
		requires(snowblower);
		requires(steeringpot);
		requires(leftswitch);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double steeringPosition = steeringpot.m_analog.get();
		double potentiometerleft = 0;
		//double potentiometer right
		final int range = 160;
		
		if (!leftswitch.m_centerSwitch.get() && OI.LeftJoyStick.getX()<0) { 	// If switch is pressed and you still want to turn right
			potentiometerleft = steeringpot.m_analog.get(); 					// set the new left position
			snowblower.turndrive.set(0);										// don't turn too far left
		}
		//else if()	{
			
		//}
		else if	(steeringPosition >= (potentiometerleft + range) && OI.LeftJoyStick.getX()>0)	{
			snowblower.turndrive.set(0);			
		}
		
		else	{
			snowblower.turndrive.set(OI.LeftJoyStick.getX() / 2);
		}
		/*
		if (steeringPosition <= (potentiometerleft) && OI.LeftJoyStick.getX() <= 0) {
			snowblower.turndrive.set(0);
		} else if (steeringPosition >= (potentiometerleft + range) && OI.LeftJoyStick.getX() >= 0) {
			snowblower.turndrive.set(0);
		} else if (OI.LeftJoyStick.getX() == 0) {

		} else {
			snowblower.turndrive.set(OI.LeftJoyStick.getX() / 2);
		}
		*/
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
