package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Encoder;

/**
 * NEXUS EXchanges Useful Sensors
 */
public class NEXUS {
	public static final Joystick JOYSTICK;
	public static final Encoder LEFT, RIGHT;

	private static int LEFT_CHANNELa = 0;
	private static int LEFT_CHANNELb = 1;
	private static int RIGHT_CHANNELa = 2;
	private static int RIGHT_CHANNELb = 3;

	static {
		JOYSTICK = new Joystick(0);
		LEFT = new Encoder(LEFT_CHANNELa, LEFT_CHANNELb);
		RIGHT = new Encoder(RIGHT_CHANNELa, RIGHT_CHANNELb);
	}
}
