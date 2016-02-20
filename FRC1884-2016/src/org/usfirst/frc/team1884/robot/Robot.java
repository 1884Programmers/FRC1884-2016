package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.commands.AutonomousHandler;
import org.usfirst.frc.team1884.robot.subsystems.Aimer;
import org.usfirst.frc.team1884.robot.subsystems.Elevator;
import org.usfirst.frc.team1884.robot.subsystems.Shooter;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	DigitalInput limitSwitch;
	Encoder shooterEncoder = new Encoder(0, 1);
	Encoder elevatorEncoder = new Encoder(2, 3);

	public void robotInit() {
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
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		WestCoastGearbox.INSTANCE.teleopPeriodic();
		Elevator.INSTANCE.teleopPeriodic();
		Shooter.INSTANCE.teleopPeriodic();
<<<<<<< HEAD
<<<<<<< HEAD
		System.out.println(shooterEncoder.getRate());
		System.out.println(elevatorEncoder.getRate());
//		Aimer.INSTANCE.teleopPeriodic();
=======
		Aimer.INSTANCE.teleopPeriodic();
>>>>>>> 1884Programmers/master
=======
		Aimer.INSTANCE.teleopPeriodic();
>>>>>>> 1884Programmers/master
	}
}
