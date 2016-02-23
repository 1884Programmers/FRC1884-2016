package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.autonomous.AutonomousHandler;
<<<<<<< HEAD
<<<<<<< HEAD
import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperSequence;
import org.usfirst.frc.team1884.robot.commands.shooter.ShootAllOn;
=======
>>>>>>> 1884Programmers/master
=======
>>>>>>> 1884Programmers/master
import org.usfirst.frc.team1884.robot.subsystems.Aimer;
import org.usfirst.frc.team1884.robot.subsystems.Elevator;
import org.usfirst.frc.team1884.robot.subsystems.Shooter;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
<<<<<<< HEAD
	DigitalInput limitSwitch;
	Encoder shooterEncoder = new Encoder(0, 1);
	Encoder elevatorEncoder = new Encoder(2, 3);
=======

	public static OI oi;
<<<<<<< HEAD
<<<<<<< HEAD
	
>>>>>>> 1884Programmers/master
=======
=======

	CameraServer server;
>>>>>>> 1884Programmers/master

>>>>>>> 1884Programmers/master
	CameraServer server;
	Joystick opJoystick;

	JoystickButton opButton1;
	JoystickButton opButton2;

	public void robotInit() {
		oi = new OI();
		opJoystick = NEXUS.OPERATORSTICK;
<<<<<<< HEAD
<<<<<<< HEAD
		
=======

>>>>>>> 1884Programmers/master
=======

>>>>>>> 1884Programmers/master
		server = CameraServer.getInstance();
		server.setQuality(50);
		server.startAutomaticCapture("cam0");
	}

	/**
	 * This function is called once at the beginning of autonomous
	 */
	public void autonomousInit() {
		AutonomousHandler.INSTANCE.autonomousInit();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called once at the beginning of operator control
	 */
	public void teleopInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		WestCoastGearbox.INSTANCE.teleopPeriodic();
		Elevator.INSTANCE.teleopPeriodic();
<<<<<<< HEAD
		Shooter.INSTANCE.teleopPeriodic();
		System.out.println(shooterEncoder.getRate());
		System.out.println(elevatorEncoder.getRate());
		// Aimer.INSTANCE.teleopPeriodic();

=======
		Aimer.INSTANCE.teleopPeriodic();
		Shooter.INSTANCE.teleopPeriodic();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1884Programmers/master
		if (opJoystick.getRawButton(2)) {
			Shooter.INSTANCE.shootActually();
		} else {
			Shooter.INSTANCE.resetShooter();
		}
=======
>>>>>>> 1884Programmers/master
=======
>>>>>>> 1884Programmers/master
	}
}
