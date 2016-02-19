package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Joystick;

public class Shooter {
	private static final int SHOOTER_CHANNEL = 6;
	private static final int INTERNAL_INTAKE_CHANNEL = 4;
	private static final int EXTERNAL_INTAKE_CHANNEL = 3;
	
	private static final double kp = 1.0;

	public static final Shooter INSTANCE;

	static {
		INSTANCE = new Shooter();
	}

	@SuppressWarnings("unused")
	private Joystick joystick;
	private CANTalon shooter, internalIntake, externalIntake;
	private Proportional p;

	private Shooter() {
		shooter = new CANTalon(SHOOTER_CHANNEL);
		internalIntake = new CANTalon(INTERNAL_INTAKE_CHANNEL);
		externalIntake = new CANTalon(EXTERNAL_INTAKE_CHANNEL);

		shooter.enableBrakeMode(true);
		shooter.setControlMode(0);
		shooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		internalIntake.enableBrakeMode(true);
		internalIntake.setControlMode(0);

		externalIntake.enableBrakeMode(true);
		externalIntake.setControlMode(0);

		joystick = NEXUS.OPERATORSTICK;
		
		p = new Proportional(kp, 29000);
	}
	
	public void shoot() {
		internalIntake.set(1);
		shooter.set(p.getOutput(shooter.getEncVelocity()));
	}
	
	public void intake() {
		externalIntake.set(1);
	}

	public void teleopInit() {
		// TODO (probably nothing)
	}

	/**
	 * 
	 */
	public void teleopPeriodic() {
		if(joystick.getRawButton(6)) {
			shoot();
		} else if(joystick.getRawButton(7)){
			intake();
		} else {
			shooter.set(0);
			internalIntake.set(0);
		}
	}
}
