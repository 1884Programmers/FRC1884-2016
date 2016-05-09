package org.usfirst.frc.team1884.robot.deprecated;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
@Deprecated
public class AimSequence extends CommandGroup {
    
    public  AimSequence() {
    	addSequential(new FlipperDown());
    	addParallel(new Aim(), 10);
    	addSequential(new FlipperReset());
    }
}
