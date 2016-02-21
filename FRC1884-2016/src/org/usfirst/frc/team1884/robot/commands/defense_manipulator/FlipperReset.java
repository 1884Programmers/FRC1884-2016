package org.usfirst.frc.team1884.robot.commands.defense_manipulator;

import org.usfirst.frc.team1884.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

class FlipperReset extends Command {

	@Override
	protected void initialize() {
		Elevator.INSTANCE.flipReset();
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
