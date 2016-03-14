package org.usfirst.frc.team1884.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoChooser {
	public static void setup() {
		SmartDashboard.putString("DB/String 0", "If \"New Name\"");
		SmartDashboard.putString("DB/String 5", "is lit up");
		SmartDashboard.putString("DB/String 1", "\"No Auto\"");
		SmartDashboard.putString("DB/String 6", "is enabled.");
	}
	
	public static void start() {
		if(SmartDashboard.getBoolean("DB/Button 0")) {
			Command NoAuto = new NoAuto();
			NoAuto.start();
		} else {
			Command easyAuto = new EasyAutonomous();
			easyAuto.start();
		}
	}
}
