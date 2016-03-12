package org.usfirst.frc.team1884.robot.deprecated;

@Deprecated
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

	public double getError() {
		return error;
	}

	public void setError(double error) {
		this.error = error;
	}

	public double getSetpoint() {
		return setpoint;
	}

	public void setSetpoint(double setpoint) {
		this.setpoint = setpoint;
	}
}
