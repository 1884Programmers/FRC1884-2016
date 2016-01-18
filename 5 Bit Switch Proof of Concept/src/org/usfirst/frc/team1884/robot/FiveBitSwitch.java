package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class FiveBitSwitch {
	
	public static FiveBitSwitch fiveBitSwitch = new FiveBitSwitch();
	
	byte fieldObstacleID;
	byte fieldPositionID;
	
	FieldObstacle fieldObstacle;
	FieldPosition fieldPosition;
	
	DigitalInput port0, port1, port2, port3, port4;
	
	private FiveBitSwitch() {
		port0 = new DigitalInput(0);
		port1 = new DigitalInput(1);
		port2 = new DigitalInput(2);
		port3 = new DigitalInput(3);
		port4 = new DigitalInput(4);
		
		fieldPositionID = (byte) (port3.get() ? 1 : 0);
		fieldPositionID *= 2;
		fieldPositionID = (byte) (port4.get() ? 1 : 0);
		
		
		
		fieldObstacleID = (byte) (port0.get() ? 1 : 0);
		fieldObstacleID *= 2;
		fieldObstacleID = (byte) (port1.get() ? 1 : 0);
		fieldObstacleID *= 2;
		fieldObstacleID = (byte) (port2.get() ? 1 : 0);
	}
}
