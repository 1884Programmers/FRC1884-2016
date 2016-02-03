package org.usfirst.frc.team1884.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP; 

public class Ultrasonic {
	private final static double KP = 1.0;
	private final static double SETPOINT = 96.0;
	public final static Ultrasonic INSTANCE;
	public final Proportional p;
	private AnalogInput ultrasonic;
	private RobotDrive drive;
	private VictorSP rightSide, leftSide;

	static {
		INSTANCE = new Ultrasonic();
	}
	
	private Ultrasonic(){
		ultrasonic = new AnalogInput(0);
		p = new Proportional(KP, SETPOINT);
		leftSide = new VictorSP(0);
    	rightSide = new VictorSP(1);
		drive = new RobotDrive(leftSide, rightSide);

	}
	
	public double getDistance(){
		return ultrasonic.getValue()/7.2436;
	}
	
	public void autonomousPeriodic(){
		drive.drive(0.5, 0);
		
	}
}

