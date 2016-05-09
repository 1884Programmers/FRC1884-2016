package org.usfirst.frc.team1884.robot.deprecated;

import org.usfirst.frc.team1884.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
@Deprecated
public class AutoFlipReset extends Command {

	public AutoFlipReset() {
		this.requires(Elevator.INSTANCE);
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	Elevator.INSTANCE.resetArm();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
