package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.commands.AutonomousHandler;
import org.usfirst.frc.team1884.robot.commands.CommandFlipper;
import org.usfirst.frc.team1884.robot.subsystems.Aimer;
import org.usfirst.frc.team1884.robot.subsystems.Elevator;
import org.usfirst.frc.team1884.robot.subsystems.Shooter;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Robot extends IterativeRobot {

	CameraServer server;

	Joystick opJoystick;
	Joystick driveJoystick;

	JoystickButton opButton1;
	JoystickButton opButton2;

	public void robotInit() {
		opJoystick = NEXUS.OPERATORSTICK;
		driveJoystick = NEXUS.DRIVESTICK;
		
		opButton1 = new JoystickButton(NEXUS.OPERATORSTICK, 1);
		opButton2 = new JoystickButton(NEXUS.OPERATORSTICK, 2);
		
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

	}

	/**
	 * This function is called once at the beginning of operator control
	 */
	public void teleopInit() {
		opButton1.whenPressed(new CommandFlipper());
		// opButton2.whileHeld(new CommandShoot());
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		WestCoastGearbox.INSTANCE.teleopPeriodic();
		Elevator.INSTANCE.teleopPeriodic();
		Aimer.INSTANCE.teleopPeriodic();
		if (opJoystick.getRawButton(2)) {
			Shooter.INSTANCE.shootActually();
		} else {
			Shooter.INSTANCE.resetShooter();
		}
	}
}
