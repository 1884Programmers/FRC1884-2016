package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
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
	private static int UPLIMITSWITCH_CHANNEL = 4;
	private static int DOWNLIMITSWITCH_CHANNEL = 5;
	private static double NUM_ROTATIONS_RAISE = 2;

	private CANTalon carriage, arm;
	private DoubleSolenoid flip;
	private Joystick joystick;
	private DigitalInput upLimitSwitch;
	private DigitalInput downLimitSwitch;

	static {
		INSTANCE = new Elevator();
	}

	public Elevator() {
		carriage = new CANTalon(CARRIAGE_CHANNEL);
		carriage.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		arm = new CANTalon(ARM_CHANNEL);
		flip = new DoubleSolenoid(FLIP_CHANNEL_EXTEND, FLIP_CHANNEL_RETRACT);
		upLimitSwitch = new DigitalInput(UPLIMITSWITCH_CHANNEL);
		downLimitSwitch = new DigitalInput(DOWNLIMITSWITCH_CHANNEL);
		joystick = NEXUS.OPERATORSTICK;
	}

	public void teleopInit() {
		// TODO Auto-generated method stub

	}

	public void teleopPeriodic() {
		carriage.set(-joystick.getY());
		if(joystick.getPOV(0) == 0 && upLimitSwitch.get()) {
			arm.set(0.25);
		} else if(joystick.getPOV(0) == 180 && downLimitSwitch.get()) {
			arm.set(-0.25);
		} else {
			arm.set(0);
		}
	}
	
	/**
	 * Needs to be called in a loop
	 * @return Whether or not the carriage has finished raising
	 */
	public boolean raiseCarriageAuto() {
		if(Math.abs(carriage.getEncPosition()) < NUM_ROTATIONS_RAISE) {
			carriage.set(1);
			return false;
		} else {
			carriage.set(0);
		}
		return true;
	}
	
	/**
	 * Needs to be called in a loop
	 * @return Whether or not the carriage has finished lowering
	 */
	public boolean lowerCarriageAuto() {
		if(Math.abs(carriage.getEncPosition()) < NUM_ROTATIONS_RAISE) {
			arm.set(-1);
			return false;
		} else {
			arm.set(0);
		}
		return true;
	}
	
	/**
	 * Needs to be called in a loop
	 * @return Whether or not the arm has finished raising
	 */
	public boolean raiseArmAuto() {
		if(upLimitSwitch.get()) {
			arm.set(0.25);
			return false;
		} else {
			arm.set(0);
		}
		return true;
	}
	
	/**
	 * Needs to be called in a loop
	 * @return Whether or not the arm has finished lowering
	 */
	public boolean lowerArmAuto() {
		if(downLimitSwitch.get()) {
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
