package org.usfirst.frc.team1884.robot.deprecated;

import org.usfirst.frc.team1884.robot.NEXUS;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;

@Deprecated
public class AlignBot extends IterativeRobot {
	Joystick opStick;
	JoystickButton button1;
	
	public void robotInit() {
		opStick = NEXUS.OPERATORSTICK;
		button1 = new JoystickButton(opStick, 1);
	}

	public void teleopInit() {
		button1.whenPressed(new Aim());
	}
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
