package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;;

public class Elevator {
	public static final Elevator INSTANCE;

	private static int CARRIAGE_CHANNEL = 0;
	private static int ARM_CHANNEL = 2;

	/*
	 * TODO Need to be tuned to fit the robot
	 */
	private static int FLIP_CHANNEL_EXTEND = 0;
	private static int FLIP_CHANNEL_RETRACT = 1;
	private static int UP_LIMIT_SWITCH_CHANNEL = 4;
	private static int DOWN_LIMIT_SWITCH_CHANNEL = 5;

	private static int ENCODER_CHANNEL_A = 0, ENCODER_CHANNEL_B = 1;

	private static int ENCODER_MAX, ENCODER_MIN;

	private static double NUM_ROTATIONS_RAISE = 2;

	private CANTalon carriage, arm;
	private DoubleSolenoid flip;
	private Joystick joystick;

	private DigitalInput upLimitSwitch;
	private DigitalInput downLimitSwitch;

	private Encoder encoder;

	static {
		INSTANCE = new Elevator();
	}

	public Elevator() {
		carriage = new CANTalon(CARRIAGE_CHANNEL);
		carriage.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		carriage.enableBrakeMode(true);
		
		arm = new CANTalon(ARM_CHANNEL);
		arm.enableBrakeMode(true);
		
		flip = new DoubleSolenoid(FLIP_CHANNEL_EXTEND, FLIP_CHANNEL_RETRACT);
		
		upLimitSwitch = new DigitalInput(UP_LIMIT_SWITCH_CHANNEL);
		downLimitSwitch = new DigitalInput(DOWN_LIMIT_SWITCH_CHANNEL);
		
		joystick = NEXUS.OPERATORSTICK;

		encoder = new Encoder(ENCODER_CHANNEL_A, ENCODER_CHANNEL_B);
	}

	public void robotInit() {
		encoder.reset(); // starts at top before match
	}

	public void teleopInit() {
		// TODO Auto-generated method stub

	}

	public void teleopPeriodic() {
		if (encoder.getDistance() == ENCODER_MAX || encoder.getDistance() == ENCODER_MIN) {
			carriage.set(0);
		} else {
			carriage.set(-joystick.getY());
		}
		if (joystick.getPOV(0) == 0 && upLimitSwitch.get()) {
			arm.set(0.25);
		} else if (joystick.getPOV(0) == 180 && downLimitSwitch.get()) {
			arm.set(-0.25);
		} else {
			arm.set(0);
		}
	}

	/**
	 * Needs to be called in a loop
	 * 
	 * @return Whether or not the carriage has finished raising
	 */
	public boolean raiseCarriage() {
		if (Math.abs(carriage.getEncPosition()) < NUM_ROTATIONS_RAISE) {
			carriage.set(1);
			return false;
		} else {
			carriage.set(0);
		}
		return true;
	}

	/**
	 * Needs to be called in a loop
	 * 
	 * @return Whether or not the carriage has finished lowering
	 */
	public boolean lowerCarriage() {
		if (Math.abs(carriage.getEncPosition()) < NUM_ROTATIONS_RAISE) {
			carriage.set(-1);
			return false;
		} else {
			carriage.set(0);
		}
		return true;
	}

	/**
	 * Needs to be called in a loop
	 * 
	 * @return Whether or not the arm has finished raising
	 */
	public boolean raiseArmAuto() {
		if (upLimitSwitch.get()) {
			arm.set(0.25);
			return false;
		} else {
			arm.set(0);
		}
		return true;
	}

	/**
	 * Needs to be called in a loop
	 * 
	 * @return Whether or not the arm has finished lowering
	 */
	public boolean lowerArmAuto() {
		if (downLimitSwitch.get()) {
			arm.set(-0.25);
			return false;
		} else {
			arm.set(0);
		}
		return true;
	}

	public void flipAuto() {
		flip.set(Value.kReverse);
		Timer.delay(0.5);
		flip.set(Value.kForward);
	}

	public void flipUp() {
		flip.set(Value.kReverse);
	}

	public void flipDown() {
		flip.set(Value.kForward);
	}

	public void flipReset() {
		flip.set(Value.kOff);
	}
}
