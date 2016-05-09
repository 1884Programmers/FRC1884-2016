package org.usfirst.frc.team1884.robot.deprecated;

import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

@Deprecated
public class Position implements Choices {

	private int position;
	public static boolean shoot = false;

	public Position(int position) {
		this.position = position;
	}
	
	public void start() {
		
	}
	
	public void startShoot() {
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
