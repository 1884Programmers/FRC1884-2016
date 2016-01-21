package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;

public class Aimer {
	private final int KP = 1;
	private final int SETPOINT = 500;
	private final int TARGET_POWER = 0;
	private final int TOLERANCE = 0;

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
