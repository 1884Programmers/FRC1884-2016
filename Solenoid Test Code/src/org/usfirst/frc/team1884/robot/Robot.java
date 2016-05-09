
package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	DoubleSolenoid flip;
	DoubleSolenoid gearShiftPush;
	DoubleSolenoid ptoPush;
	Joystick joystick;

	private long timeOfLastExtensionPTO = Long.MAX_VALUE;
	private long timeOfLastExtensionFlip = Long.MAX_VALUE;
	private long timeOfLastExtensionGearShift = Long.MAX_VALUE;

	private long lastPTOButton = 0;
	private long lastFlipButton = 0;
	private long lastGearShiftButton = 0;
	
	boolean ptoExtend = false;
	boolean flipExtend = false;
	boolean gearShiftExtend = false;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		joystick = new Joystick(0);
		flip = new DoubleSolenoid(5, 4);
		gearShiftPush = new DoubleSolenoid(3, 2);
		ptoPush = new DoubleSolenoid(1, 0);
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		if (joystick.getRawButton(2) && System.currentTimeMillis() - lastFlipButton > 200) {
			flip.set(flipExtend ? Value.kForward : Value.kReverse);
			flipExtend = !flipExtend;
			lastFlipButton = System.currentTimeMillis();
			timeOfLastExtensionFlip = System.currentTimeMillis();
		}
		if (joystick.getRawButton(3) && System.currentTimeMillis() - lastPTOButton > 200) {
			ptoPush.set(ptoExtend ? Value.kForward : Value.kReverse);
			ptoExtend = !ptoExtend;
			lastPTOButton = System.currentTimeMillis();
			timeOfLastExtensionPTO = System.currentTimeMillis();
		}
		if (joystick.getRawButton(4) && System.currentTimeMillis() - lastGearShiftButton > 200) {
			gearShiftPush.set(gearShiftExtend ? Value.kForward : Value.kReverse);
			gearShiftExtend = !gearShiftExtend;
			lastGearShiftButton = System.currentTimeMillis();
			timeOfLastExtensionGearShift = System.currentTimeMillis();
		}
		
		if(System.currentTimeMillis() - timeOfLastExtensionFlip > 1000) {
			flip.set(Value.kOff);
		}
		if(System.currentTimeMillis() - timeOfLastExtensionPTO > 1000) {
			ptoPush.set(Value.kOff);
		}
		if(System.currentTimeMillis() - timeOfLastExtensionGearShift > 1000) {
			gearShiftPush.set(Value.kOff);
		}
	}
}
