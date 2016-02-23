package org.usfirst.frc.team1884.robot.triggers;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class POVDownOp extends Trigger {
    
    public boolean get() {
    	if(NEXUS.OPERATORSTICK.getPOV() == 180)
        	return true;
        else
        	return false;
    }
}
