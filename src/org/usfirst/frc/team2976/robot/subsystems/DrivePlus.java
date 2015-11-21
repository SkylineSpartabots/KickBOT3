package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.OI;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class DrivePlus extends RobotDrive {
	private double A=1;
	public DrivePlus(int leftMotorChannel, int rightMotorChannel) {
		super(leftMotorChannel, rightMotorChannel);
		// TODO Auto-generated constructor stub
	}

	public DrivePlus(SpeedController leftMotor, SpeedController rightMotor) {
		super(leftMotor, rightMotor);
		// TODO Auto-generated constructor stub
	}

	public DrivePlus(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}

	public DrivePlus(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor,
			SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}
	
	public void setTurnWheelSpeed(double a){
		A = a;	
	}
	
	@Override
	 public void tankDrive(GenericHID leftStick, GenericHID rightStick) {
	        if (leftStick == null || rightStick == null) {
	            throw new NullPointerException("Null HID provided");
	        }
	        double x;
	        double y;
	       //If the bot is turning right, make the left wheel faster and the right wheel slower

	  
	    	y = leftStick.getY() - A*(OI.LeftJoyStick.getX());
            x = rightStick.getY() + A*(OI.LeftJoyStick.getX());
            
	        super.tankDrive(y, x, true);        
	}

}
