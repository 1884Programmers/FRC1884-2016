package org.usfirst.frc.team1884.robot.commands;

import org.usfirst.frc.team1884.robot.subsystems.Aimer;
import org.usfirst.frc.team1884.robot.subsystems.GRIP;
import org.usfirst.frc.team1884.robot.subsystems.Shooter;
import org.usfirst.frc.team1884.robot.subsystems.Spike;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

public class Position implements Choices {

	private int position;

	public Position(int position) {
		this.position = position;
	}

	public void start() {
		Spike.INSTANCE.turnOn();
		switch (position) {
		case 1:
			System.out.println(
					"You numpty, what the hell were you thinking when you said I was in front of the lowbar!"
					+ "\nI refuse to attempt to center!");
			break;
		case 2:
			while (GRIP.INSTANCE.getCenter() == -1) {
				WestCoastGearbox.INSTANCE.setMotorSpeed(-0.1, -0.1);
			}
			break;
		case 3:
			break; // hopefully already centered
		case 4:
		case 5:
			while (GRIP.INSTANCE.getCenter() == -1) {
				WestCoastGearbox.INSTANCE.setMotorSpeed(0.1, 0.1);
			}
			break;
		default:
			break;
		}
		Aimer.INSTANCE.alignAuto();
		Shooter.INSTANCE.shoot();
	}

	public int getPosition() {
		return position;
	}

}
