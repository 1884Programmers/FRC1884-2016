package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.TalonSRX;

public class Shooter {
	private final static double KP = 1.0;
	private final static double SETPOINT = 29000.0;
	private CANTalon intake, shooter;
	public final Proportional p;

	public final static Shooter INSTANCE;

	static {
		INSTANCE = new Shooter();
	}

	private Shooter() {
		intake = new CANTalon(4);
		shooter = new CANTalon(5);
		p = new Proportional(KP, SETPOINT);
	}

	private void shoot() {
		//p.getOutput();
	}
}
