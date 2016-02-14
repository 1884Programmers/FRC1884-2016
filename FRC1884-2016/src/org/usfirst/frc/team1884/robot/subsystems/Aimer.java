package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.Joystick;

public class Aimer implements Subsystem {

	private final static double KP = 1.0 / 160.0;
	private final static double SETPOINT = 160.0;
	private final static double TOLERANCE = 5.0;

	private double output;

	private final Proportional p;

	private Joystick joystick;

	public final static Aimer INSTANCE;

	static {
		INSTANCE = new Aimer();
	}

	private Aimer() {
		p = new Proportional(KP, SETPOINT);
		joystick = NEXUS.JOYSTICK;
	}

	/**
	 * When prompted, the robot will align the center of its vision from the
	 * camera with the center of the largest contour.
	 * <p>
	 * With processed data passed from the {@link GRIP} class, the robot uses a
	 * proportional control system to align the robot to the largest contour in
	 * the camera's field of view.
	 */
	private void align() {
		Spike.INSTANCE.turnOn();
		output = p.getOutput(GRIP.INSTANCE.getCenter());
		while (Math.abs(p.getError()) > TOLERANCE) {
			output = p.getOutput(GRIP.INSTANCE.getCenter());
			WestCoastGearbox.INSTANCE.setMotorSpeed(output, output);
		}
		Spike.INSTANCE.turnOff();
		output = p.getOutput(UltrasonicSensor.INSTANCE.getDistanceInches());
		while (Math.abs(p.getError()) > TOLERANCE) {
			output = p.getOutput(UltrasonicSensor.INSTANCE.getDistanceInches());
			WestCoastGearbox.INSTANCE.setMotorSpeed(output, -output);
		}
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
		if (joystick.getRawButton(5)) {
			align();
		}
	}
}
