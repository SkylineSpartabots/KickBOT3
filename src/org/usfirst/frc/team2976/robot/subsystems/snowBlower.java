package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class snowBlower extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Victor turndrive = new Victor(RobotMap.snowBlowerMotor);
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

