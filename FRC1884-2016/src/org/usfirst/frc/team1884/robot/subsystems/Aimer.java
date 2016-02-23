package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.Joystick;

public class Aimer {

	private final static double KP = 1.0 / 160.0;
	private final static double SETPOINT = 160.0;
	private final static double TOLERANCE = 5.0;

	private double output;

	private final Proportional p;

	private Joystick joystick;

	public final static Aimer INSTANCE;

	private boolean beginAlign = false;
	private boolean setup = false;

	static {
		INSTANCE = new Aimer();
	}

	private Aimer() {
		p = new Proportional(KP, SETPOINT);
		joystick = NEXUS.DRIVESTICK;
	}

	/**
	 * When prompted, the robot will align the center of its vision from the
	 * camera with the center of the largest contour.
	 * <p>
	 * With processed data passed from the {@link GRIP} class, the robot uses a
	 * proportional control system to align the robot to the largest contour in
	 * the camera's field of view.
	 */
	public void alignAuto() {
		Spike.INSTANCE.turnOn();
		output = p.getOutput(GRIP.INSTANCE.getCenter());
		while (Math.abs(p.getError()) > TOLERANCE) {
			if (!(GRIP.INSTANCE.getCenter() == -1)) {
				output = p.getOutput(GRIP.INSTANCE.getCenter());
				WestCoastGearbox.INSTANCE.setMotorSpeed(output, output);
			}
		}
		Spike.INSTANCE.turnOff();
		output = p.getOutput(UltrasonicSensor.INSTANCE.getDistanceInches());
		while (Math.abs(p.getError()) > TOLERANCE) {
			output = p.getOutput(UltrasonicSensor.INSTANCE.getDistanceInches());
			WestCoastGearbox.INSTANCE.setMotorSpeed(output, -output);
		}
	}

	// Called on the rising edge of aligning
	public void alignSetup() {
		Spike.INSTANCE.turnOn();
		output = p.getOutput(GRIP.INSTANCE.getCenter());
	}

	public void align() {
		if (Math.abs(p.getError()) > TOLERANCE) {
			output = p.getOutput(GRIP.INSTANCE.getCenter());
			WestCoastGearbox.INSTANCE.setMotorSpeed(output, output);
		} else {
			beginAlign = true;
			if (beginAlign) {
				Spike.INSTANCE.turnOff();
			}
			output = p.getOutput(UltrasonicSensor.INSTANCE.getDistanceInches());

			if (Math.abs(p.getError()) > TOLERANCE) {
				output = p.getOutput(UltrasonicSensor.INSTANCE.getDistanceInches());
				WestCoastGearbox.INSTANCE.setMotorSpeed(output, -output);
			} else {
				System.out.println("\n\n\n\n\nI have finished aligning!");
			}
		}
		if (beginAlign) {
			beginAlign = false;
		}
	}

	public void teleopInit() {
		// TODO Auto-generated method stub

	}

	public void teleopPeriodic() {
		if (joystick.getRawAxis(2) > 0.1) {
			if (setup) {
				align();
			} else {
				alignSetup();
				setup = true;
			}
		} else {
			setup = false;
		}
	}
}
