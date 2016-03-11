package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Spike extends Subsystem {

	public final static Spike INSTANCE;

	private Relay relay;

	static {
		INSTANCE = new Spike();
	}

	private Spike() {
		relay = new Relay(0);
	}

	public void turnOn() {
		relay.set(Relay.Value.kForward);
	}

	public void turnOff() {
		relay.set(Relay.Value.kOff);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
