package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * NEXUS EXchanges Useful Sensors
 */
public class NEXUS {
	public static final Joystick DRIVESTICK;
	public static final Joystick OPERATORSTICK;

	static {
		DRIVESTICK = new Joystick(0);
		OPERATORSTICK = new Joystick(1);
	}
}
