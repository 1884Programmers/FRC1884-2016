package org.usfirst.frc.team1884.robot.autonomous;

import org.usfirst.frc.team1884.robot.deprecated.AutoFlip;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PortcullisRoutine extends CommandGroup {

	public  PortcullisRoutine() {
        addSequential(new Raise());
        addSequential(new AutoFlip());
        addSequential(new AimSequence());
    }
}
