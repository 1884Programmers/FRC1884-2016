package org.usfirst.frc.team1884.robot.triggers;

import org.usfirst.frc.team1884.robot.autonomous.Defense;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class PortcullisChosen extends Trigger {
    
    public boolean get() {
        return Defense.isPortcullis;
    }
}
