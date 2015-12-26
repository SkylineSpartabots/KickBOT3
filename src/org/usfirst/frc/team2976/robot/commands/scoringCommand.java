package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class scoringCommand extends Command {
	public Shooter shooter = new Shooter();
	public boolean action = false;
	final int BUTTON_PAUSE = 500;	
	public long prevTime = 0;
	public scoringCommand() {
	 	requires(shooter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (OI.LeftJoyStick.getRawButton(OI.Button.X.getBtnNumber()) && (System.currentTimeMillis() - prevTime) > BUTTON_PAUSE) {
			action = !action;
			prevTime = System.currentTimeMillis();
		}
		if (action) {
			shooter.wheelMotor.set(1);
		} else {
			shooter.wheelMotor.set(0);
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
