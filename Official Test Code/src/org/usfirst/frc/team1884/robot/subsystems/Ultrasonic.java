package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class Ultrasonic {
	private final static double KP = 0.02;
	private final static double SETPOINT = 96.0;
	private VictorSP rightSide, leftSide;
	public final Proportional p;
	private RobotDrive drive;
	private AnalogInput ultron;
	private final static int tolerance = 5;
	

	public final static Ultrasonic INSTANCE;

	static {
		INSTANCE = new Ultrasonic();
	}
	
	private Ultrasonic(){
		p = new Proportional(KP, SETPOINT);
		drive = new RobotDrive(leftSide, rightSide);
		ultron = new AnalogInput(0);
	}
	
	private void adjustToEightFeet(){
		double i = p.getOutput(ultron.getValue());
		drive.drive(i, 0);
	}
	
	public void teleopPeriodic(){
		adjustToEightFeet();
	}
}
