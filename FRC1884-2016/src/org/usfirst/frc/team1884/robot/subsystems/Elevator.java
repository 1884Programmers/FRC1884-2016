package org.usfirst.frc.team1884.robot.subsystems;

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
	private static int FLIP_CHANNEL_EXTEND_1 = 0;
	private static int FLIP_CHANNEL_RETRACT_1 = 1;
	private static int FLIP_CHANNEL_EXTEND_2 = 2;
	private static int FLIP_CHANNEL_RETRACT_2 = 3;

	private static int UP_LIMIT_SWITCH_CHANNEL = 2;
	private static int DOWN_LIMIT_SWITCH_CHANNEL = 3;
	private static boolean release = true;

	private static long timeOfLastRetraction = Long.MAX_VALUE;

	private static int ENCODER_CHANNEL_A = 0, ENCODER_CHANNEL_B = 1;

	private static int ENCODER_MAX = Integer.MAX_VALUE, ENCODER_MIN = Integer.MIN_VALUE;

	private static double NUM_ROTATIONS_RAISE = 2;

	private CANTalon carriage, arm;
	private DoubleSolenoid flip1, flip2;
	private Joystick joystick;

	private DigitalInput downLimitSwitch;
	private DigitalInput upLimitSwitch;

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

		flip1 = new DoubleSolenoid(FLIP_CHANNEL_EXTEND_1, FLIP_CHANNEL_RETRACT_1);
		flip2 = new DoubleSolenoid(FLIP_CHANNEL_EXTEND_2, FLIP_CHANNEL_RETRACT_2);

		upLimitSwitch = new DigitalInput(UP_LIMIT_SWITCH_CHANNEL);
		downLimitSwitch = new DigitalInput(DOWN_LIMIT_SWITCH_CHANNEL);

		flip1 = new DoubleSolenoid(FLIP_CHANNEL_EXTEND_1, FLIP_CHANNEL_RETRACT_1);
		flip2 = new DoubleSolenoid(FLIP_CHANNEL_EXTEND_2, FLIP_CHANNEL_RETRACT_2);

		encoder = new Encoder(ENCODER_CHANNEL_A, ENCODER_CHANNEL_B);
	}

	public void robotInit() {
		encoder.reset(); // starts at bottom before match
		this.flipReset();
	}

	public void teleopInit() {
		// TODO Auto-generated method stub

	}

	public void teleopPeriodic() {
		/*
		 * if (encoder.getDistance() >= ENCODER_MAX) { carriage.set(0.1); } else
		 * if (encoder.getDistance() <= ENCODER_MIN) { carriage.set(-0.1); }
		 * else
		 */ if (Math.abs(joystick.getY()) > 0.1) {
			carriage.set(-joystick.getY());
		} else {
			carriage.set(0);
		}

		if (((joystick.getRawAxis(5) > 0 && !downLimitSwitch.get())
				|| (joystick.getRawAxis(5) < 0 && upLimitSwitch.get())) && Math.abs(joystick.getRawAxis(5)) > 0.2) {
			arm.set(-joystick.getRawAxis(5));
		} else {
			arm.set(0);
		}
		flipTeleop();
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
		if (downLimitSwitch.get()) {
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
		if (upLimitSwitch.get()) {
			arm.set(-0.25);
			return false;
		} else {
			arm.set(0);
		}
		return true;
	}

	public void flipAuto() {
		flip1.set(Value.kReverse);
		flip2.set(Value.kReverse);
		Timer.delay(0.5);
		flip1.set(Value.kForward);
		flip2.set(Value.kForward);
	}

	public void flipTeleop() {
		if (joystick.getRawButton(5)) {
			flipUp();
			release = false;
		} else if (!release) {
			release = true;
			flipDown();
			timeOfLastRetraction = System.currentTimeMillis();
		} else if (System.currentTimeMillis() - timeOfLastRetraction > 1000) {
			flipReset();
			timeOfLastRetraction = Long.MAX_VALUE;
		}

	}

	public void flipUp() {
		flip1.set(Value.kReverse);
		flip2.set(Value.kReverse);
	}

	public void flipDown() {
		flip1.set(Value.kForward);
		flip2.set(Value.kForward);
	}

	public void flipReset() {
		flip1.set(Value.kOff);
		flip2.set(Value.kOff);
	}

	public double getCarriageDistance() {
		return encoder.getDistance();
	}

	public void setArm(double outputValue) {
		arm.set(outputValue);
	}
	
	public void setCarriage(double outputValue) {
		carriage.set(outputValue);
	}
}
