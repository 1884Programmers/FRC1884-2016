package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.TalonSRX;

/**
 * Helps the robot aim towards the goal using Vision Tracking.
 * 
 * @author Kaito Arai
 * @version 2
 * @since 21/1/2016
 *
 */
public class Aimer {
	private final static double KP = 1.0 / 160.0;
	private final static double SETPOINT = 160.0;
	private final static double TOLERANCE = 0.0;

	private TalonSRX frontLeft, frontRight, backLeft, backRight;

	private double output;
	
	public final Proportional p;

	public final static Aimer INSTANCE;

	static {
		INSTANCE = new Aimer();
	}

	private Aimer() {
		frontLeft = new TalonSRX(3);
		frontRight = new TalonSRX(2);
		backLeft = new TalonSRX(1);
		backRight = new TalonSRX(0);
		p = new Proportional(KP, SETPOINT);
	}

	/**
	 * When prompted, the robot will align the center of its vision from the
	 * camera with the center of the largest contour.
	 * <p>
	 * With processed data passed from the {@link GRIP} class, the robot uses a
	 * proportional control system to align the robot to the largest contour in
	 * the camera's field of view.
	 */
	public void align() {
		output = p.getOutput(GRIP.INSTANCE.getCenter());
		while (Math.abs(p.getError()) > TOLERANCE) {
			output = p.getOutput(GRIP.INSTANCE.getCenter());
			frontLeft.set(-output);
			backLeft.set(-output);
			frontRight.set(output);
			backRight.set(output);
		}
	}
}
