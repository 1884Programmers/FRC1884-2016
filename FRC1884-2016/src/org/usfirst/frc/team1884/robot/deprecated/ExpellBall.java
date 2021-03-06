package org.usfirst.frc.team1884.robot.deprecated;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
@Deprecated
public class ExpellBall extends Command {
	
	long startTime;
	int timeOutTime = 500;
	
	public ExpellBall() {
		this.requires(Shooter.INSTANCE);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		startTime = System.currentTimeMillis();
		Shooter.INSTANCE.getShooter().set(-1);
		Shooter.INSTANCE.getInternalIntake().set(-1);
		Shooter.INSTANCE.getExternalIntake().set(0.5);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime >= timeOutTime);
	}

	// Called once after isFinished returns true
	protected void end() {
		Shooter.INSTANCE.getShooter().set(0);
		Shooter.INSTANCE.getInternalIntake().set(0);
		Shooter.INSTANCE.getExternalIntake().set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Shooter.INSTANCE.getShooter().set(0);
		Shooter.INSTANCE.getInternalIntake().set(0);
		Shooter.INSTANCE.getExternalIntake().set(0);
	}
}
