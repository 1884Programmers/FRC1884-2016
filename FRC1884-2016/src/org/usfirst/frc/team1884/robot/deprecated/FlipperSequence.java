package org.usfirst.frc.team1884.robot.deprecated;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
@Deprecated
public class FlipperSequence extends CommandGroup {
    public  FlipperSequence() {
        addSequential(new FlipperUp());
        addSequential(new FlipperDown());
    }
}
