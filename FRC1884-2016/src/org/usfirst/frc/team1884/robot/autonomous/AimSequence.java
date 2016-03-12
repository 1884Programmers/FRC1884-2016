package org.usfirst.frc.team1884.robot.autonomous;

import org.usfirst.frc.team1884.robot.commands.Aim;
import org.usfirst.frc.team1884.robot.deprecated.FlipperDown;
import org.usfirst.frc.team1884.robot.deprecated.FlipperReset;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AimSequence extends CommandGroup {
    
    public  AimSequence() {
    	addSequential(new FlipperDown());
    	addParallel(new Aim(), 10);
    	addSequential(new FlipperReset());
    }
}
