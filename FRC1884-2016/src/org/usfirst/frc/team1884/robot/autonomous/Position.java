package org.usfirst.frc.team1884.robot.autonomous;

import org.usfirst.frc.team1884.robot.subsystems.Aimer;
import org.usfirst.frc.team1884.robot.subsystems.GRIP;
import org.usfirst.frc.team1884.robot.subsystems.Shooter;
import org.usfirst.frc.team1884.robot.subsystems.Spike;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Position implements Choices {

	private int position;

	public Position(int position) {
		this.position = position;
	}

	public void start() {
		Spike.INSTANCE.turnOn();
		switch (position) {
		case 1:
			SmartDashboard.putString("Defense Errors",
					"You numpty, what the hell were you thinking when you said I was in front of the lowbar!");
			break;
		case 2:
			while (GRIP.INSTANCE.getCenter() == -1) {
				WestCoastGearbox.INSTANCE.setMotorSpeed(-0.1, -0.1);
			}
			break;
		case 3:// Hopefully already centered
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
		Shooter.INSTANCE.shootAutoActually();
	}

	public int getPosition() {
		return position;
	}

}
