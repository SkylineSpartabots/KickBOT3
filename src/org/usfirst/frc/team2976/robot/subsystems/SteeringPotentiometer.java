package org.usfirst.frc.team2976.robot.subsystems;
import org.usfirst.frc.team2976.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class SteeringPotentiometer extends Subsystem  {
	//The rack and pinion wheels move from a left most position to a right most position.
	//Taking the left most position as zero, the bar moves 2.6 linear inches to get to the right most position
	double fullRange = 3600;
	
	//The center position, when the robot is driving straight is half of the fullRange.  The offset is based
	//moving back from the right most position
    double offset = -142;
    
	public AnalogPotentiometer m_analog = new AnalogPotentiometer(RobotMap.analogPotentiometerPort, fullRange,  offset);
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        
    } 
}

