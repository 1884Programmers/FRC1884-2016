package org.usfirst.frc.team1884.robot.subsystems;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;;

public class Elevator {
	public static final Elevator INSTANCE;

	private static int LIFT_CHANNEL = 0;
	private static int FLIP_CHANNEL = 2;

	private CANTalon lift, flip;
	private Joystick joystick;

	static {
		INSTANCE = new Elevator();
	}

	public Elevator() {
		lift = new CANTalon(LIFT_CHANNEL);
		flip = new CANTalon(FLIP_CHANNEL);
		joystick = NEXUS.OPERATORSTICK;
	}

	public void teleopInit() {
		// TODO Auto-generated method stub

	}

	public void teleopPeriodic() {
		lift.set(joystick.getY());
		if(joystick.getPOV(0) == 0) {
			flip.set(0.25);
		} else if(joystick.getPOV(0) == 180) {
			flip.set(-0.25);
		}
	}

}
