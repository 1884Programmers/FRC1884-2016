package org.usfirst.frc.team1884.robot.subsystems;

public class ProportionalIntegral extends Proportional {
	double integral = 0;

	public ProportionalIntegral(double kp, double ki, double setpoint) {
		super(kp, setpoint);
	}

	@Override
	public double getOutput(double processValue) {
		double x = super.getOutput(processValue);
		integral += getError() * 0.005;
		return x + integral;
	}
}
