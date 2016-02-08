package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.nexus.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Joystick;

public class Shooter implements Subsystem {
	private static final int SHOOTER_CHANNEL = 0;
	private static final int INTERNAL_INTAKE_CHANNEL = 1;
	private static final int EXTERNAL_INTAKE_CHANNEL = 2;

	public static final Shooter INSTANCE;

	static {
		INSTANCE = new Shooter();
	}

	@SuppressWarnings("unused")
	private Joystick joystick;
	private CANTalon shooter, internalIntake, externalIntake;

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
		// TODO
	}
}
