package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class WestCoastGearbox implements Subsystem {
	private static final int LEFT_CHANNEL = 0;
	private static final int RIGHT_CHANNEL = 1;

	private DoubleSolenoid outputPush, ptoPush;
	private Joystick joystick;
	private RobotDrive drive;
	private VictorSP leftSide, rightSide;

	private long timeOfLastExtensionoutput = Long.MAX_VALUE;
	private long timeOfLastExtensionpTO = Long.MAX_VALUE;

	private long lastoutputButtonExtend = 0;
	private long lastoutputButtonRetract = 0;
	private long lastpTOButtonExtend = 0;
	private long lastpTOButtonRetract = 0;

	public static WestCoastGearbox INSTANCE;

	static {
		INSTANCE = new WestCoastGearbox();
	}

	private WestCoastGearbox() {
		outputPush = new DoubleSolenoid(0, 1);
		ptoPush = new DoubleSolenoid(2, 3);

		joystick = NEXUS.JOYSTICK;

		drive = new RobotDrive(leftSide, rightSide);

		leftSide = new VictorSP(LEFT_CHANNEL);
		rightSide = new VictorSP(RIGHT_CHANNEL);
	}

	public void autonomousInit() {
		//TODO (probably nothing)
	}

	public void autonomousPeriodic() {
		autonomousDrive();
	}

	public void teleopInit() {
		//TODO (probably nothing)
	}

	public void teleopPeriodic() {
		joystickDrive();
		PTOShift();
	}

	private void joystickDrive() {
		drive.arcadeDrive(joystick);
	}

	private void autonomousDrive() {
		// TODO
	}

	private void PTOShift() {
		if (joystick.getRawButton(1) && outputPush.get() == DoubleSolenoid.Value.kOff
				&& System.currentTimeMillis() - lastoutputButtonExtend > 200) {
			outputPush.set(DoubleSolenoid.Value.kForward);
			lastoutputButtonExtend = System.currentTimeMillis();
			timeOfLastExtensionoutput = System.currentTimeMillis();
		}
		if (joystick.getRawButton(2) && ptoPush.get() == DoubleSolenoid.Value.kOff
				&& System.currentTimeMillis() - lastpTOButtonExtend > 200) {
			ptoPush.set(DoubleSolenoid.Value.kForward);
			lastpTOButtonExtend = System.currentTimeMillis();
			timeOfLastExtensionpTO = System.currentTimeMillis();
		}
		if (joystick.getRawButton(3) && outputPush.get() == DoubleSolenoid.Value.kOff
				&& System.currentTimeMillis() - lastoutputButtonRetract > 200) {
			outputPush.set(DoubleSolenoid.Value.kReverse);
			lastoutputButtonRetract = System.currentTimeMillis();
			timeOfLastExtensionoutput = System.currentTimeMillis();
		}
		if (joystick.getRawButton(4) && ptoPush.get() == DoubleSolenoid.Value.kOff
				&& System.currentTimeMillis() - lastpTOButtonRetract > 200) {
			ptoPush.set(DoubleSolenoid.Value.kReverse);
			lastpTOButtonRetract = System.currentTimeMillis();
			timeOfLastExtensionpTO = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - timeOfLastExtensionoutput > 1000) {
			outputPush.set(DoubleSolenoid.Value.kOff);
			timeOfLastExtensionoutput = Long.MAX_VALUE;
		}
		if (System.currentTimeMillis() - timeOfLastExtensionpTO > 1000) {
			ptoPush.set(DoubleSolenoid.Value.kOff);
			timeOfLastExtensionpTO = Long.MAX_VALUE;
		}
	}
}
