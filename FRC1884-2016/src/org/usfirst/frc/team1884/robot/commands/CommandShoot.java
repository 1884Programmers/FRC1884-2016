package org.usfirst.frc.team1884.robot.commands;

import org.usfirst.frc.team1884.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CommandShoot extends Command {

	boolean isFinished = false;
	
    // Called just before this Command runs the first time
    protected void initialize() {
    	Shooter.INSTANCE.shootActually();
    	isFinished = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Shooter.INSTANCE.getShooter().set(0);
		Shooter.INSTANCE.getInternalIntake().set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
