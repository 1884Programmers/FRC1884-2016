package org.usfirst.frc.team1884.robot.triggers;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class LeftTrigger extends Trigger {
    Joystick joystick;
    public LeftTrigger(int port) {
    	if(port == 0) {
    		joystick = NEXUS.DRIVESTICK;
    	} else {
    		joystick = NEXUS.OPERATORSTICK;
    	}
    }
	
    public boolean get() {
        return joystick.getRawAxis(2) > 0.1;
    }
}
