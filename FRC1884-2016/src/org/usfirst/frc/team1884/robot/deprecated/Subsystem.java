package org.usfirst.frc.team1884.robot.deprecated;

/**
 * 
 * @author Will
 * @deprecated A relic from our early days of programming, the Subsystem interface was made out of one stubborn man's quest to find standardization amongst subsystems.
 */
public interface Subsystem {
	public void autonomousInit();

	public void autonomousPeriodic();

	public void teleopInit();

	public void teleopPeriodic();
}
