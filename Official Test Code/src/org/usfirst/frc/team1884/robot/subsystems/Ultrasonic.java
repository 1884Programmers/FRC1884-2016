package org.usfirst.frc.team1884.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput; 

public class Ultrasonic {
	public final static Ultrasonic INSTANCE;
	
	private AnalogInput ultrasonic;
	
	static {
		INSTANCE = new Ultrasonic();
	}
	
	private Ultrasonic(){
		ultrasonic = new AnalogInput(0);
	}
	
	public double getDistance(){
		return ultrasonic.getValue()/7.2436;
	}
}
