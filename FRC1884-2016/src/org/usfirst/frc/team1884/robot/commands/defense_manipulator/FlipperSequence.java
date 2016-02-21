package org.usfirst.frc.team1884.robot.commands.defense_manipulator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FlipperSequence extends CommandGroup {
    
    public  FlipperSequence() {
        addSequential(new FlipperUp());
        addSequential(new FlipperDown());
        addSequential(new FlipperReset());
    }
}
