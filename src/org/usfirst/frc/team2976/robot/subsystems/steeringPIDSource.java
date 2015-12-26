package org.usfirst.frc.team2976.robot.subsystems;
import org.usfirst.frc.team2976.robot.commands.readPotentiometer;

public class steeringPIDSource implements PIDSource{	
	readPotentiometer steeringpot = new readPotentiometer();
	public steeringPIDSource() {
	}
	public double getInput()	{
		return steeringpot.getSteeringPot();
	}
}
