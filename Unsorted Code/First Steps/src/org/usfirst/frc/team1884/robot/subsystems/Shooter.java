package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid; 
import edu.wpi.first.wpilibj.Talon;

public class Shooter {

	public final static Shooter instance;
	
	
	/* static initializer block, run once in entire life cycle, used so only one instance of Shooter can be made. */
	static {
		instance = new Shooter();
	}
	
	private Talon wheel1, wheel2;
	
	private DoubleSolenoid kicker;
	
	private long timeOfLastExtension;
	
	private static final long kExtensionTime = 450;
	
	private Shooter() {
		wheel1 = new Talon(4);
		wheel2 = new Talon(5);
		
		kicker = new DoubleSolenoid(0, 1);
		
		timeOfLastExtension = Long.MAX_VALUE;
	}
	
	public void startWheels(){
		wheel1.set(1.0);
		wheel2.set(1.0);
	}
	
	public void stopWheels(){
		wheel1.set(0.0);
		wheel2.set(0.0);
	}
	
	public void kick(){
		kicker.set(DoubleSolenoid.Value.kReverse);
		timeOfLastExtension = System.currentTimeMillis();
	}
	
	public void reload(){
		kicker.set(DoubleSolenoid.Value.kForward);
		timeOfLastExtension = System.currentTimeMillis();
	}
	
	public void update(){
		if (System.currentTimeMillis() - timeOfLastExtension > kExtensionTime) {
			kicker.set(DoubleSolenoid.Value.kOff);
		}
	}
}
