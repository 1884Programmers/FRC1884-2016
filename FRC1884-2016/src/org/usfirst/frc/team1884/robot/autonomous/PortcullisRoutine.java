package org.usfirst.frc.team1884.robot.autonomous;

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
