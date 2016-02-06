package org.usfirst.frc.team1884.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltrasonicSensor {
	public static final int ultronPortNumber = 0;

	public static final UltrasonicSensor INSTANCE;
	private AnalogInput ultron;

	static {
		INSTANCE = new UltrasonicSensor();
	}

	private UltrasonicSensor() {
		ultron = new AnalogInput(ultronPortNumber);
	}

	public double getDistanceInches() {
		return (double) ultron.getValue() / 7.2436;
	}
}
