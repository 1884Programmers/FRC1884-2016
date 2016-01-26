package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;

/**
 * Helps the robot aim towards the goal using Vision Tracking.
 * 
 * @author Kaito Arai
 * @version 1
 * @since 21/1/2016
 *
 */

public class Aimer {
	private final static int KP = 1;
	private final static int SETPOINT = 500;
	private final static int TARGET_POWER = 0;
	private final static int TOLERANCE = 0;

	private VictorSP frontLeft, frontRight, backLeft, backRight;

	private int error;
	private int leftPower;
	private int output;
	private int processValue;
	private int rightPower;

	public final static Aimer INSTANCE;

	static {
		INSTANCE = new Aimer();
	}

	private Aimer() {
		frontLeft = new VictorSP(3);
		frontRight = new VictorSP(2);
		backLeft = new VictorSP(1);
		backRight = new VictorSP(0);
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
		while (error > TOLERANCE || -TOLERANCE < error) {
			error = processValue - SETPOINT;
			output = error * KP;
			leftPower = TARGET_POWER - output;
			rightPower = TARGET_POWER + output;
			frontLeft.set(leftPower);
			backLeft.set(leftPower);
			frontRight.set(rightPower);
			backRight.set(rightPower);
		}
	}
}
