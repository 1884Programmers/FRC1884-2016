package org.usfirst.frc.team1884.robot.nexus;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Encoder;

/**
 * NEXUS EXchanges Useful Sensors
 */
public class NEXUS {
	public static final Joystick JOYSTICK;
	public static final Encoder FRONTLEFT, FRONTRIGHT, BACKLEFT, BACKRIGHT;

	private static int BACKRIGHTCHANNELa;
	private static int BACKRIGHTCHANNELb;
	private static int FRONTRIGHTCHANNELa;
	private static int FRONTRIGHTCHANNELb;
	private static int BACKLEFTCHANNELa;
	private static int BACKLEFTCHANNELb;

	static {
		JOYSTICK = new Joystick(0);
	}
}
