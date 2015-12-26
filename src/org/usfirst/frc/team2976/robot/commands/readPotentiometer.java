package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.subsystems.SteeringPotentiometer;
/**
 *
 */
public class readPotentiometer {
	public SteeringPotentiometer steeringpot = new SteeringPotentiometer();
    public readPotentiometer() {
    }

    public double getSteeringPot()	{
    	return steeringpot.m_analog.get();
    }
    // Called just before this Command runs the first time
 
}
