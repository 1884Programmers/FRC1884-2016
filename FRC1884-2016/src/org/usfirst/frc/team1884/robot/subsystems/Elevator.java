package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;;

public class Elevator implements Subsystem {
	public static final Elevator INSTANCE;

	private static int LIFT_CHANNEL = 0;
	private static int CARRIAGE_CHANNEL = 2;

	private CANTalon lift;
	private CANTalon carriage;

	private Joystick joystick;

	private DigitalInput switch1;

	static {
		INSTANCE = new Elevator();
	}

	public Elevator() {
		lift = new CANTalon(LIFT_CHANNEL);
		carriage = new CANTalon(CARRIAGE_CHANNEL);

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
		//carriage shit
	}

}
