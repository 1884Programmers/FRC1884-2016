package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.nexus.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;;

public class Elevator implements Subsystem {
	private static final Elevator INSTANCE;

	private static int LIFT_CHANNEL = 0;

	private CANTalon lift;
	private Joystick joystick;

	static {
		INSTANCE = new Elevator();
	}

	public Elevator() {
		lift = new CANTalon(LIFT_CHANNEL);
		joystick = NEXUS.JOYSTICK;
	}

	@Override
	public void autonomousInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void autonomousPeriodic() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teleopInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void teleopPeriodic() {
		lift.set(joystick.getX());
	}

}
