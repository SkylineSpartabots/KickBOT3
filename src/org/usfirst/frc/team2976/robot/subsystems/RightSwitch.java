package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;


public class RightSwitch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DigitalInput m_rightSwitch = new DigitalInput(RobotMap.digitalRightSwitchPort);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

