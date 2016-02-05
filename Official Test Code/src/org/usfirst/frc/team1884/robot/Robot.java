package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.subsystems.GRIP; 
import org.usfirst.frc.team1884.robot.subsystems.Proportional;
import org.usfirst.frc.team1884.robot.subsystems.Spike;
import org.usfirst.frc.team1884.robot.subsystems.Ultrasonic;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	private CANTalon intake, shooter;
	private Proportional p;
	private Joystick joystick;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		joystick = new Joystick(0);
		intake = new CANTalon(5);
		shooter = new CANTalon(4);
		shooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooter.setControlMode(0);
		p = new Proportional(0.1 / 4000.0, -30000.0);
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
		if (joystick.getRawButton(1))
			Spike.INSTANCE.turnOn();
		if (joystick.getRawButton(2))
			Spike.INSTANCE.turnOff();
		System.out.println(GRIP.INSTANCE.getCenter());
		double i = p.getOutput(shooter.getEncVelocity());
		intake.set(-1);
		shooter.set(0.8 + i);
		// System.out.println(shooter.getEncVelocity()+" "+(0.8+i));
		Ultrasonic.INSTANCE.teleopPeriodic();
		Timer.delay(0.005);

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}
