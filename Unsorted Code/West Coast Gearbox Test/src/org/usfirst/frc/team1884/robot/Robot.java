
package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.subsystem.WestCoastGearbox;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you compute the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	WestCoastGearbox gearbox;
	Joystick joystick;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	joystick = new Joystick(0);
    	gearbox = WestCoastGearbox.instance;
    	gearbox.setJoystick(joystick);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	gearbox.teleopPeriodic();
    }
}
