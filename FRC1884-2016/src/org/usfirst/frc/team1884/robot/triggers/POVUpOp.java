package org.usfirst.frc.team1884.robot.triggers;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class POVUpOp extends Trigger {
    
    public boolean get() {
        if(NEXUS.OPERATORSTICK.getPOV() == 0)
        	return true;
        else
        	return false;
    }
}
