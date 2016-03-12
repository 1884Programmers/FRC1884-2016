package org.usfirst.frc.team1884.robot.triggers;

import org.usfirst.frc.team1884.robot.deprecated.Position;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class ExpellBallAuto extends Trigger {
    
    public boolean get() {
    	boolean shoot = Position.shoot;
    	Position.shoot = false;
        return shoot;
    }
}
