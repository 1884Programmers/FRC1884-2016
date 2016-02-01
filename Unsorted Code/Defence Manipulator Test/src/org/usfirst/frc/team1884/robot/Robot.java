package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	Joystick joystick;
	VictorSP auxilary1;
	VictorSP auxilary2;
//	Encoder encoder;
//	Double distance;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		joystick = new Joystick(0);
		auxilary1 = new VictorSP(0);
		auxilary2 = new VictorSP(1);
//		encoder = new Encoder(0, 1, true, EncodingType.k1X);
		// encoders have 270 click, so when turned fully 360 and say
		// encoder.get() 270 is returned
	}
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

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
	 * 
	 * @return
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

		auxilary1.set(-joystick.getY()/2);
		auxilary2.set(joystick.getRawAxis(3)/2);

		// int counter = encoder.getRaw();
//		distance = encoder.getDistance();
//		double rate = encoder.getRate();
//		String output = "Rate is: " + encoder.getRate();
//		String output2 = "Distance is: " + encoder.getDistance();
		// double asdf = joystick.getRawAxis(3);
//		int count = 0;
//		String output3 = "Please Set Degree Turn" + count;

//		while (joystick.getRawButton(2)) {
//			count += 1;
//			SmartDashboard.putString("DB/String 2", output3);
//		}

//		SmartDashboard.putString("DB/String 0", output);
//		SmartDashboard.putString("DB/String 1", output2);

//		while (encoder.getDistance() <= count) {
//			auxilary1.set(1);
//		}
//		auxilary1.stopMotor();

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
	}
}
