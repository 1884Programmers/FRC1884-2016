package org.usfirst.frc.team1884.robot.autonomous;

import org.usfirst.frc.team1884.robot.commands.Aim;
import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperDown;
import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperReset;

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
