package org.usfirst.frc.team1884.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltrasonicSensor {
	public static final UltrasonicSensor INSTANCE;

	private AnalogInput ultrasonic;
	private static final int ULTRASONIC_CHANNEL = 0;

	static {
		INSTANCE = new UltrasonicSensor();
	}

	private UltrasonicSensor() {
		ultrasonic = new AnalogInput(ULTRASONIC_CHANNEL);
	}

	public double getDistanceInches() {
		return (double) ultrasonic.getValue() / 7.2436;
	}
}
