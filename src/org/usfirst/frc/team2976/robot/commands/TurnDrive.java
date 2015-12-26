package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.snowBlower;
import org.usfirst.frc.team2976.robot.subsystems.LeftSwitch;
import org.usfirst.frc.team2976.robot.subsystems.PIDMain;
import org.usfirst.frc.team2976.robot.subsystems.RightSwitch;
import org.usfirst.frc.team2976.robot.subsystems.steeringPIDSource;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2976.robot.commands.readPotentiometer;
/**
 * Command for 
 *
 */
public class TurnDrive extends Command {
	final int readPOTValue = 100; /**delay before successive PID calculations  */
	final int centerValue = 966; //Potentiometer value when wheels are centered
	/** Proportional gain */
	double kp = 0.008;	
	/**Integral Gain */
	double ki = 0;	
	/**Derivative Gain*/
	double kd = 0.002;
	
	public static snowBlower snowblower = new snowBlower();
	public LeftSwitch leftswitch = new LeftSwitch();
	public RightSwitch rightswitch = new RightSwitch();
	
	public steeringPIDSource pidsource = new steeringPIDSource();
	public PIDMain centerPID = new PIDMain(pidsource,centerValue,readPOTValue,kp,ki,kd); 
	//public readPotentiometer readpot = new readPotentiometer();
	
	/*
	 * public PIDMain(PIDSource pidsource,int setpoint, int sampleTime, double kp, double ki, double kd)
	 */
	
	double potentiometerLeft;
	double potentiometerRight;
	double steeringPosition;
	double centerPotValue;
	static final double CENTER_THRESHOLD = 0.2;

	public TurnDrive() {
		requires(snowblower);
		requires(leftswitch);
		requires(rightswitch);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		double min = -1/1.5;
		double max = 1/1.5;
		centerPID.isEnabled(true);
		centerPID.setOutputLimits(min, max);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		centerPID.isEnabled(true);
		centerPID.setSetpoint(100*OI.LeftJoyStick.getX()+966);
		if (!leftswitch.m_leftSwitch.get() && -centerPID.getOutput() < 0) {
			//centerPID.isEnabled(false);
			//potentiometerLeft = readpot.getSteeringPot(); // set the new left position
			snowblower.turndrive.set(0); // don't turn too far left
		} else if (!rightswitch.m_rightSwitch.get() && -centerPID.getOutput() > 0) {
			//centerPID.isEnabled(false);
			//potentiometerRight = readpot.getSteeringPot(); // set the new left position											 
			snowblower.turndrive.set(0); // don't turn too far right
		} 
		else 	{
		snowblower.turndrive.set(-centerPID.getOutput());
		}
		
		SmartDashboard.putNumber("PotentiometerPIDInput", centerPID.getInput());
		SmartDashboard.putNumber("PotentiometerPIDError", centerPID.getError());
		SmartDashboard.putNumber("PotentiometerPIDSetpoint", centerPID.getSetpoint());
		SmartDashboard.putNumber("PotentiometerPIDOutput", centerPID.getOutput());
		snowblower.turndrive.set(-centerPID.getOutput());
		
		
		/*
		//steeringPosition = readpot.getSteeringPot();
		SmartDashboard.putNumber("Potentiometer", steeringPosition);
		if (!leftswitch.m_leftSwitch.get() && OI.LeftJoyStick.getX() < 0) {
			centerPID.isEnabled(false);
			//potentiometerLeft = readpot.getSteeringPot(); // set the new left position
			snowblower.turndrive.set(0); // don't turn too far left
		} else if (!rightswitch.m_rightSwitch.get() && OI.LeftJoyStick.getX() > 0) {
			centerPID.isEnabled(false);
			//potentiometerRight = readpot.getSteeringPot(); // set the new left position											 
			snowblower.turndrive.set(0); // don't turn too far right
		
		} else if (Math.abs(OI.LeftJoyStick.getX()) < CENTER_THRESHOLD) {
			centerPID.isEnabled(true);
			SmartDashboard.putNumber("PotentiometerPIDInput", centerPID.getInput());
			SmartDashboard.putNumber("PotentiometerPIDError", centerPID.getError());
			SmartDashboard.putNumber("PotentiometerPIDSetpoint", centerPID.getSetpoint());
			SmartDashboard.putNumber("PotentiometerPIDOutput", centerPID.getOutput());
			snowblower.turndrive.set(-centerPID.getOutput());
		} else {
			centerPID.isEnabled(false);
			snowblower.turndrive.set(OI.LeftJoyStick.getX() / 1.5);
		}
		*/
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		//end();
	}
	protected void interrupted() {
		//end();
	}	
}
