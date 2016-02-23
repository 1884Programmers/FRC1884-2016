package org.usfirst.frc.team1884.robot.commands.defense_manipulator;

import org.usfirst.frc.team1884.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CarriageHoldTopLimit extends Command {

	// Time in milliseconds
	long startTime;
	int timeOutTime;

	public CarriageHoldTopLimit() {
		super();
		this.timeOutTime = 500;
	}
	
	public CarriageHoldTopLimit(int timeOutTime) {
		super();
		this.timeOutTime = timeOutTime;
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		startTime = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// TODO
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime >= timeOutTime);
	}

	// Called once after isFinished returns true
	protected void end() {
		Elevator.INSTANCE.flipReset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
	
}
