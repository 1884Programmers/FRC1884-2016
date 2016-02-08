
package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.subsystems.Elevator;
import org.usfirst.frc.team1884.robot.subsystems.Hanger;
import org.usfirst.frc.team1884.robot.subsystems.Shooter;
import org.usfirst.frc.team1884.robot.subsystems.Subsystem;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	private Subsystem[] subsystems = { Elevator.INSTANCE, Hanger.INSTANCE, Shooter.INSTANCE,
			WestCoastGearbox.INSTANCE };

	public void robotInit() {
	}

	/**
	 * This function is called once at the beinning of autonomous
	 */
	public void autonomousInit() {
		for(Subsystem s : subsystems) {
			s.autonomousInit();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		for (Subsystem s : subsystems) {
			s.autonomousPeriodic();
		}
	}

	/**
	 * This function is called once at the beginning of operator control
	 */
	public void teleopInit() {
		for (Subsystem s : subsystems) {
			s.teleopInit();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		for (Subsystem s : subsystems) {
			s.teleopPeriodic();
		}
	}
}
