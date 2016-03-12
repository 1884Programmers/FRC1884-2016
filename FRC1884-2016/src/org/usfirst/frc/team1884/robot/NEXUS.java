package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;

/**
 * NEXUS EXchanges Useful Sensors
 */
public class NEXUS {
	public static final Joystick DRIVESTICK;
	public static final Joystick OPERATORSTICK;
	public static final DriverStation DS;

	static {
		DRIVESTICK = new Joystick(0);
		OPERATORSTICK = new Joystick(1);
		DS = DriverStation.getInstance();
	}
}
