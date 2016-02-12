package org.usfirst.frc.team1884.robot;

<<<<<<< HEAD
import org.usfirst.frc.team1884.robot.subsystems.Proportional;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
=======
import org.usfirst.frc.team1884.robot.subsystems.Aimer;
import org.usfirst.frc.team1884.robot.subsystems.GRIP;
import org.usfirst.frc.team1884.robot.subsystems.Proportional;
import org.usfirst.frc.team1884.robot.subsystems.Spike;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
>>>>>>> 1884Programmers/test_code

public class Robot extends IterativeRobot {
<<<<<<< HEAD
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser chooser;
	
	private CANTalon intake, shooter;
	private Proportional p;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		chooser = new SendableChooser();
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);

		//joystick = new Joystick(0);
		intake = new CANTalon(0);
		shooter = new CANTalon(2);
		shooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shooter.setControlMode(0);
		p = new Proportional(0.1/4000.0,-30000.0);
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
		autoSelected = (String) chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
=======

	RobotDrive drive;
	Joystick stick;
	Proportional p;
	AnalogInput ultrasonic;

	public void teleopInit() {
		//drive = new RobotDrive(0, 1, 2, 3);
		stick = new Joystick(0);
		Spike.INSTANCE.turnOn();
		// p = new Proportional((1.0 / 96.0), 96);
		// ultrasonic = new AnalogInput(0);
>>>>>>> 1884Programmers/test_code
	}

	public void teleopPeriodic() {
<<<<<<< HEAD
		double i = p.getOutput(shooter.getEncVelocity());
		intake.set(-1);
		shooter.set(0.8+i);
		System.out.println(shooter.getEncVelocity()+"	"+(0.8+i));
=======
		// double output = p.getOutput(ultrasonic.getValue() / 7.2436);
		// System.out.println(output);
		// drive.drive(output, 0);
		//
		Aimer.INSTANCE.align();
>>>>>>> 1884Programmers/test_code
	}
}
