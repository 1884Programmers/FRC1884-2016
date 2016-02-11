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
		leftSide = new VictorSP(3);
		rightSide = new VictorSP(2);
		p = new Proportional(KP, SETPOINT);
		drive = new RobotDrive(leftSide, rightSide);
		ultron = new AnalogInput(0);
	}
	
	public void adjustToEightFeet(){
		double i = p.getOutput(ultron.getValue()/7.2436);
		System.out.println(ultron.getValue()/7.2436);
		drive.drive(i, 0);
	}
}
