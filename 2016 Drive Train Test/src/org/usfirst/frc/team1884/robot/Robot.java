
package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Joystick joystick;

	VictorSP frontLeft, frontRight, backLeft, backRight, aux1, aux2;

	RobotDrive drive;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		joystick = new Joystick(0);
		frontLeft = new VictorSP(3);
		frontRight = new VictorSP(2);
		backLeft = new VictorSP(1);
		backRight = new VictorSP(0);
		aux2 = new VictorSP(4);
		aux1 = new VictorSP(5);
		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		//drive.setInvertedMotor(edu.wpi.first.wpilibj.RobotDrive.MotorType.kFrontRight, true);
		//drive.setInvertedMotor(edu.wpi.first.wpilibj.RobotDrive.MotorType.kFrontLeft, true);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		drive.arcadeDrive(joystick);
		
		

		//double y = joystick.getRawAxis(1);
		//double ly = joystick.getRawAxis(4);
		
		//frontLeft.set(-y);
		//frontRight.set(ly);
		//backLeft.set(-y);
		//backRight.set(ly);
		
		//if (y_magnitude < 0 || y_magnitude > 0) {
			//frontLeft.set(-y_magnitude / 10);
			//backLeft.set(y_magnitude / 10);
			//frontRight.set(y_magnitude / 10);
			//backRight.set(-y_magnitude / 10);
		//} else if (x_magnitude < 0 || x_magnitude > 0) {
			//frontLeft.set(-x_magnitude / 10);
			//backLeft.set(x_magnitude / 10);
			//frontRight.set(x_magnitude / 10);
			//backRight.set(-x_magnitude / 10);
		//}

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}
