package org.usfirst.frc.team1884.robot.autonomous;

import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EasyAutonomous extends Command {

	long startTime;
	
    public EasyAutonomous() {
        this.requires(WestCoastGearbox.INSTANCE);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	WestCoastGearbox.INSTANCE.setMotorSpeed(-1, -1);
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis() - startTime >= 5000);
    }

    // Called once after isFinished returns true
    protected void end() {
    	WestCoastGearbox.INSTANCE.setMotorSpeed(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
