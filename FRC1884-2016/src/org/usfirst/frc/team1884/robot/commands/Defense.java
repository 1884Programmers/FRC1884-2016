package org.usfirst.frc.team1884.robot.commands;

import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.Timer;

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
			WestCoastGearbox.INSTANCE.setMotorSpeed(0.25, 0.25);
			Timer.delay(1);
			
			//Breach Defense
			
			//safety
			WestCoastGearbox.INSTANCE.setMotorSpeed(0, 0);
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
			System.out.println("You absolute numpty!\nWhy the hell am I in front of the drawbridge?!");
			break;
		case SALLYPORT:
			WestCoastGearbox.INSTANCE.setMotorSpeed(0.25, 0.25);
			Timer.delay(1);
			
			//Breach Defense
			
			//safety
			WestCoastGearbox.INSTANCE.setMotorSpeed(0, 0);
			break;
		case CHEVALDEFRISE:
			WestCoastGearbox.INSTANCE.setMotorSpeed(0.25, 0.25);
			Timer.delay(1);
			
			//Breach Defense
			
			//safety
			WestCoastGearbox.INSTANCE.setMotorSpeed(0, 0);
			break;
		}
	}
}
