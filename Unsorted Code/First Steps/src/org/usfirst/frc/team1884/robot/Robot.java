
package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.IterativeRobot;  

import org.usfirst.frc.team1884.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;
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
		
	private DoubleSolenoid extendingPiston;
	
	
	private long timeOfLastExtension;
	
	private final static long kExtensionTime = 800;
	
	CANTalon frontLeft, frontRight, backLeft, backRight;
	Joystick joystick;
    public void robotInit() {
    	frontLeft = new CANTalon(6);
    	frontRight = new CANTalon(4);
    	backLeft = new CANTalon(3);
    	backRight = new CANTalon(5);
    	joystick = new Joystick(0);
    	
    	extendingPiston = new DoubleSolenoid(0, 1);
    	// 0, 1: Left 1, Left 2
    	// 2, 3: Right 1, Right 2
    	// 4 & 5: In take
    	// 7 & 8: Other    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        double y_magnitude = joystick.getY();
        double x_magnitude = joystick.getX();
        double z_magnitude = joystick.getTwist();
        frontLeft.set(-y_magnitude-x_magnitude-z_magnitude);
        frontRight.set(y_magnitude-x_magnitude-z_magnitude);
        backLeft.set(-y_magnitude+x_magnitude-z_magnitude);
        backRight.set(-y_magnitude-x_magnitude+z_magnitude);
        
        joystick.getTrigger();
      
        if (joystick.getRawButton(1)) {
        	extendingPiston.set(DoubleSolenoid.Value.kForward);
        	// Can't call reverse right away cause it wouldn't extend fully before reversing
        	timeOfLastExtension = System.currentTimeMillis();
        	
        }
        
        if (System.currentTimeMillis() - timeOfLastExtension > kExtensionTime){
        	extendingPiston.set(DoubleSolenoid.Value.kOff);
        	timeOfLastExtension = Long.MAX_VALUE;
        	
        }
        
        if (joystick.getRawButton(1)) {
        	Shooter.instance.startWheels();
        
        } else {
        	
        	Shooter.instance.stopWheels();
        
        }
        

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
