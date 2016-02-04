package org.usfirst.frc.team1884.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;

public class Spike {

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

}
