package org.usfirst.frc.team1884.robot.debug;

public class Test {

	public static void main(String[] args) {
		FiveBitSwitch fiveSwitch = FiveBitSwitch.fiveBitSwitch;
		for(;;) {
			System.out.println(fiveSwitch.getFieldObstacle());
			System.out.println(fiveSwitch.getFieldPosition());
		}
	}

}
