package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Max and Axel's Hanger
 */

public class Hanger implements Subsystem {
	public static final Hanger INSTANCE;

	private static final int HANGING_BUTTON = 8;
	private boolean hasHung = false;
	private static final int MOTOR_CHANNEL = 5;
	private static final int ENCODER_CHANNEL_A = 0;
	private static final int ENCODER_CHANNEL_B = 1;

	private Joystick joystick;
	private CANTalon motor;
	private Encoder encoder;

	static {
		INSTANCE = new Hanger();
	}

	private Hanger() {
		joystick = NEXUS.JOYSTICK;
		motor = new CANTalon(MOTOR_CHANNEL);
		encoder = new Encoder(ENCODER_CHANNEL_A, ENCODER_CHANNEL_B);
	}

	public void teleopInit() {
		// TODO (probably nothing)
	}

	public void teleopPeriodic() {
		if (joystick.getRawButton(HANGING_BUTTON)) {
			hang();
			hasHung = true;
		}
	}

	public void autonomousInit() {
		// I honestly hope that no one is stupid enough to add code to this
		// method
	}

	public void autonomousPeriodic() {
		// I honestly hope that no one is stupid enough to add code to this
		// method
	}

	private void hang() {
		// Debug code
		System.out.println("Hanging");
	}
}
