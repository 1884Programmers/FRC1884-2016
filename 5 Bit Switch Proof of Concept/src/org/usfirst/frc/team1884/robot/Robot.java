
package org.usfirst.frc.team1884.robot;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	FiveBitSwitch fiveBit;
	
	Relay ledToggle;
	
	FieldPosition fieldPos;
	
	FieldObstacle fieldObs;
	
//	DigitalInput port0, port1, port2, port3, port4;
	
	
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	fiveBit = FiveBitSwitch.fiveBitSwitch;
    	ledToggle = new Relay(0);
//    	port0 = new DigitalInput(0);
//    	port1 = new DigitalInput(1);
//    	port2 = new DigitalInput(2);
//    	port3 = new DigitalInput(3);
//    	port4 = new DigitalInput(4);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	fieldPos = fiveBit.getFieldPosition();
    	fieldObs = fiveBit.getFieldObstacle();
    	SmartDashboard.putString("DB/String 0", fieldObs.toString());
    	SmartDashboard.putString("DB/String 1", fieldPos.toString());
    	if(fieldPos == FieldPosition.pos1 && fieldObs == FieldObstacle.Portcullis) {
    		ledToggle.set(edu.wpi.first.wpilibj.Relay.Value.kForward);
    	} else {
    		ledToggle.set(edu.wpi.first.wpilibj.Relay.Value.kOff);
    	}
//    	SmartDashboard.putString("DB/String 0", Boolean.toString(port0.get()));
//    	SmartDashboard.putString("DB/String 1", Boolean.toString(port1.get()));
//    	SmartDashboard.putString("DB/String 2", Boolean.toString(port2.get()));
//    	SmartDashboard.putString("DB/String 3", Boolean.toString(port3.get()));
//    	SmartDashboard.putString("DB/String 4", Boolean.toString(port4.get()));
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
