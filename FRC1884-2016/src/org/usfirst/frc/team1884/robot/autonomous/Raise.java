package org.usfirst.frc.team1884.robot.autonomous;

import org.usfirst.frc.team1884.robot.subsystems.Elevator;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.command.Command;

public class Raise extends Command {
	private static int ARM_POWER;
	private static int CARRIAGE_POWER;
	private static int DRIVE_POWER;
	private static int TOP_LIMIT;
	
	public Raise() {
		this.requires(Elevator.INSTANCE);
		this.requires(WestCoastGearbox.INSTANCE);
	}

	@Override
	protected void initialize() {
		Elevator.INSTANCE.setArm(ARM_POWER);
		Elevator.INSTANCE.setCarriage(CARRIAGE_POWER);
		WestCoastGearbox.INSTANCE.setMotorSpeed(DRIVE_POWER, DRIVE_POWER);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		return Elevator.INSTANCE.getCarriageDistance() >= TOP_LIMIT;
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
