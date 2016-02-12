package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;

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
	private final static double TOLERANCE = 1.0;

	private VictorSP frontLeft, frontRight, backLeft, backRight;

	private double output;

	public final Proportional p;

	public final static Aimer INSTANCE;

	static {
		INSTANCE = new Aimer();
	}

	private Aimer() {
		frontLeft = new VictorSP(0);
		frontRight = new VictorSP(2);
		backLeft = new VictorSP(1);
		backRight = new VictorSP(3);
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
		output = Integer.MAX_VALUE;
		while (Math.abs(output) > TOLERANCE) {
			double center = GRIP.INSTANCE.getCenter();
			if (center == -1.0) {

			} else {
				output = p.getOutput(GRIP.INSTANCE.getCenter());
				frontLeft.set(output);
				backLeft.set(output);
				frontRight.set(output);
				backRight.set(output);
			}
		}
	}
}
