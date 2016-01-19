package org.usfirst.frc.team1884.robot;

import java.io.IOException;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Robot extends IterativeRobot {

	private final static String[] GRIP_ARGS = new String[] { "/usr/local/frc/JRE/bin/java", "-jar",
			"/home/lvuser/grip.jar", "/home/lvuser/Rudimentary Vision Tracking.grip" };

	private final NetworkTable grip = NetworkTable.getTable("grip");

	@Override
	public void robotInit() {
		/* Run GRIP in a new process */
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
		}
	}
}