package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;
import org.usfirst.frc.team1884.robot.commands.IntakeTeleopPeriodic;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	private static final int SHOOTER_CHANNEL = 6;
	private static final int INTERNAL_INTAKE_CHANNEL = 3;
	private static final int EXTERNAL_INTAKE_CHANNEL = 4;

	private static final double kp = 1.0;
	private static final int setVelocity = 29000;

	public static final Intake INSTANCE;

	private Joystick joystick;

	static {
		INSTANCE = new Intake();
	}

	private CANTalon internalIntake, externalIntake;
	private Proportional p;

	private Intake() {
		internalIntake = new CANTalon(INTERNAL_INTAKE_CHANNEL);
		externalIntake = new CANTalon(EXTERNAL_INTAKE_CHANNEL);

		getInternalIntake().enableBrakeMode(true);
		getInternalIntake().setControlMode(0);

		getExternalIntake().enableBrakeMode(true);
		getExternalIntake().setControlMode(0);

		p = new Proportional(kp, setVelocity);
		joystick = NEXUS.OPERATORSTICK;
	}

	public void resetIntake() {
		internalIntake.set(0);
		externalIntake.set(0);
	}

	public void shootLowGoal() {
		internalIntake.set(-1);
		externalIntake.set(1);
	}

	public void releaseBall() {
		internalIntake.set(-0.25);
		externalIntake.set(0.25);
	}

	public void holdBall() {
		internalIntake.set(0.5);
		externalIntake.set(-0.5);
	}
	
	public void pickUp() {
		externalIntake.set(-1);
	}
	
	public void stopInflux() {
		externalIntake.set(1);
	}

	/**
	 *
	 *
	 */
	public void teleopPeriodic() {
		if (joystick.getRawAxis(2) > 0.1) {
			shootLowGoal();
		} else if (joystick.getRawButton(1)) {
			releaseBall();
		} else if (joystick.getRawButton(2)) {
			holdBall();
		} else if(joystick.getRawButton(3)) {
			this.shootLowGoal();
		} else if(joystick.getRawButton(5)) {
			this.stopInflux();
		} else {
			resetIntake();
		}
	}

	public CANTalon getInternalIntake() {
		return internalIntake;
	}

	public CANTalon getExternalIntake() {
		return externalIntake;
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new IntakeTeleopPeriodic());
	}
}
