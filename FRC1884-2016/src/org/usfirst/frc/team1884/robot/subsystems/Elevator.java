package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.nexus.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;;

public class Elevator implements Subsystem {
	private static final Elevator INSTANCE;
	
	private CANTalon lift;
	private Joystick joystick;
	
	static {
		INSTANCE = new Elevator();
	}

	public Elevator() {
		lift = new CANTalon(0);
		joystick = NEXUS.JOYSTICK;
	}

	@Override
	public void autonomousInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void autonomousPeriodic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teleopInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teleopPeriodic() {
		// TODO Auto-generated method stub
		
	}

	}

}
