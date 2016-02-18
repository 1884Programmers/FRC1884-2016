package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

public class Shooter implements Subsystem {

	private Joystick joystick;
	private CANTalon shooter, internalIntake, externalIntake;

	private static final int SHOOTER_CHANNEL = 6;
	private static final int INTERNAL_INTAKE_CHANNEL = 4;
	private static final int EXTERNAL_INTAKE_CHANNEL = 3;

	public static final Shooter INSTANCE;

	static {
		INSTANCE = new Shooter();
	}

	private Shooter() {
		shooter = new CANTalon(SHOOTER_CHANNEL);
		internalIntake = new CANTalon(INTERNAL_INTAKE_CHANNEL);
		externalIntake = new CANTalon(EXTERNAL_INTAKE_CHANNEL);

		shooter.enableBrakeMode(true);
		shooter.setControlMode(0);
		shooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		internalIntake.enableBrakeMode(true);
		internalIntake.setControlMode(0);
		internalIntake.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		externalIntake.enableBrakeMode(true);
		externalIntake.setControlMode(0);
		externalIntake.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		joystick = NEXUS.JOYSTICK;
	}

	public void autonomousInit() {
		// TODO (probably nothing)
	}

	public void autonomousPeriodic() {
		// TODO
	}

	public void teleopInit() {
		// TODO (probably nothing)
	}

	public void teleopPeriodic() {
		if (joystick.getRawButton(1)) {
			shooter.set(1.0);
			internalIntake.set(-1.0);
			externalIntake.set(-1.0);
		} else if (joystick.getRawButton(2)) {
			shooter.set(0);
			internalIntake.set(-1.0);
			externalIntake.set(-1.0);
		}
		else if (joystick.getRawButton(3)) {
			shooter.set(0);
			internalIntake.set(1.0);
			externalIntake.set(0);
		} else {
			shooter.set(0);
			internalIntake.set(0);
			externalIntake.set(0);
		}
	}
}
