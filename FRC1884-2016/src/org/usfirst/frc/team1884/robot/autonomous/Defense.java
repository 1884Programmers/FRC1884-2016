package org.usfirst.frc.team1884.robot.autonomous;

import org.usfirst.frc.team1884.robot.subsystems.Elevator;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Defense implements Choices {

	private int defense;

	public static final int PORTCULLIS = 0;
	public static final int CHEVALDEFRISE = 1;
	public static final int MOAT = 2;
	public static final int RAMPARTS = 3;
	public static final int DRAWBRIDGE = 4;
	public static final int SALLYPORT = 5;
	public static final int ROCKWALL = 6;
	public static final int ROUGHTERRAIN = 7;

	public Defense(int defense) {
		this.defense = defense;
	}

	public int getDefense() {
		return defense;
	}

	public void start() {
		switch (defense) {
		case PORTCULLIS:
			// Start with the arm down and carriage down
			WestCoastGearbox.INSTANCE.setMotorSpeed(-0.25, 0.25);
			Timer.delay(1);

			// Breach Defenses(Raise drawbridge, flip up, drive through)
			while (Elevator.INSTANCE.raiseCarriageAuto()) {
			}
			Elevator.INSTANCE.flipAuto();
			WestCoastGearbox.INSTANCE.setMotorSpeed(-0.25, 0.25);
			Timer.delay(0.75);
			Elevator.INSTANCE.flipReset();
			WestCoastGearbox.INSTANCE.setMotorSpeed(0, 0);
			while (Elevator.INSTANCE.lowerCarriageAuto()) {
			}
			break;
		case ROUGHTERRAIN:
		case MOAT:
		case RAMPARTS:
		case ROCKWALL:
			WestCoastGearbox.INSTANCE.setMotorSpeed(-1, 1);
			Timer.delay(2);

			// safety
			WestCoastGearbox.INSTANCE.setMotorSpeed(0, 0);
			break;
		case DRAWBRIDGE:
			SmartDashboard.putString("Defense Errors",
					"You absolute numpty! Why the hell am I in front of the drawbridge?!");
			break;
		case SALLYPORT:
			SmartDashboard.putString("Defense Errors",
					"I was promised that I would never do the sally port in autonomous");
			break;
		case CHEVALDEFRISE:
			// Start the robot with the arm up and the carriage down
			WestCoastGearbox.INSTANCE.setMotorSpeed(-0.25, 0.25);
			Timer.delay(1);

			// Breach Defense (lower arm, drive forwards)
			while (Elevator.INSTANCE.lowerCarriageAuto()) {
			}
			WestCoastGearbox.INSTANCE.setMotorSpeed(-0.25, 0.25);
			Timer.delay(0.75);

			// safety
			WestCoastGearbox.INSTANCE.setMotorSpeed(0, 0);
			break;
		}
	}
}
