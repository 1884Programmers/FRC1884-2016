package org.usfirst.frc.team1884.robot.deprecated;

import org.usfirst.frc.team1884.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

@Deprecated
public class FlipperReset extends Command {

	@Override
	protected void initialize() {
		Elevator.INSTANCE.flipReset();
	}

	@Override
	protected void execute() {}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}

}
