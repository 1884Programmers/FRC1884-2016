package org.usfirst.frc.team1884.robot.autonomous;

import org.usfirst.frc.team1884.robot.commands.Wait;
import org.usfirst.frc.team1884.robot.commands.defense_manipulator.CarriageHoldTopLimit;
import org.usfirst.frc.team1884.robot.commands.defense_manipulator.FlipperUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoFlip extends CommandGroup {
    
    public  AutoFlip() {
    	addSequential(new AutoFlipSetup());
    	addParallel(new FlipperUp());
    	addParallel(new CarriageHoldTopLimit());
    	addSequential(new Wait(750));
    	addSequential(new AutoFlipReset());
    }
}
