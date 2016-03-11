package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.autonomous.AutonomousHandler;
import org.usfirst.frc.team1884.robot.subsystems.Aimer;
import org.usfirst.frc.team1884.robot.subsystems.Elevator;
import org.usfirst.frc.team1884.robot.subsystems.Shooter;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	public static OI oi;

	CameraServer server;
	Joystick opJoystick;

	JoystickButton opButton1;
	JoystickButton opButton2;
	
	Compressor comp;

	public void robotInit() {
		oi = new OI();
		opJoystick = NEXUS.OPERATORSTICK;

		comp = new Compressor(0);
		
		// server = CameraServer.getInstance();
		// server.setQuality(50);
		// server.startAutomaticCapture("cam0");
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
		comp.start();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		WestCoastGearbox.INSTANCE.teleopPeriodic();
		Elevator.INSTANCE.teleopPeriodic();
		Aimer.INSTANCE.teleopPeriodic();
		Shooter.INSTANCE.teleopPeriodic();
		
//		 if(opJoystick.getPOV() == 0) {
//			Shooter.INSTANCE.getExternalIntake().set(-1);
//		} else if(opJoystick.getPOV() == 180) {
//			Shooter.INSTANCE.getExternalIntake().set(1);
//		} else {
//			Shooter.INSTANCE.getExternalIntake().set(0);
//		}
//		
//		if(opJoystick.getPOV() == 90) {
//			Shooter.INSTANCE.getInternalIntake().set(1);
//		} else if(opJoystick.getPOV() == 270) {
//			Shooter.INSTANCE.getInternalIntake().set(-1);
//		} else {
//			Shooter.INSTANCE.getInternalIntake().set(0);
//		}
//		
//		if(opJoystick.getRawButton(3)) {
//			Shooter.INSTANCE.getShooter().set(1);
//		} else {
//			Shooter.INSTANCE.getShooter().set(0);
//		} 
	}
}
