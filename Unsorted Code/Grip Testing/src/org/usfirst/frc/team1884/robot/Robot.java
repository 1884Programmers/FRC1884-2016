package org.usfirst.frc.team1884.robot;

import java.io.IOException; 
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	private final static String[] GRIP_ARGS = new String[] {"/usr/local/frc/JRE/bin/java",
			"-jar", "/home/lvuser/grip.jar", "/home/lvuser/Vision Tracking M2.grip"};

	private final NetworkTable grip = NetworkTable.getTable("grip");

	@Override
	public void robotInit() {
		/* Run GRIP in a new process */
		System.out.println("debug");
		try {
			Runtime.getRuntime().exec(GRIP_ARGS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void autonomousPeriodic() {
		/* Get published values from GRIP using NetworkTables */
		for (double area : grip.getNumberArray("targets/area", new double[0])) {
			System.out.println("Got contour with area=" + area);
			SmartDashboard.putString("DB/String 0", Double.toString(area));
		}
		Timer.delay(0.005);
	}
}