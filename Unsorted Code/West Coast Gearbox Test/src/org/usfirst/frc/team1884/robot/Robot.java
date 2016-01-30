
package org.usfirst.frc.team1884.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you coutpute the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	RobotDrive drive;
	VictorSP rightSide, leftSide;
	Joystick joystick;
	DoubleSolenoid outputPush, PTOPush;
	boolean toutput = false;
	
	boolean tPTO = false;
	
	long timeOfLastExtensionoutput = Long.MAX_VALUE;
	long timeOfLastExtensionPTO = Long.MAX_VALUE;
	
	long lastoutputButtonExtend = 0;
	long lastoutputButtonRetract = 0;
	long lastPTOButtonExtend = 0;
	long lastPTOButtonRetract = 0;
	
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	leftSide = new VictorSP(0);
    	rightSide = new VictorSP(1);
    	
    	drive = new RobotDrive(leftSide, rightSide);
    	
    	joystick = new Joystick(0);
    	
    	outputPush = new DoubleSolenoid(0,1);
    	PTOPush = new DoubleSolenoid(2,3);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	drive.arcadeDrive(joystick);
    	
    	
    	if(joystick.getRawButton(1) && outputPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastoutputButtonExtend > 200) {
    		outputPush.set(DoubleSolenoid.Value.kForward);
    		lastoutputButtonExtend = System.currentTimeMillis();
    		timeOfLastExtensionoutput = System.currentTimeMillis();
    	}
    	if(joystick.getRawButton(2) && PTOPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastPTOButtonExtend > 200) {
    		PTOPush.set(DoubleSolenoid.Value.kForward);
    		lastPTOButtonExtend = System.currentTimeMillis();
    		timeOfLastExtensionPTO = System.currentTimeMillis();
    	}
    	if(joystick.getRawButton(3) && outputPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastoutputButtonRetract > 200) {
    		outputPush.set(DoubleSolenoid.Value.kReverse);
    		lastoutputButtonRetract = System.currentTimeMillis();
    		timeOfLastExtensionoutput = System.currentTimeMillis();
    	}
    	if(joystick.getRawButton(4) && PTOPush.get() == DoubleSolenoid.Value.kOff && System.currentTimeMillis() - lastPTOButtonRetract > 200) {
    		tPTO = !tPTO;
    		PTOPush.set(DoubleSolenoid.Value.kReverse);
    		lastPTOButtonRetract = System.currentTimeMillis();
    		timeOfLastExtensionPTO = System.currentTimeMillis();
    	}
    	
    	
    	if (System.currentTimeMillis() - timeOfLastExtensionoutput > 1000) {
    		outputPush.set(DoubleSolenoid.Value.kOff);
    		timeOfLastExtensionoutput = Long.MAX_VALUE;
    	}
    	if (System.currentTimeMillis() - timeOfLastExtensionPTO > 1000) {
    		PTOPush.set(DoubleSolenoid.Value.kOff);
    		timeOfLastExtensionPTO = Long.MAX_VALUE;
    	}
    }
}
