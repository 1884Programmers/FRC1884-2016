package org.usfirst.frc.team1884.robot.deprecated;

import org.usfirst.frc.team1884.robot.NEXUS;
import org.usfirst.frc.team1884.robot.commands.IntakeTeleopPeriodic;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

@Deprecated
public class Shooter extends Subsystem {
	private static final int SHOOTER_CHANNEL = 6;
	private static final int INTERNAL_INTAKE_CHANNEL = 3;
	private static final int EXTERNAL_INTAKE_CHANNEL = 4;

	private static final double kp = 1.0;
	private static final int setVelocity = 29000;

	public static final Shooter INSTANCE;

	private Joystick joystick;

	static {
		INSTANCE = new Shooter();
	}

	private CANTalon shooter, internalIntake, externalIntake;
	private Proportional p;

	private Shooter() {
		shooter = new CANTalon(SHOOTER_CHANNEL);
		internalIntake = new CANTalon(INTERNAL_INTAKE_CHANNEL);
		externalIntake = new CANTalon(EXTERNAL_INTAKE_CHANNEL);

		shooter.enableBrakeMode(true);
		shooter.setControlMode(0);
		shooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		getInternalIntake().enableBrakeMode(true);
		getInternalIntake().setControlMode(0);

		getExternalIntake().enableBrakeMode(true);
		getExternalIntake().setControlMode(0);

		p = new Proportional(kp, setVelocity);
		joystick = NEXUS.OPERATORSTICK;
	}

	public void shootPeriodicIdeally() {
		shooter.set(p.getOutput(shooter.getEncVelocity()));
		if (shooter.getEncVelocity() > setVelocity - 1000) {
			getInternalIntake().set(1);
		}
	}

	public void shootAutoIdeally() {
		shooter.set(p.getOutput(shooter.getEncVelocity()));
		while (shooter.getEncVelocity() < setVelocity - 1000) {
		}
		getInternalIntake().set(1);
		Timer.delay(2);
		shooter.set(0);
		getInternalIntake().set(0);
	}

	public void shootAutoActually() {
		shootActually();

		// safety
	}

	public void shootActually() {
		shooter.set(1);
		internalIntake.set(1);
	}

	public void intake() {
		// TODO when the robot gets turned over to us
	}

	public void resetShooter() {
		shooter.set(0);
		internalIntake.set(0);
		externalIntake.set(0);
	}

	public void shootLowGoal() {
		shooter.set(-1);
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
		if (joystick.getRawAxis(3) > 0.1) {
			pickUp();
			shootActually();
		} else if (joystick.getRawAxis(2) > 0.1) {
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
			resetShooter();
		}
	}

	public CANTalon getShooter() {
		return shooter;
	}

	public CANTalon getInternalIntake() {
		return internalIntake;
	}

	public CANTalon getExternalIntake() {
		return externalIntake;
	}

	@Override
	protected void initDefaultCommand() {
	}
}
