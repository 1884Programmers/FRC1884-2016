package org.usfirst.frc.team1884.robot.subsystems;

public class Proportional {

	private double kp;
	private double setpoint;
	private double error;

	public Proportional(double kp, double setpoint) {
		this.kp = kp;
		this.setpoint = setpoint;
	}

	public double getOutput(double processValue) {
		error = processValue - setpoint;
		return error * kp;
	}
}
