package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.subsystems.Proportional;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {

	RobotDrive drive;
	Joystick stick;
	Proportional p;
	AnalogInput ultrasonic;

	public void teleopInit() {
		drive = new RobotDrive(0, 1, 2, 3);
		stick = new Joystick(0);
		p = new Proportional((1.0 / 96.0), 96);
		ultrasonic = new AnalogInput(0);
	}

	public void teleopPeriodic() {
		double output = p.getOutput(ultrasonic.getValue() / 7.2436);
		System.out.println(output);
		drive.drive(output, 0);
	}
}
